package ru.rrusanov.comparator;
import java.util.Comparator;
/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 04.03.2018
 *
 * Class define ListCompare.
 */
public class ListCompare implements Comparator<String> {
    /**
     * Method compare strings in UTF-8 encoding.
     * @param left String
     * @param right String
     * @return result operation compare. Return 1 if left advice right, otherwise -1 and zero if equal.
     */
    @Override
    public int compare(String left, String right) {
        int result = -2;
        int leftSize = left.length();
        int rightSize = right.length();
        boolean notEqualsFind = false;
        for (int i = 0; leftSize <= rightSize ? leftSize > i : rightSize > i; i++) {
            if (left.charAt(i) > right.charAt(i)) {
                result = 1;
                notEqualsFind = true;
                break;
            }
            if (left.charAt(i) < right.charAt(i)) {
                result = -1;
                notEqualsFind = true;
                break;
            }
        }
        if (!notEqualsFind && leftSize < rightSize) {
            result = -1;
        }
        if (!notEqualsFind && leftSize > rightSize) {
            result = 1;
        }
        if (!notEqualsFind && leftSize == rightSize) {
            result = 0;
        }
        return result;
    }
}
