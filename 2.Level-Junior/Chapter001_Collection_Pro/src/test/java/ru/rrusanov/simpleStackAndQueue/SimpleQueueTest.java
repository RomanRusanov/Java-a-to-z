package ru.rrusanov.simpleStackAndQueue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 13.06.2018
 *
 * SimpleQueueTest.java test class SimpleQueue.java.
 */
public class SimpleQueueTest {
    /**
     * The field contain instance of test class.
     */
    private SimpleQueue<Integer> simpleQueue = new SimpleQueue<>();
    /**
     * The method execute before each test.
     */
    @Before
    public void setUp() {
        simpleQueue.push(1);
        simpleQueue.push(2);
        simpleQueue.push(3);
    }
    /**
     * The method test poll behavior.
     */
    @Test
    public void whenPollThenReturnFirstAddedElementAndRemoveIt() {
        Assert.assertThat(simpleQueue.poll(), is(1));
        Assert.assertThat(simpleQueue.poll(), is(2));
        Assert.assertThat(simpleQueue.poll(), is(3));
    }
}