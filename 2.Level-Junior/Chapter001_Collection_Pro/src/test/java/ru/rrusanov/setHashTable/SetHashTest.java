package ru.rrusanov.setHashTable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 22.06.2018
 *
 * The class test behavior SetHash.java and DataItem.java classes.
 */
public class SetHashTest {
    /**
     * The field contain instance of tested class.
     */
    private SetHash<String> setHash = new SetHash<>(2);
    /**
     * This section execute before each test.
     */
    @Before
    public void setUp() {
        this.setHash.add("a");
        this.setHash.add("b");
        this.setHash.add("c");
    }
    /**
     * The method test behavior of add method.
     */
    @Test
    public void thenAddElementInSetWhenElementExist() {
        Assert.assertTrue(this.setHash.contains("a"));
        Assert.assertFalse(this.setHash.add("a"));
        Assert.assertTrue(this.setHash.contains("b"));
        Assert.assertTrue(this.setHash.contains("c"));
    }
    /**
     * The method test behavior of contains method.
     */
    @Test
    public void thenElementNotPresentInSetWhenReturnFalse() {
        Assert.assertFalse(this.setHash.contains("d"));
    }
    /**
     * The method test behavior of remove method.
     */
    @Test
    public void thenElementRemovedWhenContainsReturnFalse() {
        this.setHash.remove("a");
        Assert.assertFalse(this.setHash.contains("a"));
        Assert.assertFalse(this.setHash.remove("a"));
    }
}