package ru.rrusanov.countDownLatchDeadLock;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 28.10.2018
 *
 * The class describe second thread that take from queue.
 */
public class B implements Runnable {
    /**
     * The field contain instance lock.
     */
    private CountDownLatch lock;
    /**
     * The field contain instance for collection.
     */
    private ArrayBlockingQueue<Integer> queue;
    /**
     * The default constructor.
     * @param lock instance lock.
     * @param queue instance collection.
     */
    public B(CountDownLatch lock, ArrayBlockingQueue<Integer> queue) {
        this.lock = lock;
        this.queue = queue;
    }
    /**
     * Thread body.
     */
    @Override
    public void run() {
        try {
            System.out.println("work B before await");
            // await be infinitive, because thread A put one element and wait when thread B take it, and A insert second.
            lock.await();
            System.out.println("work B after await");
            System.out.println("take from queue " + queue.take());
            System.out.println("take from queue " + queue.take());
        } catch (InterruptedException ex) {
            System.out.println("Lock interrupted");
        }
    }
}
