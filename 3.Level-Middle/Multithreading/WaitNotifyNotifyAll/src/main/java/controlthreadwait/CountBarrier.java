package controlthreadwait;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 29.09.2020
 * email roman9628@gmail.com
 * The class .
 */
public class CountBarrier {
    /**
     * The field contain monitor.
     */
    private final Object monitor = this;
    /**
     * The field contain value for barrier lock.
     * If total == count barrier unlock and await skip.
     */
    private final int total;
    /**
     * The current counter.
     */
    private int count = 0;


    /**
     * The default constructor.
     * @param total How many iteration before unlock.
     */
    public CountBarrier(final int total) {
        this.total = total;
    }

    /**
     * The method increment count and call all thread to check counter.
     */
    public void count() {
        synchronized (this.monitor) {
            this.count++;
            this.monitor.notifyAll();
        }
    }

    /**
     * The method check if count and total equals then skip while.
     */
    public void await() {
        synchronized (this.monitor) {
            while (this.total != this.count) {
                try {
                    this.monitor.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}