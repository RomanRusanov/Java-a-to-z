package ru.rrusanov;
/**
 * Possibly wrong value x,y for create cell.
 * @author Roman Rusanov
 * @version 0.1
 * @since 13.11.17
 */
public class ImpossibleCreateCellException extends Exception {
    /**
     * Constructor for class using parent constructor.
      */
    ImpossibleCreateCellException(String msg) {
        super(msg);
    }
}
