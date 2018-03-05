package ru.rrusanov.comparator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 04.03.2018
 *
 * Class test ListCompare class.
 */
public class ListCompareTest {
    /**
     * Test for compare method.
     */
    @Test
    public void whenLeftAndRightEqualsThenZero() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Ivanov",
                "Ivanov"
        );
        assertThat(rst, is(0));
    }
    /**
     * Test for compare method.
     */
    @Test
    public void whenLeftLessRightThenMunis() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Ivanov",
                "Ivanova"
        );
        assertThat(rst, is(-1));
    }
    /**
     * Test for compare method.
     */
    @Test
    public void whenLeftGreatRightThenPlus() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Petrov",
                "Ivanova"
        );
        assertThat(rst, is(1));
    }
    /**
     * Test fot stringToArrayList method.
     */
    @Test
    public void thenPassStringWhenReturnListChar() {
        ListCompare listCompare = new ListCompare();
        String string = "A";
        ArrayList<Character> rst = listCompare.stringToArrayList(string);
        Assert.assertThat(rst.get(0), is('A'));
    }
}