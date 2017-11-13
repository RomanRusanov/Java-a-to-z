package ru.rrusanov;
/**
 * If destination cell busy or on way exist other figure generate exception.
 * @author Roman Rusanov
 * @version 0.1
 * @since 13.11.17
 */
public class ImpossibleMoveException extends RuntimeException {
    /**
     * Constructor for class using parent constructor.
     */
    ImpossibleMoveException(String msg) {
        super(msg);
    }
}
