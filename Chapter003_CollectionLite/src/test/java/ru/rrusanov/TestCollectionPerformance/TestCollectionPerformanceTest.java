package ru.rrusanov.TestCollectionPerformance;

import org.junit.Assert;
import org.junit.Test;
import java.util.LinkedList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class test TestCollectionPerformance class methods.
 */
public class TestCollectionPerformanceTest {
    /**
     * Check if elements added to collection then collection not empty.
     */
    @Test
    public void thenAddElementsWhenCollectionNotEmpty() {
        TestCollectionPerformance testCollectionPerformance = new TestCollectionPerformance();
        LinkedList<String> linkedList = new LinkedList<>();
        long resultLinkedList = testCollectionPerformance.add(linkedList, 3);
        Assert.assertNotNull(resultLinkedList);
    }

    @Test
    public void delete() {

    }
}