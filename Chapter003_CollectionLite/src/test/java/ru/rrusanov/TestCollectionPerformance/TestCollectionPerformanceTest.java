package ru.rrusanov.TestCollectionPerformance;

import org.junit.Assert;
import org.junit.Test;
import java.util.LinkedList;

import static org.junit.Assert.assertNotSame;

/**
 * Class test TestCollectionPerformance class methods.
 */
public class TestCollectionPerformanceTest {
    /**
     * Three constant, elemnts in collection.
     */
    private static final int THREE = 3;
    /**
     * Check if three elements added to collection then size of collection three.
     */
    @Test
    public void thenAdd3ElementsWhenCollectionSize3() {
        TestCollectionPerformance testCollectionPerformance = new TestCollectionPerformance();
        LinkedList<String> linkedList = new LinkedList<>();
        testCollectionPerformance.add(linkedList, THREE);
        Assert.assertTrue(linkedList.size() == THREE);
    }
    /**
     * Check if three elements delete from collection then size of collection zero.
     */
    @Test
    public void thenDelete3ElementsWhenCollectionSize0() {
        TestCollectionPerformance testCollectionPerformance = new TestCollectionPerformance();
        LinkedList<String> linkedList = new LinkedList<>();
        testCollectionPerformance.add(linkedList, THREE);
        testCollectionPerformance.delete(linkedList, THREE);
        Assert.assertTrue(linkedList.size() == 0);
    }
    /**
     * Check random generated string.
     */
    @Test
    public void thenRandomStringGeneratedWhenNextStringDifferent() {
        TestCollectionPerformance testCollectionPerformance = new TestCollectionPerformance();
        String string1;
        String string2;
        string1 = testCollectionPerformance.generateString();
        string2 = testCollectionPerformance.generateString();
        assertNotSame(string1, string2);
    }
}