package ru.rrusanov.simpleStack;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 11.06.2018
 *
 * SimpleStackTest.java test class SimpleStack.java.
 */
public class SimpleStackTest {
    /**
     * The field contain instance of test class.
     */
    private SimpleStack<Integer> simpleStack = new SimpleStack<>();
    /**
     * The method execute before each test.
     */
    @Before
    public void setUp() {
        simpleStack.push(1);
        simpleStack.push(2);
        simpleStack.push(3);
    }
    /**
     * The method test poll behavior.
     */
    @Test
    public void whenPollThenReturnLastAddedElementAndRemoveIt() {
        Assert.assertThat(simpleStack.poll(), is(3));
        Assert.assertThat(simpleStack.poll(), is(2));
        Assert.assertThat(simpleStack.poll(), is(1));
    }
}