package completablefuture;

import threadpool.ThreadPool;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 07.10.2020
 * email roman9628@gmail.com
 * The class .
 */
public class Parser {
    /**
     * The field contain regex to check lines.
     */
    private final static String regex = "^[^ ](.+[^ ]) +([^ ].+[^ ]) +([^ ].+[^ ]) +(\\d+)( +)?$";
    /**
     * The field contain compiled pattern.
     */
    private static final Pattern pattern = Pattern.compile(regex);

    private final Config config = new Config(
            "3.Level-Middle/Multithreading/Pool/src/data/app.properties");

    private final ToFiles toFiles;

    private final ThreadPool myPoolImplements = new ThreadPool();

//    private final ExecutorService poolExec = Executors.newFixedThreadPool(
//            Runtime.getRuntime().availableProcessors());

    public Parser() {
        this.config.load();
        this.toFiles = new ToFiles(Path.of("3.Level-Middle/Multithreading/Pool/src/data/countries/"));
    }

    public void reader() {
        try (BufferedReader in = new BufferedReader(
                new FileReader(this.config.value("source")))) {
            in.readLine();
            String currentRecord;
            String[] currentCountry = new String[1000];
            while (in.ready()) {
                for (int i = 0; i < 1000; i++) {
                    currentRecord = in.readLine();
                    if (!this.isValidRecord(currentRecord)) {
                        currentRecord = "----------  ----------  ----------  ---";
                    }
                    currentCountry[i] = currentRecord;
                }
                this.initSyncWork(currentCountry);
//                System.out.println("Parse 1 country");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Reader END");
    }

    /**
     * The method chek string match pattern regex.
     * @param currentLine String for check.
     * @return If match return true, otherwise false.
     */
    public boolean isValidRecord(String currentLine) {
        if (!pattern.matcher(currentLine).find()) {
            throw new IllegalStateException(String.format(
                    "The record not correct(%s) in file: %s "
                            + "Example(First_name Last_name Country rating)",
                    currentLine, this.config.value("source")));
        }
        return true;
    }

    public void initSyncWork(String[] records) throws ExecutionException, InterruptedException {
        this.myPoolImplements.work(() -> {
            try {
                this.toFiles.work(records).get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
//        this.toFiles.work(records).get();
    }

    public static String getCountryName(String record) {
        Matcher matcher = pattern.matcher(record);
        matcher.find();
        return matcher.group(3);
    }

    public static void main(String[] args) {
        Parser parser = new Parser();
        parser.reader();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        parser.myPoolImplements.shutdown();
    }
}