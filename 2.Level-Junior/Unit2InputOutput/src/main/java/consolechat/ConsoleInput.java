package consolechat;
import java.util.Scanner;
/**
 * A class implements an input from console.
 *
 * @author Roman Rusanov
 * @version 0.1
 * @since 24.01.17
 */
public class ConsoleInput implements Input {
    /**
     * The filed for capture system in.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * The method take string and out to console.
     * Return what user type from console.
     * @param question print message for user
     * @return string what user enter from console
     */
    public String ask(String question) {
        System.out.printf("%s ", question);
        return scanner.nextLine();
    }
}