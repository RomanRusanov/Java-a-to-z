package ru.rrusanov.collection.generic;
/**
 * If user id not presented in store.
 *
 * @author Roman Rusanov
 * @version 0.1
 * @since 05.06.18
 */
public class NotFoundException extends RuntimeException {
    /**
     * Construcor return to parent string with exception.
     * @param msg String message.
     */
    public NotFoundException(String msg) {
        super(msg);
    }
}
