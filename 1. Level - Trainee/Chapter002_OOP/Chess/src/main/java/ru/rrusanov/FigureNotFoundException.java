package ru.rrusanov;
/**
 * If source cell not have figure exist.
 * @author Roman Rusanov
 * @version 0.1
 * @since 14.11.17
 */
public class FigureNotFoundException extends RuntimeException {
    /**
     * Constructor for class using parent constructor.
     * @param msg Message describe error.
     */
    FigureNotFoundException(String msg) {
        super(msg);
    }
}
