package consolechat;
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
     * The field contain state when chat must stop pass random stings.
     */
    private Boolean stop = false;

    /**
     * The default constructor.
     * @param fileLog File where save all dialog.
     * @param fileWithAnswers File with all answers to user.
     */
    public Chat(File fileLog, File fileWithAnswers) {
        this.log = new ArrayList<>();
        this.work = true;
        this.fileLog = fileLog;
        this.fileWithAnswers = fileWithAnswers;
        this.allAnswers = this.loadAnswers(this.fileWithAnswers);
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
     * The getter for field.
     * @return List with all chat log.
     */
    public List<String> getLog() {
        return log;
    }

    /**
     * The getter for field.
     * @return File where save all dialog.
     */
    public File getFileLog() {
        return fileLog;
    }

    /**
     * The getter for field.
     * @return Boolean.
     */
    public Boolean getStop() {
        return stop;
    }

    /**
     * The setter for field.
     * @param stop Boolean.
     */
    public void setStop(Boolean stop) {
        this.stop = stop;
    }

    /**
     * The getter for field.
     * @return Boolean.
     */
    public Boolean getWork() {
        return work;
    }

    /**
     * The setter for field.
     * @param work Boolean.
     */
    public void setWork(Boolean work) {
        this.work = work;
    }
}