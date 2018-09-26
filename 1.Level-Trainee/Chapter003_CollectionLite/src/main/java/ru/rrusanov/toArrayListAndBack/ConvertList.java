package ru.rrusanov.toArrayListAndBack;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Class convert two dimension array to list and back.
 *
 * @author Roman Rusanov
 * @version 0.1
 * @since 17.01.18
 */
public class ConvertList {
    /**
     * Method convert from two dimension array in to list collection.
     * @param array array to conversion.
     * @return converted list.
     */
    public List<Integer> toList(int[][] array) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int[] item:array) {
            for (int itemIn:item) {
                arrayList.add(itemIn);
            }
        }
        return arrayList;
    }
    /**
     * Method convert from list collection in to two dimension array.
     * @param list Collection list to conversion.
     * @param rows Number string in two dimension array.
     * @return Two dimension array, if item is not enough, when fill "0" .
     */
    public int[][] toArray(List<Integer> list, int rows) {
        Iterator<Integer> iterator = list.iterator();
        int[][] result = new int[rows][rows];
        int i = 0;
            for (int[] item:result) {
                int j = 0;
                for (int ignored :item) {
                    if (iterator.hasNext()) {
                        result[i][j] = iterator.next();
                    } else {
                        result[i][j] = 0;
                    }
                    j++;
                }
                i++;
            }
        return result;
    }
    /**
     * Method should walk through all elements of all arrays, and return new list with all elements within.
     * @param list contain arrays to convert.
     * @return List with all elements passed from list.
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        list.stream().forEach(array -> {
            for (int item:array) {
                result.add(item);
            }
        });
        return result;
    }
}
