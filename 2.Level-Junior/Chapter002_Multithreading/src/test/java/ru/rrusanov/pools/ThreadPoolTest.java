package ru.rrusanov.pools;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 3.10.2018
 *
 * The class test thread pool behavior.
 */
public class ThreadPoolTest {
    /**
     * The instance of tested class.
     */
    private ThreadPool threadPool;
    /**
     * Section executes before each test.
     */
    @Before
    public void setUp() {
        this.threadPool = new ThreadPool();
    }
    /**
     * Test work method.
     * @throws InterruptedException sleep(100) may throw.
     */
    @Test
    public void whenWorkPoolCompleteThenStateFieldChange() throws InterruptedException {
        Task task = new Task();
        this.threadPool.work(task);
        Thread.sleep(100);
        assertEquals(task.getTest(), "some work of Task");
    }
    /**
     * Test pool use all cores cpu in host.
     */
    @Test
    public void whenInitPoolThenListOfThreadEqualsNumbersOfCores() {
        assertEquals(this.threadPool.getThreads().size(), Runtime.getRuntime().availableProcessors());
    }
    /**
     * Test shutdown method.
     */
    @Test
    public void whenPoolShutdownThenAllThreadsTerminate() {
        this.threadPool.shutdown();
        for (Thread thread : this.threadPool.getThreads()) {
            assertFalse(thread.isAlive());
        }
    }
    /**
     * The class describe task.
     */
    class Task implements Runnable {
        /**
         * The filed for test.
         */
        private String test;
        /**
         * Thread work.
         */
        @Override
        public void run() {
            this.test = "some work of Task";
        }
        /**
         * The getter for field.
         * @return state of field.
         */
        public String getTest() {
            return test;
        }
    }
}