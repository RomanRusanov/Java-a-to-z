package ru.rrusanov.hashMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 28.06.2018
 *
 * The class HashMapTest.java check behavior HashMap.
 */
public class HashMapTest {
    /**
     * The instance of tested class.
     */
    private HashMap<String, Integer> hashMap = new HashMap<>(2);
    /**
     * The method executes in each test.
     */
    @Before
    public void setUp() {
        hashMap.insert("A", 1);
        hashMap.insert("B", 2);
    }
    /**
     * Test method growAndReHash.
     */
    @Test
    public void whenNoMoreFreeEntryThenCollectionGrow() {
        this.hashMap.insert("C", 3);
        Assert.assertThat(this.hashMap.getSize(), is(3));
    }
    /**
     * Test method removeNullsElements.
     */
    @Test
    public void whenCallRemoveNullsElementThenCollectionsWithoutNulls() {
        this.hashMap.delete("A");
        this.hashMap.removeNullsElements();
        for (Entry<String, Integer> item : this.hashMap) {
            Assert.assertNotNull(item);
        }
    }
    /**
     * Test method insert.
     */
    @Test
    public void whenInsertInMapThenEntryExist() {
        this.hashMap.insert("C", 3);
        Assert.assertThat(this.hashMap.get("C"), is(3));

    }
    /**
     * Test method get.
     */
    @Test
    public void whenCallGetWhenReturnValue() {
        Assert.assertThat(this.hashMap.get("A"), is(1));
        Assert.assertThat(this.hashMap.get("B"), is(2));
    }
    /**
     *
     */
    @Test
    public void whenEntryDeletedThenItNotExist() {
        Assert.assertTrue(this.hashMap.delete("A"));
        Assert.assertFalse(this.hashMap.delete("A"));
    }

    @Test
    public void iterator() {
        Iterator<Entry<String, Integer>> it = hashMap.iterator();
        assertTrue(it.hasNext());
        assertThat(it.next().getKey(), anyOf(is("A"), is("B")));
        assertTrue(it.hasNext());
        assertTrue(it.hasNext());
        assertThat(it.next().getKey(), anyOf(is("A"), is("B")));
        assertFalse(it.hasNext());
    }
}