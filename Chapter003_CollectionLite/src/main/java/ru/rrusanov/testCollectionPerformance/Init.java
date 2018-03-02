package ru.rrusanov.testCollectionPerformance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;
/**
 * Class demonstrates the speed with which work of collection, adding and removing elements.
 * *
 * @author Roman Rusanov
 * @version 0.1
 * @since 12.01.18
 */
public class Init {
    /**
     * Main method.
     * @param args arguments.
     */
    public static void main(String[] args) {

        TestCollectionPerformance testCollectionPerformance = new TestCollectionPerformance();
        LinkedList<String> linkedList = new LinkedList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        TreeSet<String> treeSet = new TreeSet<>();
        final int n = 100000;

        testCollectionPerformance.printTable(arrayList, "ArrayList", n);

        testCollectionPerformance.printTable(linkedList, "LinkedList", n);

        testCollectionPerformance.printTable(treeSet, "TreeSet", n);
    }
}