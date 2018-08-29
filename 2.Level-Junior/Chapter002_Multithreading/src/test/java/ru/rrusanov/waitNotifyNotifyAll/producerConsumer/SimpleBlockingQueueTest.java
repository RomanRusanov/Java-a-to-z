package ru.rrusanov.waitNotifyNotifyAll.producerConsumer;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 29.08.2018
 *
 * The class check simple blocking queue.
 */
public class SimpleBlockingQueueTest {
    /**
     * The field contain class that threads be use together.
     */
    private SimpleBlockingQueue<Integer> simpleBlockingQueue = new SimpleBlockingQueue<>();
    /**
     * The test check behavior with blocking queue. If queue full when wait till in queue left free position.
     * If queue no left elements, when wait till another thread add elements.
     * @throws InterruptedException method join() may be interrupted.
     */
    @Test
    public void whenQueueFullThenWait() throws InterruptedException {
        /**
         * The inner class describe behavior producer thread.
         */
        class Producer extends Thread {
            @Override
            public void run() {
                try {
                    simpleBlockingQueue.offer(1);
                    simpleBlockingQueue.offer(2);
                    simpleBlockingQueue.offer(3);
                    simpleBlockingQueue.offer(4);
                    simpleBlockingQueue.offer(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        /**
         * The inner class describe behavior consumer thread.
         */
        class Consumer extends Thread {
            @Override
            public void run() {
                try {
                    assertThat(simpleBlockingQueue.pool(), is(1));
                    assertThat(simpleBlockingQueue.pool(), is(2));
                    assertThat(simpleBlockingQueue.pool(), is(3));
                    assertThat(simpleBlockingQueue.pool(), is(4));
                    assertThat(simpleBlockingQueue.pool(), is(5));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }
}