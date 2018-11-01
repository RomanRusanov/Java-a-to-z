package ru.rrusanov.countDownLatchDeadLock;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 28.10.2018
 *
 * The class describe first thread that put in queue.
 */
public class A implements Runnable {
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
    public A(CountDownLatch lock, ArrayBlockingQueue<Integer> queue) {
        this.lock = lock;
        this.queue = queue;
    }
    /**
     * Thread body.
     */
    @Override
    public void run() {
        try {
            queue.put(1);
            // Entering to deadlock;
            queue.put(2);
            // deadlock accepted
            System.out.println("work A before release lock");
            lock.countDown();
            System.out.println("work A after release lock");
        } catch (InterruptedException ex) {
            System.out.println("Lock interrupted");
        }
    }
}
