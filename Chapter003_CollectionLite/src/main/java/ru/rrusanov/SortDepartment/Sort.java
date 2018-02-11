package ru.rrusanov.SortDepartment;

import java.util.ArrayList;
import java.util.List;

/**
 * The class sorts departments in flowing order.
 * K 1...n, SK 1...n, SSK 1...n. - Natural ordering
 */
public class Sort {
    /**
     * Sort by ascending order.
     */
//    public List<String> ascendingOrder(String[] unsorted) {
//        ArrayList<String> result;
//
//        return result;
//    }
    /**
     * Method get first numeric value "_" before char "\"(K_\...\...).
     * Return department number.
     */
    public Integer numberDep(String record) {
        int sizeString = record.length();
        char currentChar;
        String temp = "";
        int indexLoop = 0;
        do {
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
        } while (!(sizeString == indexLoop) && !(currentChar =='\\'));
        return Integer.valueOf(temp);
    }
    /**
     * Method get second numeric value "_" after char "\"(...\SK_\...).
     * Return  service number.
     */
    public Integer numberSer(String record) {
        int sizeString = record.length();
        char currentChar;
        String temp = "";
        int indexLoop = 0;
        boolean sectionFound = false;
        do {
            currentChar = record.charAt(indexLoop);
            if (currentChar == '\\') {
                sectionFound = true;
            }
            if (sectionFound) {
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
            }
            indexLoop++;
        } while (!(sizeString == indexLoop) && !(currentChar =='\\'));
        return Integer.valueOf(temp);
}
