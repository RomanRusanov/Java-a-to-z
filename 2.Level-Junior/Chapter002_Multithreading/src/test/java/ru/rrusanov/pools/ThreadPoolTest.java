package ru.rrusanov.pools;

import org.junit.Before;
import org.junit.Test;
import ru.rrusanov.waitNotifyNotifyAll.junitBlockingQueue.SimpleBlockingQueue;

import static org.junit.Assert.*;

public class ThreadPoolTest {

    private ThreadPool threadPool;

    @Before
    public void setUp() {
        this.threadPool = new ThreadPool();
    }

    @Test
    public void work() {
        this.threadPool.work(new Task());
        this.threadPool.work(new Task());
    }

    @Test
    public void shutdown() {
        this.threadPool.shutdown();
    }

    class Task implements Runnable {

        @Override
        public void run() {
            System.out.println("some work of Task");
        }
    }
}