package ru.rrusanov.SortDepartment;

import java.util.*;

/**
 * The class sorts departments in flowing order.
 * K 1...n, SK 1...n, SSK 1...n. - Natural ordering
 */
public class Sort {
    /**
     * Default constructor.
     */
    public Sort(List<String> unsorted) {
        this.unsorted = unsorted;
    }
    /**
     * Data with department strings.
     */
    private List<String> unsorted;
    /**
     * Getter for unsorted.
     */
    public List<String> getUnsorted() {
        return this.unsorted;
    }
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
                int resultComp = number(o1, 1).compareTo(number(o2, 1));
                if (resultComp == 0) {
                    resultComp = number(o1, 2).compareTo(number(o2, 2));
                }
                if (resultComp == 0) {
                    resultComp = number(o1, 3).compareTo(number(o2, 3));
                }
                return resultComp;
            }
        });
        return result;
    }
    /**
     * Method add to list missed strings.
     */
    public void addMissedStrings() {
        HashSet<String> dataSet = new HashSet<>(this.unsorted);
        HashSet<String> missedSet = new HashSet<>();
        Iterator<String> iteratorDataSet = dataSet.iterator();
        while (iteratorDataSet.hasNext()) {
            String currentString = iteratorDataSet.next();
            if (this.getLast(currentString)[0] == 2) {
                int indexLoop = 0;
                char currentChar;
                String stringToFind = "";
                while(currentString.length() > indexLoop) {
                    currentChar = currentString.charAt(indexLoop);
                    if (currentChar == '\\') {
                        break;
                    }
                    stringToFind += currentChar;
                    indexLoop++;
                }
                if (!this.find(stringToFind)) {
                    missedSet.add(stringToFind);
                }
            }
        }
    }
    /**
     * Find string in unsorted data.
     */
    public boolean find(String record) {
        String dataValue = "";
        String recordValue = "";
        for (String item:this.unsorted) {
            dataValue += String.valueOf(this.number(item,1));
            dataValue += String.valueOf(this.number(item,2));
            dataValue += String.valueOf(this.number(item,3));
        }
        recordValue += String.valueOf(this.number(record,1));
        recordValue += String.valueOf(this.number(record,2));
        recordValue += String.valueOf(this.number(record,3));
        return recordValue == dataValue ? true: false;
    }
    /**
     * Method get number last section in record.
     */
    public int[] getLast(String record) {
        int[] result = new int[2];
        int sizeString = record.length();
        int lastCharNumber = record.length() - 1;
        int indexLoop = 0;
        char currentChar;
        boolean lastFinded = false;
        String temp = "";
        String value = "";
        while (sizeString != indexLoop && !lastFinded) {
            currentChar = record.charAt(lastCharNumber--);
            if (currentChar == '\\') {
                lastFinded = true;
            }
            temp += String.valueOf(currentChar);
            indexLoop++;
        }
        sizeString = temp.length();
        lastCharNumber = temp.length() - 1;
        indexLoop = 0;
        while (sizeString != indexLoop) {
            currentChar = temp.charAt(lastCharNumber--);
            value += this.numberReturn(currentChar);
            indexLoop++;

        }
        sizeString = record.length();
        indexLoop = 0;
        int counter = 1;
        while (sizeString != indexLoop) {
            currentChar = record.charAt(indexLoop);
            if (currentChar == '\\') {
                counter++;
            }
            indexLoop++;
        }
        result[0] = counter;
        result[1] = Integer.valueOf(value);
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
        while (!(sizeString == indexLoop) && !(currentChar == '\\') && sectionMath) {
            currentChar = record.charAt(indexLoop);
            temp += this.numberReturn(currentChar);
            indexLoop++;
        }
        return Integer.valueOf(temp);
    }
    /**
     * Method return String with one char if char number.
     */
    public String numberReturn(char currentChar) {
        String temp = "";
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
            temp = String.valueOf(currentChar);
        }
        return temp;
    }
}
