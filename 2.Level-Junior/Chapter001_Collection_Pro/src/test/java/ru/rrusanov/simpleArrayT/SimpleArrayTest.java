package ru.rrusanov.simpleArrayT;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 20.05.2018
 *
 * Class test SimpleArray.java class.
 */
public class SimpleArrayTest {
    /**
     * Instance of test class.
     */
    private SimpleArray<Integer> simpleArray = new SimpleArray<>();
    /**
     * Section execute before each tests.
     */
    @Before
    public void setUp() {
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        simpleArray.add(5);
    }
    /**
     * Then element added to collection when you may get from it.
     */
    @Test
    public void thenAddElementInCollectionWhenItReturnFromCollection() {
        Integer result = simpleArray.get(4);
        Assert.assertEquals(new Integer(5), result);
    }
    /**
     * If attempt add to collection more then five elements, when throw exception.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void thenArraySizeEquals5WhenThrowException() {
        simpleArray.add(1);
    }
    /**
     * If element set then collection contain new value at that index.
     */
    @Test
    public void thenElementSetWhenValueChange() {
        simpleArray.set(0, -1);
        Integer result = simpleArray.get(0);
        Assert.assertEquals(new Integer(-1), result);
    }
    /**
     * Then element deleted when value contain null.
     */
    @Test
    public void thenElementDeleteWhenReturnNull() {
        simpleArray.delete(4);
        Assert.assertNull(simpleArray.get(4));
    }
    /**
     * Then get element from collection, when return value at this index.
     */
    @Test
    public void thenGetElementFromCollectionWhenReturnValue() {
        Integer result = simpleArray.get(2);
        Assert.assertEquals(new Integer(3), result);
    }
    /**
     * Iterator. Method next return next element, if no more element to iterate call next generate NoSuchElementException.
     * Method hasNext() method must return true, if more elements left to iterate, otherwise false.
     */
    @Test(expected = NoSuchElementException.class)
    public void thenIteratorCallNextWhenReturnNextElement() {
        Iterator<Integer> iterator = simpleArray.iterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(new Integer(1), iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(new Integer(2), iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(new Integer(3), iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(new Integer(4), iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(new Integer(5), iterator.next());
        Assert.assertFalse(iterator.hasNext());
        iterator.next();
    }
}