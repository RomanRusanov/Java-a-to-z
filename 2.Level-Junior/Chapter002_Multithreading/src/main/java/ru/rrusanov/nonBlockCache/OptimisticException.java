package ru.rrusanov.nonBlockCache;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 08.09.2018
 *
 * The class describe exception.
 */
public class OptimisticException extends RuntimeException {
    /**
     * The defalut constructor.
     * @param msg message.
     */
    public OptimisticException(String msg) {
        super(msg);
    }
}
