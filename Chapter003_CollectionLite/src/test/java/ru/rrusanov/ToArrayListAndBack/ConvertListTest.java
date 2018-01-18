package ru.rrusanov.ToArrayListAndBack;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
        Assert.assertThat(returnedList, is(expectList));
    }

    /**
     * Then pass collection implement List, and number rows when return array int[rows][row].
     */
    @Test
    public void thenPassCollectionWhenReturnArray() {
        ConvertList convertList = new ConvertList();
        int[][] expect = new int[][]{
                                   {1, 2, 3, 4},
                                   {5, 6, 7, 8},
                                   {9, 10, 11, 12},
                                   {13, 0, 0, 0}
        };
        List<Integer> list = new ArrayList<>(9);
        for (int i = 0; i < 13; i++) {
            list.add(i, i + 1);
        }
        int[][]result = convertList.toArray(list, 4);
        Assert.assertThat(result, is(expect));
    }

    /**
     * Then pass collection with arrays int, when return list with all elements of arrays.
     */
    @Test
    public void thenPassCollectionArraysWhenReturnList() {
        ConvertList convertList = new ConvertList();
        List<Integer> expect = new ArrayList<>();
        expect.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<int[]> listToPass = new ArrayList<>(Arrays.asList(new int[] {1, 2}, new int[] {3, 4, 5, 6}));
        List<Integer> result = convertList.convert(listToPass);
        Assert.assertThat(result, is(expect));
    }
}