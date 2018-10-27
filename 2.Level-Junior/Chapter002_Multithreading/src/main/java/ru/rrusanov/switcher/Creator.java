package ru.rrusanov.switcher;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 26.10.2018
 *
 * The class describe thread behavior in cycle add value to the container 10 values, and then switch contest to
 * another thread.
 */
public class Creator implements Runnable {
    /**
     * The field contain instance lock. To synchronize threads.
     */
    private ReentrantLock lock;
    /**
     * The field contain common resource.
     */
    private Container container;
    /**
     * The field contain value that thread fill container.
     */
    private int valueToCreate;
    /**
     * The field contain instance the lock condition.
     */
    private Condition condition;
    /**
     * The field contain int value how many iteration in thread fill 10 values added to the container.
     */
    private int iterationInCycle = 5;
    /**
     * The default constructor.
     * @param lock instance ReentrantLock.
     * @param container instance container
     * @param value value to fill.
     * @param condition instance condition.
     */
    public Creator(ReentrantLock lock, Container container, int value, Condition condition) {
        this.lock = lock;
        this.container = container;
        this.valueToCreate = value;
        this.condition = condition;
    }
    /**
     * The method contain thread body.
     */
    @Override
    public void run() {
        for (int j = 0; j < this.iterationInCycle; j++) {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    container.add(this.valueToCreate);
                }
                this.condition.signal();
                if (j != this.iterationInCycle - 1) {
                    this.condition.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
