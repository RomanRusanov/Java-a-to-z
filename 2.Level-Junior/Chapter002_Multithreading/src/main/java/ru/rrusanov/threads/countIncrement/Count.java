package ru.rrusanov.threads.countIncrement;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 14.08.2018
 *
 * The class describe counter with increment.
 * ThreadSafe JCIP Lib mark that class uses concurrency structure.
 */
@ThreadSafe
public class Count {
    /**
     * The field contain counter value.
     */
    @GuardedBy("this")
    private int value;
    /**
     * The method set field value = value + 1.
     */
    public synchronized void increment() {
        this.value++;
    }
    /**
     * The method getter for field value.
     * @return the value of field count.
     */
    public synchronized int getValue() {
        return value;
    }
}
