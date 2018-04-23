package ru.rrusanov.iteratorPrimeNumbers;
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
 * Class test PrimeIterator.java.
 */
public class PrimeIteratorTest {
    /**
     * Instance iterator.
     */
    private Iterator<Integer> it;
    /**
     * Before block execute before all test blocks.
     */
    @Before
    public void setUp() {
        it = new PrimeIterator(new int[]{1, 2, 3, 4, 5, 6, 7, 3571});
    }
    /**
     * Test should return prime number only.
     */
    @Test(expected = NoSuchElementException.class)
    public void shouldReturnPrimeNumbersOnly() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3571));
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
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(7));
        assertThat(it.next(), is(3571));
    }
    /**
     * Return false if array doesn't contain prime number.
     */
    @Test
    public void shouldReturnFalseCauseThereIsNoAnyPrimeNumber() {
        it = new PrimeIterator(new int[]{4, 6});
        assertThat("should return false, cause there is no any prime number", it.hasNext(), is(false));
    }
    /**
     * Return true if pass prime number.
     */
    @Test
    public void thenPassPrimeNumberWhenReturnTrue() {
        PrimeIterator primeIterator = new PrimeIterator(new int[]{});
        boolean result = false;
        result = primeIterator.isPrime(7);
        assertThat(result, is(true));
    }
}
