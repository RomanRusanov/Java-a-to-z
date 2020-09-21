package synchronizesharedresources;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 21.09.2020
 * email roman9628@gmail.com
 * The class Example.
 */
public class Count {
    /**
     * The field contain value that two threads change.
     */
    private int value;

    /**
     * The method increment field value.
     */
    public synchronized void increment() {
        value++;
    }

    /**
     * The method getter for field.
     *
     * @return int value.
     */
    public synchronized int get() {
        return value;
    }
}