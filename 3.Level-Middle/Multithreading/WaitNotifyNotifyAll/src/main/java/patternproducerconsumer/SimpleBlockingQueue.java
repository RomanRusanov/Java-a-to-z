package patternproducerconsumer;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 30.09.2020
 * email roman9628@gmail.com
 * The class implements thread safe queue. FIFO order for extraction.
 * @param <T> The type that queue store.
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {
    /**
     * Monitor for synchronize.
     */
    @GuardedBy("this")
    /**
     * The field contain linked list.
     */
    private final Queue<T> queue = new LinkedList<>();
    /**
     * The field contain max value queue size.
     */
    private final int sizeQueue = 5;

    /**
     * The method add element to queue.
     * @param value Element to store.
     */
    public synchronized void offer(T value) {
        while (true) {
            if (this.queue.size() < this.sizeQueue) {
                this.queue.offer(value);
                break;
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        notifyAll();
    }

    /**
     * The method get element from queue.
     * @return Element.
     */
    public synchronized T poll() {
        while (true) {
            if (!this.queue.isEmpty()) {
                T element = this.queue.poll();
                notifyAll();
                return element;
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    /**
     * The method get current queue size.
     * @return Int value.
     */
    public synchronized int getSizeQueue() {
        return this.queue.size();
    }

    /**
     * The method check queue contain elements.
     * @return If queue not empty return true, otherwise false.
     */
    public synchronized boolean isEmpty() {
        return this.queue.isEmpty();
    }
}