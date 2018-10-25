package ru.rrusanov.switcher;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 25.10.2018
 * <p>
 * The class .
 */
public class Creator implements Runnable {

    private ReentrantLock lock;

    private Container container;

    private int valueToCreate;

    public Creator(ReentrantLock lock, Container container, int value) {
        this.lock = lock;
        this.container = container;
        this.valueToCreate = value;
    }
    public void run() {
        for(int j = 0; j < 5; j++) {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                container.add(this.valueToCreate);
            }
            lock.unlock();
        }
    }
}
