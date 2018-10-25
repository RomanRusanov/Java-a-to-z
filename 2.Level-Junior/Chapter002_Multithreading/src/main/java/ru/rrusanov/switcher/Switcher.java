package ru.rrusanov.switcher;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 25.10.2018
 * <p>
 * The class .
 */
@ThreadSafe
public class Switcher {

    public static void main(String[] args) {
        Container container = new Container();

        ReentrantLock lock = new ReentrantLock(true);

        new Thread(new Creator(lock, container, 1)).start();

        new Thread(new Creator(lock, container, 2)).start();
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(container.getStoredString());
    }
}
