package ru.rrusanov.search;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 03.03.2018
 *
 * Class test PriorityQueue class.
 */
public class PriorityQueueTest {
    /**
     * Test for method put.
     */
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }
    /**
     * Test for method take.
     */
    @Test
    public void take() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        queue.take();
        Task result = queue.take();
        assertThat(result.getDesc(), is("middle"));
    }
    /**
     * Test for method take.
     */
    @Test
    public void shouldReturnFromOneToFiveSequentially() {
        Task t1 = new Task("1", 1);
        Task t2 = new Task("2", 2);
        Task t3 = new Task("3", 3);
        Task t4 = new Task("4", 4);
        Task t5 = new Task("5", 5);
        PriorityQueue queue = new PriorityQueue();
        queue.put(t2);
        queue.put(t5);
        queue.put(t4);
        queue.put(t1);
        queue.put(t3);
        assertThat(queue.take(), is(t1));
        assertThat(queue.take(), is(t2));
        assertThat(queue.take(), is(t3));
        assertThat(queue.take(), is(t4));
        assertThat(queue.take(), is(t5));
    }
}