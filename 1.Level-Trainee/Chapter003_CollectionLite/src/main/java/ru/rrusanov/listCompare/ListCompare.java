package ru.rrusanov.listCompare;
import java.util.Comparator;
import java.util.List;
/**
 * Class compare to List<Integer> by each element..
 *
 * @author Roman Rusanov
 * @version 0.1
 * @since 22.01.2018
 */
public class ListCompare implements Comparator<List<Integer>> {
    /**
     * Compare two Integer List by each element.
     * If lists equal return 0;
     * If left List less return -1;
     * if left bigger return 1;
     * @param left first List of Integer.
     * @param right second List of Integer.
     * @return int value result comparision (0,1,-1).
     */
    @Override
    public int compare(List<Integer> left, List<Integer> right) {
        int result = 0; // default state.
        int leftSize = left.size();
        int rightSize = right.size();
        if (leftSize < rightSize) {
            result = -1;
        } else if (leftSize > rightSize) {
            result = 1;
        } else {
            for (int i = 0; i < leftSize; i++) {
                if (left.get(i) < right.get(i)) {
                    result = -1;
                    break;
                } else if (left.get(i) > right.get(i)) {
                    result = 1;
                    break;
                }
            }
        }
        return result;
    }
}
