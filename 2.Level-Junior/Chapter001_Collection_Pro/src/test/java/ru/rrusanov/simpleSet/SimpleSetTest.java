package ru.rrusanov.simpleSet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.hamcrest.core.Is.is;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 18.06.2018
 *
 * Class test SimpleSet.java class.
 */
public class SimpleSetTest {
    /**
     * Instance of test class.
     */
    private SimpleSet<Integer> simpleSet = new SimpleSet<>();
    /**
     * Section execute before each tests.
     */
    @Before
    public void setUp() {
        this.simpleSet.add(1);
        this.simpleSet.add(2);
        this.simpleSet.add(3);
    }
    /**
     * Then get element from collection, when return value at this index.
     */
    @Test
    public void thenGetElementFromCollectionWhenReturnValue() {
        Assert.assertThat(this.simpleSet.get(0), is(1));
        Assert.assertThat(this.simpleSet.get(1), is(2));
        Assert.assertThat(this.simpleSet.get(2), is(3));
    }
    /**
     * Iterator. Method next return next element, if no more element to iterate call next generate NoSuchElementException.
     * Method hasNext() method must return true, if more elements left to iterate, otherwise false.
     */
    @Test (expected = NoSuchElementException.class)
    public void thenIteratorCallNextWhenReturnNextElement() {
        Iterator<Integer> iterator = simpleSet.iterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(new Integer(1), iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(new Integer(2), iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(new Integer(3), iterator.next());
        Assert.assertFalse(iterator.hasNext());
        iterator.next();
    }
}