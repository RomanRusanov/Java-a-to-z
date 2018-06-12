package ru.rrusanov.simpleArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 07.06.2018
 *
 * SimpleArrayListTest class test SimpleArrayList.
 */
public class SimpleArrayListTest {
    /**
     * Instance to test.
     */
    private SimpleArrayList<Integer> list;
    /**
     * New node be added in constructor when create instance of collection.
     */
    private Node<Integer> zeroNode = new Node<Integer>(0);
    /**
     * Section execute before each tests.
     */
    @Before
    public void beforeTest() {
        list = new SimpleArrayList<>(zeroNode);
        list.add(1);
        list.add(2);
        list.add(3);
    }
    /**
     * Return second element in collection.
     */
    @Test
    public void whenAddThreeElementsThenUseGetResultTwo() {
        assertThat(list.get(1), is(2));
    }
    /**
     * Return size of collection.
     */
    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(4));
    }
    /**
     * When delete call, the method must delete first and next element become first.
     */
    @Test
    public void whenDeleteFirstThenSecondBecomeFirst() {
        assertThat(list.get(0), is(list.delete()));
        assertThat(list.get(0), is(2));
    }
    /**
     * When call getNode then return node at specific position.
     */
    @Test
    public void whenGetNodeCallThenReturnNode() {
        assertThat(list.getNode(3), is(zeroNode));
    }
    /**
     * Test method delete with index.
     */
    @Test
    public void whenDeleteByIndexThenElementRemove() {
        assertThat(list.getSize(), is(4));
        assertThat(list.delete(3), is(zeroNode));
        assertThat(list.getSize(), is(3));
    }
}