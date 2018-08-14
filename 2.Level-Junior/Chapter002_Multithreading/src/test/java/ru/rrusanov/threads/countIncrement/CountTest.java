package ru.rrusanov.threads.countIncrement;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 06.08.2018
 *
 * The class test behavior counter with two thread.
 */
public class CountTest {
    /**
     * The class extends Thread for concurrency implementation. Inner private class.
     */
    private class ThreadCount extends Thread {
        /**
         * The field contain instance of counter class.
         */
        private final Count count;
        /**
         * The default constructor.
         * @param count instance to initiate field.
         */
        private ThreadCount(final Count count) {
            this.count = count;
        }
        /**
         * The method contain sequence for thread work.
         * Method override Thread class.
         */
        @Override
        public void run() {
            this.count.increment();
        }
    }
    /**
     * The test check then 2 thread work with one counter. When counter increment twice(value the counter 2).
     * @throws InterruptedException method join may be interrupted.
     */
    @Test
    public  void whenExecute2ThreadThen2() throws InterruptedException {
        // Create count
        final Count count = new Count();
        // Create Threads
        Thread first = new ThreadCount(count);
        Thread second = new ThreadCount(count);
        // Start threads.
        first.start();
        second.start();
        // Make sure that main thread wait child threads.
        first.join();
        second.join();
        assertThat(count.getValue(), is(2));
    }
}