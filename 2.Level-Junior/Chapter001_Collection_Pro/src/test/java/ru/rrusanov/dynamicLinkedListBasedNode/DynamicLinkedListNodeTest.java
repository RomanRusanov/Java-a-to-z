package ru.rrusanov.dynamicLinkedListBasedNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import static org.hamcrest.core.Is.is;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 10.06.2018
 *
 * Test DynamicLinkedListNode.java.
 */
public class DynamicLinkedListNodeTest {
    /**
     * The field contain instance of tested class.
     */
    private DynamicLinkedListNode<Integer> dynamicLinkedListNode = new DynamicLinkedListNode();
    /**
     * Section execute before each tests.
     */
    @Before
    public void setUp() {
        dynamicLinkedListNode.add(1);
        dynamicLinkedListNode.add(2);
        dynamicLinkedListNode.add(3);
        dynamicLinkedListNode.add(4);
    }
    /**
     * Test add and get methods.
     */
    @Test
    public void whenAddElementsThenReturnThem() {
        Assert.assertThat(dynamicLinkedListNode.get(1), is(1));
        Assert.assertThat(dynamicLinkedListNode.get(4), is(4));
    }
    /**
     * Test Iterator.
     */
    @Test
    public void whenIteratorCreateWhenNextReturnElementsSequentially() {
        Iterator<Integer> iterator = dynamicLinkedListNode.iterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThat(iterator.next(), is(1));
        Assert.assertTrue(iterator.hasNext());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThat(iterator.next(), is(2));
        Assert.assertThat(iterator.next(), is(3));
        Assert.assertThat(iterator.next(), is(4));
        Assert.assertFalse(iterator.hasNext());
    }
    /**
     * Test fail-fast behavior.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void whenCollectionChangedThenTrowException() {
        Iterator<Integer> iterator = dynamicLinkedListNode.iterator();
        dynamicLinkedListNode.add(5);
        iterator.hasNext();
    }
}