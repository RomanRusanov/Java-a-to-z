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
     * Section execute before each tests.
     */
    @Before
    public void beforeTest() {
        list = new SimpleArrayList<>();
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
        assertThat(list.getSize(), is(3));
    }
    /**
     * When delete call, the method must delete first and next element become first.
     */
    @Test
    public void whenDeleteFirstThenSecondBecomeFirst() {
        assertThat(list.get(0), is(list.delete()));
        assertThat(list.get(0), is(2));
    }
}