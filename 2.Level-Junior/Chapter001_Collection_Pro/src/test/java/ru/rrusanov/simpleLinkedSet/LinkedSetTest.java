package ru.rrusanov.simpleLinkedSet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import static org.hamcrest.core.Is.is;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 19.06.2018
 *
 * Test LinkedSet.java class.
 */
public class LinkedSetTest {
    /**
     * The field contain instance of tested class.
     */
    private LinkedSet<Integer> linkedSet = new LinkedSet<>();
    /**
     * Section execute before each tests.
     */
    @Before
    public void setUp() {
        this.linkedSet.add(1);
        this.linkedSet.add(2);
        this.linkedSet.add(3);
    }
    /**
     * The method check attempt adding existing element to collection.
     */
    @Test
    public void whenElementPresentThenSkipAddingToCollection() {
        this.linkedSet.add(2);
        Assert.assertThat(this.linkedSet.get(this.linkedSet.getSize()), is(3));
    }
    /**
     * Test Iterator.
     */
    @Test
    public void whenIteratorCreateWhenNextReturnElementsSequentially() {
        Iterator<Integer> iterator = this.linkedSet.iterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThat(iterator.next(), is(1));
        Assert.assertTrue(iterator.hasNext());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThat(iterator.next(), is(2));
        Assert.assertThat(iterator.next(), is(3));
        Assert.assertFalse(iterator.hasNext());
    }
    /**
     * Test the method checkExist.
     */
    @Test
    public void whenNodeWithSameDataExistThenReturnTrue() {
        Assert.assertTrue(this.linkedSet.checkExist(1));
        Assert.assertFalse(this.linkedSet.checkExist(4));
    }
    /**
     * Test the method getSize().
     */
    @Test
    public void whenCallThenReturnCollectionSize() {
        Assert.assertThat(this.linkedSet.getSize(), is(3));
    }
}