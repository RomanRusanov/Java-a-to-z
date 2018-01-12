package ru.rrusanov.TestCollectionPerformance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

public class init {
    public static void main(String[] args) {
        TestCollectionPerformance testCollectionPerformance = new TestCollectionPerformance();
        LinkedList<String> linkedList = new LinkedList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        TreeSet<String> treeSet = new TreeSet<>();
        int n = 100;

        testCollectionPerformance.printTable(linkedList,"LinkedList",n);

        testCollectionPerformance.printTable(arrayList,"ArrayList",n);

        testCollectionPerformance.printTable(treeSet,"TreeSet",n);
    }
}
