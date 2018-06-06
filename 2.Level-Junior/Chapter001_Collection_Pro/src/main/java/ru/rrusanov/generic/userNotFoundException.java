package ru.rrusanov.generic;
/**
 * If user id not presented in store.
 *
 * @author Roman Rusanov
 * @version 0.1
 * @since 05.06.18
 */
public class userNotFoundException extends RuntimeException {
    /**
     * Construcor return to parent string with exception.
     * @param msg String message.
     */
    public userNotFoundException(String msg) {
        super(msg);
    }
}
