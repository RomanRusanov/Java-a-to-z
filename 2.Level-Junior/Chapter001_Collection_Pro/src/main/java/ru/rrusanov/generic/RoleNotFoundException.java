package ru.rrusanov.generic;
/**
 * If user id not presented in store.
 *
 * @author Roman Rusanov
 * @version 0.1
 * @since 07.06.18
 */
public class RoleNotFoundException extends RuntimeException {
    /**
     * Constructor return to parent string with exception.
     * @param msg String message.
     */
    public RoleNotFoundException(String msg) {
        super(msg);
    }
}