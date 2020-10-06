package forkjoinpool;

import java.util.concurrent.RecursiveTask;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 06.10.2020
 * email roman9628@gmail.com
 * The class describe search index of array if search
 * segment length > 10 using fork join pool, otherwise use sequential search.
 *
 * @param <T> Element that array store.
 */
public class SearchFJP<T> extends RecursiveTask<Integer> {
    /**
     * The field contain array.
     */
    private T[] array;
    /**
     * The field contain start position to find in task.
     */
    private int start;
    /**
     * The field contain end position to find in task.
     */
    private int end;
    /**
     * The field contain start index in current task.
     */
    private int startIndex;
    /**
     * The field contain index to search.
     */
    private int searchIndex;

    /**
     * The default constructor.
     * @param array Passed array.
     * @param start Start position.
     * @param end End position.
     * @param startIndex Start index in current task.
     * @param searchIndex Index to search.
     */
    public SearchFJP(T[] array, int start, int end, int startIndex, int searchIndex) {
        if (array == null) {
            throw new IllegalArgumentException("Passed array is NULL!");
        }
        this.array = array;
        this.start = start;
        this.end = end;
        this.startIndex = startIndex;
        this.searchIndex = searchIndex;
    }

    /**
     * The main computation performed by this task.
     *
     * @return the result of the computation
     * Integer value if index find return value from 0 to array.length.
     */
    @Override
    protected Integer compute() {
        if ((this.end - this.start) > 10) {
            int middle = (this.start + this.end) / 2;
            RecursiveTask<Integer> task1 = new SearchFJP<T>(
                    this.array, start, middle, start, this.searchIndex
            );
            RecursiveTask<Integer> task2 = new SearchFJP<T>(
                    this.array, middle, end, middle, this.searchIndex
            );
            task1.fork();
            task2.fork();
            return task1.join() + task2.join();
        } else {
            return serialSearch();
        }
    }

    /**
     * The method find index in current segment.
     * @return Int value index.
     * if index not found or index 1 return 0, otherwise return number
     * in range array length.
     */
    private Integer serialSearch() {
        int currentIndex = startIndex;
        for (int i = start; i < end; i++) {
            if (this.searchIndex == currentIndex) {
                return currentIndex;
            }
            currentIndex++;
        }
        return 0;
    }
}