package ru.rrusanov;
/**
 * If way of movement of figure cross another figure.
 * @author Roman Rusanov
 * @version 0.1
 * @since 14.11.17
 */
public class OccupiedWayException extends RuntimeException {
    /**
     * Constructor for class using parent constructor.
     * @param msg Message describe error.
     */
    OccupiedWayException(String msg) {
        super(msg);
    }
}
