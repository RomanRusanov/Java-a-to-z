package ru.rrusanov.waitNotifyNotifyAll.junitBlockingQueue;
import org.junit.Test;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 1.09.2018
 *
 * The class test describe behavior collection with blocking bounded queue in junit test.
 */
public class SimpleBlockingQueueTest {
    /**
     * The field contain result what elements was added in queue.
     */
    final CopyOnWriteArrayList<Integer> buffer = new CopyOnWriteArrayList<>();
    /**
     * The field contain queue collection.
     */
    final SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>();
    /**
     * The test.
     * @throws InterruptedException Method join() may throws.
     */
    @Test
    public void whenFetchAllThenGetIt() throws InterruptedException {
        Thread producer = new Thread(
                () -> {
                        IntStream.range(0, 5).forEach(
                            queue::offer
                        );
                }
        );
        producer.start();
        Thread consumer = new Thread(
                () -> {
                    while (!queue.isEmpty() || !Thread.currentThread().isInterrupted()) {
                        try {
                            buffer.add(queue.poll());
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
        );
        consumer.start();
        producer.join();
        consumer.interrupt();
        consumer.join();
        assertThat(buffer, is(Arrays.asList(0, 1, 2, 3, 4)));
    }
}
