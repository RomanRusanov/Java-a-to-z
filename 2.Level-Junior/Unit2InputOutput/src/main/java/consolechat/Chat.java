package consolechat;
import bufferedoutputstream.LogFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 12.08.2020
 * email roman9628@gmail.com
 * The class implements chat behavior.
 *
 * Создать программу 'Консольный чат'. Пользователь вводит слово-фразу,
 * программа берет случайную фразу из текстового файла и выводит в ответ.
 * Программа замолкает если пользователь вводит слово «стоп», при этом он
 * может продолжать отправлять сообщения в чат. Если пользователь вводит слово
 * «продолжить», программа снова начинает отвечать. При вводе слова «закончить»
 * программа прекращает работу. Запись диалога включая, слова-команды
 * стоп/продолжить/закончить записать в текстовый лог.
 */
public class Chat {
    /**
     * The field contain instance of input(console or stub).
     */
    private Input input;
    /**
     * The field contain collection with all dialog log.
     */
    private List<String> log;
    /**
     * The field contain collection with all answers to user.
     */
    private List<String> allAnswers;
    /**
     * The field contain file where save all dialog.
     */
    private File fileLog;
    /**
     * The field contain file with all answers to user.
     */
    private File fileWithAnswers;
    /**
     * The filed contain value when chat work is down.
     */
    private Boolean work;

    /**
     * The default constructor.
     * @param input Instance of input.
     * @param fileLog File where save all dialog.
     * @param fileWithAnswers File with all answers to user.
     */
    public Chat(Input input, File fileLog, File fileWithAnswers) {
        this.input = input;
        this.log = new ArrayList<>();
        this.work = true;
        this.fileLog = fileLog;
        this.fileWithAnswers = fileWithAnswers;
        this.allAnswers = this.loadAnswers(this.fileWithAnswers);
    }

    /**
     * Base logic for interaction with user.
     */
    public void interaction() {
        Boolean stop = false;
        while (this.work) {
            String userSay = input.ask("Введите фразу:");
            log.add(userSay);
            if (userSay.equals("стоп")) {
                stop = true;
                continue;
            }
            if (userSay.equals("конец")) {
                stop = true;
                this.end();
            }
            if (!stop || userSay.equals("продолжить")) {
                stop = false;
                this.continued();
            }
        }
    }

    /**
     * Main method.
     * @param args String args.
     */
    public static void main(String[] args) {
        File fileLog = new File("./2.Level-Junior/Unit2InputOutput/data/chatlog.txt");
        File fileWithAnswers = new File("./2.Level-Junior/Unit2InputOutput/data/answers.txt");
        Chat chat = new Chat(new ConsoleInput(), fileLog, fileWithAnswers);
        chat.interaction();
    }

    /**
     * The method load all answers from file.
     * @param fileWithAnswers File with all answers to user.
     * @return Collection witch contain all answers.
     */
    public static List<String> loadAnswers(File fileWithAnswers) {
        List<String> allAnswers = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(fileWithAnswers))) {
            allAnswers = in.lines().collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allAnswers;
    }

    /**
     * The method get random string from collection for answers.
     * @return String with answer.
     */
    public String getRandomString() {
        int numberString = new Random().nextInt(allAnswers.size() - 1);
        return this.allAnswers.get(numberString);
    }

    /**
     * The method change behavior of chat if user type "продолжить".
     */
    public void continued() {
        String random = this.getRandomString();
        this.log.add(random);
        System.out.println(random);
    }

    /**
     * The method stop cycle of chat, and save all log to file.
     */
    public void end() {
        this.work = false;
        LogFilter.save(this.log, this.fileLog.toString());
    }
}