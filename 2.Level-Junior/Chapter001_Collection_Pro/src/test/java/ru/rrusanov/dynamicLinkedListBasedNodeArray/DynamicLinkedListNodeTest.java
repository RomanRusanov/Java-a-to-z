package ru.rrusanov.dynamicLinkedListBasedNodeArray;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DynamicLinkedListNodeTest {

    private DynamicLinkedListNode<Integer> dynamicLinkedListNode = new DynamicLinkedListNode();

    @Before
    public void setUp() {
        dynamicLinkedListNode.add(1);
        dynamicLinkedListNode.add(2);
        dynamicLinkedListNode.add(3);
        dynamicLinkedListNode.add(4);
    }

    @Test
    public void addAndGet() {
        Assert.assertThat(dynamicLinkedListNode.get(2), is(2));
    }

    @Test
    public void iterator() {
    }
}