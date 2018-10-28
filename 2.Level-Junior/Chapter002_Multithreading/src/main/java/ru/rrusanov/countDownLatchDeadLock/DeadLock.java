package ru.rrusanov.countDownLatchDeadLock;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 28.10.2018
 *
 * The class demonstrate example with deadlock using CountDownLatch for synchronizing.
 * A thread put in collection, but collection size range 1 element, and then thread A wait when thread B take element,
 * thread B wait when thread a release await calling countDown on lock instance.
 */
public class DeadLock {
    /**
     * The main method.
     * @param args console arguments.
     */
    public static void main(String[] args) {
        CountDownLatch lock = new CountDownLatch(1);
        ArrayBlockingQueue queue = new ArrayBlockingQueue(1);
        new Thread(new A(lock, queue)).start();
        new Thread(new B(lock, queue)).start();
    }
}
