package ru.rrusanov.simpleArrayList;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
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

    @Test
    public void thenAddThreeElementsWhenUseGetResultTwo() {
        assertThat(list.get(1), is(2));
    }

    @Test
    public void thenAddThreeElementsWhenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }
}