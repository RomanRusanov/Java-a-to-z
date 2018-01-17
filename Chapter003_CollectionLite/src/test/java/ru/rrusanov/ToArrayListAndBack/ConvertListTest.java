package ru.rrusanov.ToArrayListAndBack;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;

/**
 * Class test ConvertList.
 *
 * @author Roman Rusanov
 * @version 0.1
 * @since 17.01.18
 */
public class ConvertListTest {
    /**
     * Then pass two dimension array when return array list with elements two dimension array.
     */
    @Test
    public void thenPassArrayWhenReturnList() {
        ConvertList convertList = new ConvertList();
        int[][] array = new int[][]{
                                   {1, 2, 3},
                                   {4, 5, 6},
                                   {7, 8, 9}
        };
        List<Integer> returnedList = convertList.toList(array);
        List<Integer> expectList = new ArrayList<>(10);
        for (int i = 0; i < 9; i++) {
            expectList.add(i, i + 1);
        }
        Assert.assertThat(returnedList,is(expectList));
    }

    /**
     * Then pass collection implement List, and number rows when return array int[rows][collection.size / row]
     */
    @Test
    public void toArray() {
    }
}