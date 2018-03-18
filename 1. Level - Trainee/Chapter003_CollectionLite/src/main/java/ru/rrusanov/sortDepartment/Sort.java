package ru.rrusanov.sortDepartment;

import java.util.List;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.Iterator;

/**
 * The class sorts departments in flowing order.
 * K 1...n, SK 1...n, SSK 1...n. - Natural ordering
 */
public class Sort {
    /**
     * Constructor with data field.
     * @param data target collection to sort.
     */
    public Sort(List<String> data) {
        this.data = data;
    }
    /**
     * Default constructor for test method.
     */
    public Sort() {
    }
    /**
     * Data with department strings.
     */
    private List<String> data;
    /**
     * Getter for data field.
     * @return reference to target collection.
     */
    public List<String> getData() {
        return this.data;
    }
    /**
     * Sort by ascending order.
     */
    public void ascendingOrder() {
        this.data.sort(new Comparator<String>() {
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
    }
    /**
     * Sort by descending order.
     */
    public void descendingOrder() {
        this.data.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int resultComp = number(o2, 1).compareTo(number(o1, 1));

                if (resultComp == 0) {
                    if (number(o2, 2) == 0) {
                        resultComp = 1;
                    } else if (number(o1, 2) == 0) {
                        resultComp = -1;
                    } else {
                        resultComp = number(o2, 2).compareTo(number(o1, 2));
                    }
                }
                if (resultComp == 0) {
                    if (number(o2, 3) == 0) {
                        resultComp = 1;
                    } else if (number(o1, 3) == 0) {
                        resultComp = -1;
                    } else {
                        resultComp = number(o2, 3).compareTo(number(o1, 3));
                    }
                }
                return resultComp;
            }
        });
    }
    /**
     * Method add to list missed strings.
     */
    public void addMissedStrings() {
        TreeSet<String> dataSet = new TreeSet<>(this.data);
        Iterator<String> iteratorDataSet = dataSet.iterator();
        String delimiter = "\\\\";
        while (iteratorDataSet.hasNext()) {
            String currentString = iteratorDataSet.next();
            if (this.getLast(currentString)[0] == 2) {
                String stringToFind = currentString.split(delimiter)[0];
                if (!this.find(stringToFind)) {
                    this.data.add(stringToFind);
                }
            }
            if (this.getLast(currentString)[0] == 3) {
                String stringToFind = currentString.split(delimiter)[0] + "\\" + currentString.split(delimiter)[1];
                if (!this.find(stringToFind)) {
                    this.data.add(stringToFind);
                }
            }
        }

    }
    /**
     * Find string in unsorted data.
     * @param record String to find in field data collection.
     * @return true - data contain passed string record, false - not.
     */
    public boolean find(String record) {
        String dataValue = "";
        String recordValue = "";
        boolean result = false;
        recordValue += String.valueOf(this.number(record, 1));
        recordValue += String.valueOf(this.number(record, 2));
        recordValue += String.valueOf(this.number(record, 3));
        for (String item:this.data) {
            dataValue += String.valueOf(this.number(item, 1));
            dataValue += String.valueOf(this.number(item, 2));
            dataValue += String.valueOf(this.number(item, 3));
            if (dataValue.equals(recordValue)) {
                result = true;
                break;
            }
            dataValue = "";
        }
        return result;
    }
    /**
     * Method get number last section in record.
     * @param record String to analyze.
     * @return int[0] - section in String (1\2\3). int[1] - value of that section.
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
     * @param record String to analyze.
     * @param section int value number of target section.
     * @return number of target section.
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
     * @param currentChar to convert. Example -(5)
     * @return String converted char to string. Example - ("5")
     */
    public String numberReturn(char currentChar) {
        String temp = "";
        if (currentChar == '0'
            | currentChar == '1'
            | currentChar == '2'
            | currentChar == '3'
            | currentChar == '4'
            | currentChar == '5'
            | currentChar == '6'
            | currentChar == '7'
            | currentChar == '8'
            | currentChar == '9') {
            temp = String.valueOf(currentChar);
        }
        return temp;
    }
}
