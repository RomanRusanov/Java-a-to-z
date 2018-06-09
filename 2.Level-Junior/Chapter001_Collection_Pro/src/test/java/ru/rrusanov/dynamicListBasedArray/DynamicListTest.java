package ru.rrusanov.dynamicListBasedArray;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import static org.hamcrest.core.Is.is;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 07.06.2018
 *
 * Test DynamicList.java.
 */
public class DynamicListTest {
    /**
     * The field contain instance of tested class.
     */
    private DynamicList<Integer> dynamicList = new DynamicList<>();
    /**
     * Section execute before each tests.
     */
    @Before
    public void before() {
        dynamicList.add(1);
        dynamicList.add(2);
        dynamicList.add(3);
    }
    /**
     * Test add and get methods.
     */
    @Test
    public void whenAddElementsThenReturnThem() {
        Assert.assertThat(dynamicList.get(0), is(1));
        Assert.assertThat(dynamicList.get(1), is(2));
        Assert.assertThat(dynamicList.get(2), is(3));
    }
    /**
     * Test Iterator.
     */
    @Test
    public void whenIteratorCreateWhenNextReturnElementsSequentially() {
        Iterator<Integer> iterator = dynamicList.iterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThat(iterator.next(), is(1));
        Assert.assertTrue(iterator.hasNext());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThat(iterator.next(), is(2));
        Assert.assertThat(iterator.next(), is(3));
        Assert.assertFalse(iterator.hasNext());
    }
    /**
     * Test fail-fast behavior.
     */
    @Test (expected = ConcurrentModificationException.class)
    public void whenCollectionChangedThenTrowException() {
        Iterator<Integer> iterator = dynamicList.iterator();
        dynamicList.add(4);
        iterator.hasNext();
    }
}