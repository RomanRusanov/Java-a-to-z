package ru.rrusanov.comparator;
import java.util.ArrayList;
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
        ArrayList<Character> leftList = this.stringToArrayList(left);
        ArrayList<Character> rightList = this.stringToArrayList(right);
        int leftListSize = leftList.size();
        int rightListSize = rightList.size();
        int leftSum = 0;
        int rightSum = 0;
        if (leftListSize < rightListSize) {
            rightSum = rightListSize - leftListSize;
        } else if (leftListSize > rightListSize) {
            leftSum = leftListSize - rightListSize;
        }
        for (int i = 0; leftListSize <= rightListSize ? leftListSize > i : rightListSize > i; i++) {
            if (leftList.get(i) < rightList.get(i)) {
                rightSum++;
            }
            if (leftList.get(i) > rightList.get(i)) {
                leftSum++;
            }
        }
        if (leftSum > rightSum) {
            result = 1;
        } else if (leftSum < rightSum) {
            result = -1;
        } else if (leftSum == rightSum) {
            result = 0;
        }
        return result;
    }
    /**
     * Method converts string into arrayList<Character>.
     * @param string to conversion
     * @return ArrayList<Character>
     */
    public ArrayList<Character> stringToArrayList(String string) {
        int index = 0;
        ArrayList<Character> result = new ArrayList<>();
        while (string.length() != index) {
            result.add(string.charAt(index));
            index++;
        }
        return result;
    }
}
