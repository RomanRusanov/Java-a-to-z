package ru.rrusanov.waitNotifyNotifyAll.parallelSearch;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import java.util.LinkedList;
import java.util.Queue;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 29.08.2018
 *
 * The class describe behavior collection with blocking bounded queue.
 * @param <T> generic type that queue be hold.
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {
    /**
     * The field contain collection that store data.
     */
    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();
    /**
     * The constant contain limit size of queue.
     */
    private static final int MAX_SIZE_QUEUE = 2;
    /**
     * The method add value in queue.
     * @param value to add.
     * @throws InterruptedException method wait() may be interrupted.
     */
    @GuardedBy("this")
    public synchronized void offer(T value) throws InterruptedException {
        while (this.queue.size() == MAX_SIZE_QUEUE) {
            this.wait();
        }
        this.queue.add(value);
        this.notify();
    }
    /**
     * The method retire element from queue, and return them.
     * @return next element in head of list.
     * @throws InterruptedException method wait() may be interrupted.
     */
    @GuardedBy("this")
    public synchronized T poll() throws InterruptedException {
        while (this.queue.size() == 0) {
            this.wait();
        }
        this.notify();
        return this.queue.remove();
    }
    /**
     * The method check has collection elements.
     * @return boolean
     */
    @GuardedBy("this")
    public synchronized boolean isEmpty() {
        return this.queue.isEmpty();
    }
}
