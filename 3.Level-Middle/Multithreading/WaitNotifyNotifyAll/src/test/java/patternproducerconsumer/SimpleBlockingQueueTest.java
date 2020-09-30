package patternproducerconsumer;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The class test behavior SimpleBlockingQueue.java.
 */
class SimpleBlockingQueueTest {
    /**
     * Test check when add 3 elements, when get same 3 elements.
     * @throws InterruptedException join may throw.
     */
    @Test
    public void whenQueueOffer3TimesThenConsume3Element() throws InterruptedException {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>();
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                queue.offer(i);
            }
        }, "producer");
        producer.start();
        producer.join();
        for (int i = 0; i < 3; i++) {
            assertEquals(i, queue.poll());
        }
    }

    /**
     * The test check when queue size is max then producer wait.
     * @throws InterruptedException join may throw.
     */
    @Test
    public void whenQueueOfferAndNotConsumeThenSizeQueue5() throws InterruptedException {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>();
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                queue.offer(i);
            }
        }, "producer");
        producer.start();
        Thread.sleep(50);
        assertEquals(5, queue.getSizeQueue());
        assertEquals(Thread.State.WAITING, producer.getState());
    }

    /**
     * The test check when consumer take all elements in queue then it wait.
     * @throws InterruptedException join may throw.
     */
    @Test
    public void whenConsumeAllThenQueueEmptyAndConsumerWait() throws InterruptedException {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>();
        for (int i = 0; i < 3; i++) {
            queue.offer(i);
        }
        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                try {
                    queue.poll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }, "consumer");
        consumer.start();
        Thread.sleep(50);
        assertEquals(Thread.State.WAITING, consumer.getState());
        assertTrue(queue.isEmpty());
    }

    /**
     * The test check if consumer and producer work equals iteration then
     * queue is empty.
     * @throws InterruptedException join may throw.
     */
    @Test
    public void when2ThreadsWorkThenQueueIsEmpty() throws InterruptedException {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>();
        List<Integer> expect = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> result = new ArrayList<>();
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                queue.offer(i);
            }
        }, "producer");
        producer.start();
        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    result.add(queue.poll());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }, "consumer");
        consumer.start();
        producer.join();
        consumer.join();
        assertEquals(expect, result);
        assertTrue(queue.isEmpty());
        assertEquals(Thread.State.TERMINATED, consumer.getState());
        assertEquals(Thread.State.TERMINATED, producer.getState());
    }
}