package ru.rrusanov.ToArrayListAndBack;

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
     * Methods convert from two dimension array in to list collection.
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
     * Methods convert from list collection in to two dimension array.
     * @param list Collection list to conversion.
     * @param rows Number string in two dimension array.
     * @return Two dimension array, if item is not enough, when fill "0" .
     */
    public int[][] toArray(List<Integer> list, int rows) {
        Iterator<Integer> iterator = list.iterator();
        int listSize = list.size();
        int[][] result = new int[rows][listSize / rows];
        int resultSize = rows * (listSize / rows);
        int counter = 0;
        while (counter <= resultSize) {
            for (int[] item:result) {
                for (int itemIn:item) {
                    if (iterator.hasNext()) {
                        itemIn = iterator.next();
                    } else {
                        itemIn = 0;
                    }
                    counter++;
                }
            }
        }
        return result;
    }
}
