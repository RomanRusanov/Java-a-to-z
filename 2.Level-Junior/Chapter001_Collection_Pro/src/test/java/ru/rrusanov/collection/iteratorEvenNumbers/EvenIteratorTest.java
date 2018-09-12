package ru.rrusanov.collection.iteratorEvenNumbers;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 19.03.2018
 *
 * Class test EvenIterator.java.
 */
public class EvenIteratorTest {
    /**
     * Instance iterator.
     */
    private Iterator<Integer> it;
    /**
     * Before block execute before all test blocks.
     */
    @Before
    public void setUp() {
        it = new EvenIterator(new int[]{1, 2, 3, 4, 5, 6, 7});
    }
    /**
     * Test sequence invocation hasNext.
     */
    @Test(expected = NoSuchElementException.class)
    public void shouldReturnEvenNumbersSequentially() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(false));
        it.next();
    }
    /**
     * Test hasNext invocation doesn't affect retrieval order.
     */
    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(6));
    }
    /**
     * Return false if array doesn't contain even number.
     */
    @Test
    public void  shouldReturnFalseIfNoAnyEvenNumbers() {
        it = new EvenIterator(new int[]{1});
        assertThat(it.hasNext(), is(false));
    }
    /**
     * Should return all number.
     */
    @Test
    public void allNumbersAreEven() {
        it = new EvenIterator(new int[]{2, 4, 6, 8});
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(8));
    }
    /**
     * Should return number of position last element in array.
     */
    @Test
    public void thenFindCallWhenReturnEvenNumber() {
        EvenIterator evenIterator = new EvenIterator(new int[]{3, -1, 7, 8});
        int result = evenIterator.find();
        assertThat(result, is(3));
    }
}

