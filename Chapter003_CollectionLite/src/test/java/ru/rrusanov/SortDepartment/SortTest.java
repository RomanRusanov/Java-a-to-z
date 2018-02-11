package ru.rrusanov.SortDepartment;

import org.junit.Assert;
import org.junit.Test;

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

    @Test
    public void ascendingOrder() {
    }

    @Test
    public void thenStringContainsNumberWhenReturnThatNumbers() {
        String record1 = "SK13\\SSK10";
        String record2 = "SK5";
        int except1 = 13;
        int except2 = 5;
        Sort sort = new Sort();
        Integer result = sort.numberDep(record1);
        Assert.assertThat(result,is(except1));
        result = sort.numberDep(record2);
        Assert.assertThat(result,is(except2));
    }
}