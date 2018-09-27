package ru.rrusanov.pools;
import ru.rrusanov.waitNotifyNotifyAll.producerConsumer.SimpleBlockingQueue;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 27.09.2018
 *
 */
public class ThreadPool {

    private final List<Thread> threads = new LinkedList<>();
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>();
    private final int threadOnHost = Runtime.getRuntime().availableProcessors();

    public void work(Runnable job) {

    }

    public void shutdown() {

    }
}
