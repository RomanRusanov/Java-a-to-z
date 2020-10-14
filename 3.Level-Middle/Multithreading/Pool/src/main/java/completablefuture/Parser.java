package completablefuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 07.10.2020
 * email roman9628@gmail.com
 * The class parse file from disk and run some async process.
 *
 * Задание:
 * Есть файл на 1 млн. записей, файл во вложении. В нем указаны рейтинги участников
 * конкурса из разных стран. Записи идут следующим образом. 1000 записей участников
 * из одной страны, далее 1000 записей участников из другой страны и т.д.
 * Ваша задача - данные участников каждой страны, т.е. для каждой 1000 записей файла:
 * source.txt
 *
 * - записать в файл txt. Название файла - это страна. Например, example.txt,
 *   будет хранить только записи участников из example;
 * - отправить в БД. Страну нужно занести в таблицу стран,
 *   а участников - в таблицу участников;
 * - отправить данные через сокет на локальный сервер.
 *   Сервер тоже должен работать на сокетах;
 *
 * Все три задачи должны выполняться асинхронно.
 * Основной поток занимается парсингом исходного файла.
 *
 * На имена участников и стран не обращать внимание. Файл сгенерирован программно.
 */
public class Parser {
    /**
     * The instance with logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(Parser.class.getName());
    /**
     * The field contain regex to check lines.
     */
    private static final String REGEX = "^[^ ](.+[^ ]) +([^ ].+[^ ]) +([^ ].+[^ ]) +(\\d+)( +)?$";
    /**
     * The field contain compiled pattern.
     */
    private static final Pattern PATTERN = Pattern.compile(REGEX);
    /**
     * The field contain instance with config params pairs.
     */
    private final Config config;
    /**
     * The field contain instance that store parsed data to local disk.
     */
    private final ToFiles toFiles;
    /**
     * The field contain instance that store parsed data to DB.
     */
    private final ToDB toDB;
    /**
     * The field contain instance that send parsed data to server and store.
     */
    private final ToServer toServer;
    /**
     * The field contain instance that store parsed data.
     */
    private static final Map<String, String[]> COUNTRIES = new HashMap<>();
    /**
     * The filed contain value complete async work insert to DB.
     */
    private volatile boolean toDBResult;
    /**
     * The filed contain value complete async work write on disk.
     */
    private volatile boolean toFilesResult;
    /**
     * The filed contain value complete async work send to server.
     */
    private volatile boolean toServerResult;

    /**
     * The default constructor.
     * @param toServer instance that send parsed data to server and store.
     * @param toDB instance that send parsed data to server and store.
     * @param toFiles instance that store parsed data to local disk.
     * @param config instance with config params pairs.
     */
    public Parser(ToServer toServer, ToDB toDB, ToFiles toFiles, Config config) {
        this.config = config;
        this.toServer = toServer;
        this.toDB = toDB;
        this.toFiles = toFiles;
    }

    /**
     * The getter for collection field.
     * @return Entry set.
     */
    public static Set<Map.Entry<String, String[]>> getEntrySet() {
        return COUNTRIES.entrySet();
    }

    /**
     * The method parse data in HashMap countries.
     */
    public void reader() {
        LOG.info("Start Parse.");
        try (BufferedReader in = new BufferedReader(
                new FileReader(this.config.value("source")))) {
            in.readLine();
            String currentRecord;
            while (in.ready()) {
                for (int i = 0; i < 1000; i++) {
                    currentRecord = in.readLine();
                    if (!this.isValidRecord(currentRecord)) {
                        currentRecord = "----------  ----------  ----------  ---";
                    }
                    String countryName = Parser.getCountryName(currentRecord);
                    if (!COUNTRIES.containsKey(countryName)) {
                        COUNTRIES.put(countryName, new String[1000]);
                    }
                    COUNTRIES.get(countryName)[i] = currentRecord;
                }
            }
        } catch (Exception e) {
            LOG.error("Can't parse source file from disk.", e);
        }
        LOG.info("Complete Parse.");
    }

    /**
     * The method chek string match pattern regex.
     * @param currentLine String for check.
     * @return If match return true, otherwise false.
     */
    public boolean isValidRecord(String currentLine) {
        if (!PATTERN.matcher(currentLine).find()) {
            throw new IllegalStateException(String.format(
                    "The record not correct(%s) in file: %s "
                            + "Example(First_name Last_name Country rating)",
                    currentLine, this.config.value("source")));
        }
        return true;
    }

    /**
     * The method start async work.
     * After all data parse to local collection countries:
     * - ToFile store each country to one file and
     *   write in all participants in that country.
     * - ToDB store all data in DB.
     * - ToServer send to server socket, and server receive
     *   and store in local collection.
     */
    public void init() {
        new Thread(() -> {
            try {
                this.toDBResult = this.toDB.insertInDB().get();
            } catch (InterruptedException | ExecutionException e) {
                LOG.error("Thread with async work insert to DB failed.", e);
            }
        }).start();
        new Thread(() -> {
            try {
                this.toFilesResult = this.toFiles.writeToDisk().get();
            } catch (InterruptedException | ExecutionException e) {
                LOG.error("Thread with async work write to disk failed.", e);
            }
        }).start();
        new Thread(() -> {
            try {
                this.toServerResult = this.toServer.initServer().get();
            } catch (InterruptedException | ExecutionException e) {
                LOG.error("Thread with async work send to server failed.", e);
            }
        }).start();
        new Thread(() -> this.toServer.initClient().join()).start();
    }

    /**
     * The method check all task complete.
     * @return if all async works complete return true.
     */
    public boolean isWorkComplete() {
        return this.toDBResult && this.toServerResult && this.toFilesResult;
    }

    /**
     * The method parse string and get group 3 in regex. This is
     * country name.
     * @param record String to parse.
     * @return String captured group.
     */
    public static String getCountryName(String record) {
        Matcher matcher = PATTERN.matcher(record);
        matcher.find();
        return matcher.group(3);
    }

    /**
     * The method parse string and get group 4 in regex. This is
     * rating value.
     * @param record String to parse.
     * @return String captured group.
     */
    public static String getRatingValue(String record) {
        Matcher matcher = PATTERN.matcher(record);
        matcher.find();
        return matcher.group(4);
    }

    /**
     * The method parse string and get group 1 in regex. This is
     * first name.
     * @param record String to parse.
     * @return String captured group.
     */
    public static String getFirstName(String record) {
        Matcher matcher = PATTERN.matcher(record);
        matcher.find();
        return matcher.group(1);
    }

    /**
     * The method parse string and get group 2 in regex. This is
     * last name.
     * @param record String to parse.
     * @return String captured group.
     */
    public static String getLastName(String record) {
        Matcher matcher = PATTERN.matcher(record);
        matcher.find();
        return matcher.group(2);
    }

    /**
     * The main method.
     * @param args Passed args.
     */
    public static void main(String[] args) {
        Config config = new Config(Path.of(
                "3.Level-Middle/Multithreading/Pool/data/app.properties"));
        config.load();
        ToServer toServer = new ToServer(config);
        ToDB toDB = new ToDB(config, false);
        ToFiles toFiles = new ToFiles(config);
        Parser parser = new Parser(toServer, toDB, toFiles, config);
        parser.reader();
        parser.init();
    }
}