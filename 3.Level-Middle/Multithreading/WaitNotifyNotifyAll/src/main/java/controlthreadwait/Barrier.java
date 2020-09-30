package controlthreadwait;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 29.09.2020
 * email roman9628@gmail.com
 * The class Describe barrier.
 *
 */
public class Barrier {
    /**
     * The field describe flag.
     * True - work.
     * False - wait.
     */
    private boolean flag = false;
    /**
     * The field contain reference monitor object.
     */
    private final Object monitor = this;

    /**
     * The method change flag state, start or resume work process,
     * that control barrier.
     */
    public void on() {
        synchronized (monitor) {
            flag = true;
            monitor.notifyAll();
        }
    }

    /**
     * The method change flag state, stop work process.
     * That control barrier.
     */
    public void off() {
        synchronized (monitor) {
            flag = false;
            monitor.notifyAll();
        }
    }

    /**
     * The method check flag state if off then sleep, otherwise do nothing.
     */
    public void check() {
        synchronized (monitor) {
            while (!flag) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}