package ru.rrusanov.SortDepartment;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class .
 *
 * @author Roman Rusanov
 * @version 0.1
 * @since 11.02.2018
 */
public class SortTest {
    /**
     * Test for ascendingOrder().
     */
//    @Test
//    public void thenPassUnsortedStringArrayWhenReturnSortedList() {
//        String[] unsortedStrings = new String[]{
//                "K1\\SK1",
//                "K1\\SK2",
//                "K1\\SK1\\SSK1",
//                "K1\\SK1\\SSK2",
//                "K2",
//                "K2\\SK1\\SSK1",
//                "K2\\SK1\\SSK2"
//        };
//        List<String> expect = Arrays.asList(
//                "K1\\SK1",
//                "K1\\SK1\\SSK1",
//                "K1\\SK1\\SSK2",
//                "K1\\SK2",
//                "K2",
//                "K2\\SK1\\SSK1",
//                "K2\\SK1\\SSK2"
//        );
//        Sort sort = new Sort();
//        List<String> result = sort.ascendingOrder(unsortedStrings);
//        Assert.assertThat(result,is(expect));
//    }
    /**
     * Test for addMissedStrings().
     */
    @Test
    public void thenPassListWhenAddMissedDepartment() {
        ArrayList<String> list = new ArrayList<>();
        list.add("K1\\SK1");
        list.add("K1\\SK1\\SSK1");
        list.add("K1\\SK1\\SSK2");
        list.add("K1\\SK2");
        list.add("K2");
        list.add("K2\\SK1\\SSK1");
        list.add("K2\\SK1\\SSK2");
        ArrayList<String> expect = new ArrayList<>();
        expect.add("K1");
        expect.add("K1\\SK1");
        expect.add("K1\\SK1\\SSK1");
        expect.add("K1\\SK1\\SSK2");
        expect.add("K1\\SK2");
        expect.add("K2");
        expect.add("K2\\SK1");
        expect.add("K2\\SK1\\SSK1");
        expect.add("K2\\SK1\\SSK2");
        Sort sort = new Sort(list);
        List<String> result;
        sort.addMissedStrings();
        result = sort.getUnsorted();
        Assert.assertThat(result, is(expect));
    }
    /**
     * Test for number().
     */
//    @Test
//    public void thenStringContainsNumberWhenReturnThatNumbers() {
//        String record1 = "K1\\SK13\\SSK10";
//        String record2 = "SK5";
//        int except1 = 10;
//        int except2 = 5;
//        Sort sort = new Sort();
//        Integer result = sort.number(record1, 3);
//        Assert.assertThat(result, is(except1));
//        result = sort.number(record2, 1);
//        Assert.assertThat(result, is(except2));
//    }
    /**
     * Test for getLast().
     */
//    @Test
//    public void thenPassStringWhenReturnNumberLastSection() {
//        String record1 = "K1\\SK13\\SSK10";
//        String record2 = "SK5";
//        int[] except1 = new int[] {3, 10};
//        int[] except2 = new int[] {1, 5};
//        Sort sort = new Sort();
//        int[] result = sort.getLast(record1);
//        Assert.assertThat(result, is(except1));
//        result = sort.getLast(record2);
//        Assert.assertThat(result, is(except2));
//    }
    /**
     * Test for Find.
     */
    public void thenStringExistInDataWhenReturnTrue() {
        List<String> expect = Arrays.asList(
                "K1\\SK1",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K1\\SK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        );
    }


}