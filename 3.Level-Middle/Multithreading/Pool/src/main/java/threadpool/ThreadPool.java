package threadpool;

import net.jcip.annotations.ThreadSafe;
import patternproducerconsumer.SimpleBlockingQueue;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 02.10.2020
 * email roman9628@gmail.com
 * The class implements thread pool with blocking queue.
 */
@ThreadSafe
public class ThreadPool {
    /**
     * The field contain list with all threads in pool.
     */
    private final List<Thread> threads = new LinkedList<>();
    /**
     * The field contain max numbers of threads used.
     */
    private final int sizeThreadPool = Runtime.getRuntime().availableProcessors();
    /**
     * The instance implement thread safe blocking queue.
     */
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>(sizeThreadPool);

    /**
     * The default constructor.
     */
    public ThreadPool() {
        this.init();
        this.threads.forEach(Thread::start);
    }

    /**
     * The method add instance to run.
     * @param job the instance that implements Runnable interface.
     */
    public void work(Runnable job) {
        this.tasks.offer(job);
    }

    /**
     * The method interrupt all threads in poll.
     */
    public void shutdown() {
        this.threads.forEach(Thread::interrupt);
    }

    /**
     * The method add thread in list.
     * Each thread run instance that tasks.poll return.
     * If tasks is empty then pool method wait.
     * When pool not need all threads in list interrupted.
     */
    private void init() {
        for (int i = 0; i < this.sizeThreadPool; i++) {
            this.threads.add(new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        new Thread(this.tasks.poll()).start();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }));
        }
    }
}