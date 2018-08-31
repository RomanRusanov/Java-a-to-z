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
     * The field contain monitor for blocking thread entrance.
     */
    private Object lock = new Object();
    /**
     * The constant contain limit size of queue.
     */
    private static final int MAX_SIZE_QUEUE = 2;
    /**
     * The field contain state when producer must self terminate.
     */
    private boolean isProducerStop = false;
    /**
     * The method setter.
     * @param value boolean
     */
    public void setProducerStop(boolean value) {
        this.isProducerStop = value;
    }
    /**
     * The method getter.
     * @return boolean.
     */
    public boolean getProducerStop() {
        return this.isProducerStop;
    }
    /**
     * The method add value in queue.
     * @param value to add.
     * @throws InterruptedException method wait() may be interrupted.
     */
    public void offer(T value) throws InterruptedException {
        synchronized (lock) {
            while (this.queue.size() == MAX_SIZE_QUEUE) {
                lock.wait();
            }
            this.queue.add(value);
            lock.notify();
        }
    }
    /**
     * The method retire element from queue, and return them.
     * @return next element in head of list.
     * @throws InterruptedException method wait() may be interrupted.
     */
    public T poll() throws InterruptedException {
        synchronized (lock) {
            while (this.queue.size() == 0) {
                lock.wait();
            }
            lock.notify();
            return this.queue.remove();
        }
    }
}
