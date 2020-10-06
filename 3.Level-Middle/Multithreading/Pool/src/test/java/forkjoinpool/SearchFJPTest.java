package forkjoinpool;

import org.junit.jupiter.api.Test;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The class test behavior SearchFJP.java.
 */
class SearchFJPTest {
    /**
     * The test check if passed index then find it.
     */
    @Test
    void whenIndexInArrayRangeThenFindIt() {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        int searchIndex = 99;
        Integer[] array = new Integer[100];
        RecursiveTask<Integer> task = new SearchFJP<>(
                array, 0, array.length, 0, searchIndex
        );
        assertEquals(searchIndex, pool.invoke(task));
    }
}