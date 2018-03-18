package ru.rrusanov.listCompare;

import org.junit.Test;
import java.util.Arrays;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class test listCompare class.
 *
 * @author Roman Rusanov
 * @version 0.1
 * @since 22.01.2018
 */
public class ListCompareTest {

    /**
     * When all equals return 0.
     */
    @Test
    public void whenLeftAndRightEqualsThenZero() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 2, 3)
        );
        assertThat(rst, is(0));
    }

    /**
     * When left List elements less right when return -1.
     */
    @Test
    public void whenLeftLessRightThenMinis() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                Arrays.asList(1),
                Arrays.asList(1, 2, 3)
        );
        assertThat(rst, is(-1));
    }

    /**
     * When left List element bigger right when return 1.
     */
    @Test
    public void whenLeftGreatRightThenPlus() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                Arrays.asList(1, 2),
                Arrays.asList(1, 1)
        );
        assertThat(rst, is(1));
    }
}