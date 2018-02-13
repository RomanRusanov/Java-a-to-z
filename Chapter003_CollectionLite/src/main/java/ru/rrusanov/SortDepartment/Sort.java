package ru.rrusanov.SortDepartment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The class sorts departments in flowing order.
 * K 1...n, SK 1...n, SSK 1...n. - Natural ordering
 */
public class Sort {
    /**
     * Sort by ascending order.
     */
    public List<String> ascendingOrder(String[] unsorted) {
        ArrayList<String> result = new ArrayList<>();
        for (String item:unsorted) {
            result.add(item);
        }
        result.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = number(o1, 1).compareTo(number(o2, 1));
                if (result == 0) {
                    result = number(o1, 2).compareTo(number(o2, 2));
                }
                if (result == 0) {
                    result = number(o1, 3).compareTo(number(o2, 3));
                }
                return result;
            }
        });
        return result;
    }
    /**
     * Method get numeric value from specific section.
     * Delimiters for section "\"
     * (section1\section2\section3).
     * Return number.
     */
    public Integer number(String record, int section) {
        int sizeString = record.length();
        char currentChar;
        String temp = "0";
        int indexLoop = 0;
        boolean sectionMath = false;
        currentChar = record.charAt(indexLoop);
        if (section == 1) {
            sectionMath = true;
        }
        int sectionLoop = 1;
        while (!(sectionMath) && !(sizeString == indexLoop)) {
            if (currentChar == '\\') {
                sectionLoop++;
                if (section == sectionLoop) {
                    sectionMath = true;
                }
            }
            currentChar = record.charAt(indexLoop++);
        }
        while (!(sizeString == indexLoop) && !(currentChar =='\\') & sectionMath) {
                currentChar = record.charAt(indexLoop);
                if (currentChar == '0' |
                    currentChar == '1' |
                    currentChar == '2' |
                    currentChar == '3' |
                    currentChar == '4' |
                    currentChar == '5' |
                    currentChar == '6' |
                    currentChar == '7' |
                    currentChar == '8' |
                    currentChar == '9') {
                    temp += String.valueOf(currentChar);
                }
                indexLoop++;
            }
        return Integer.valueOf(temp);
    }
}
