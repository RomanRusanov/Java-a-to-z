package ru.rrusanov;
import java.util.Scanner;

/**
 * A class implements an input from console.
 *
 * @author Roman Rusanov
 * @version 0.1
 * @since 24.01.17
 */
public class ConsoleInput {
    /**
     * The field contain instance for capture system in.
     */
    private Scanner scanner = new Scanner(System.in);
    /**
     * Input from console to string value.
     * @param question print message for user
     * @return string what user enter from console
     */
    public String ask(String question) {
        System.out.printf("%n%s", question);
        return scanner.nextLine();
    }

}