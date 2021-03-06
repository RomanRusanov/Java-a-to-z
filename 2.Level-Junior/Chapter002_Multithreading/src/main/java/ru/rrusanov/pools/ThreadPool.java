package ru.rrusanov.pools;
import ru.rrusanov.waitNotifyNotifyAll.junitBlockingQueue.SimpleBlockingQueue;
import java.util.LinkedList;
import java.util.List;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 3.10.2018
 *
 * The class implements simple thread pool behavior.
 */
public class ThreadPool {
    /**
     * The instance contain list of threads.
     */
    private final List<Thread> threads = new LinkedList<>();
    /**
     * The instance contain queue of tasks.
     */
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>();
    /**
     * The default constructor.
     */
    public ThreadPool() {
        this.initPool();
    }
    /**
     * The method add task to pool.
     * @param job new task to run.
     */
    public void work(Runnable job) {
        this.tasks.offer(job);
    }
    /**
     * The method initiate thread pool. Number of thread use all available core on CPU.
     * If queue is empty when thread wait until in queue be added new task element, and when all threads wakeup.
     */
    public void initPool() {
        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            this.threads.add(new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    if (!this.tasks.isEmpty()) {
                        try {
                            this.tasks.poll().run();
                        } catch (InterruptedException exc) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }));
        }
        this.threads.forEach(Thread::start);
    }
    /**
     * The method terminate all thread in pool. Without wait until thread complete tasks in queue.
     */
    public void shutdown() {
        this.threads.forEach(thread -> {
            try {
                thread.interrupt();
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
    /**
     * The getter for field.
     * @return instance with collection of threads.
     */
    public List<Thread> getThreads() {
        return this.threads;
    }
}
