package com.miskevich.performance.lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PerformanceTest {

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        ListTest arrayListTest = new ListTest(arrayList);
        ListTest linkedListTest = new ListTest(linkedList);

        arrayListTest.populateList();
        linkedListTest.populateList();

        insertMiddle(arrayListTest, linkedListTest);
        insertBegin(arrayListTest, linkedListTest);
        insertEnd(arrayListTest, linkedListTest);
    }

    private static void insertMiddle(ListTest arrayListTest, ListTest linkedListTest) {
        System.out.println("ArrayList insert middle");
        arrayListTest.insertMiddle(ArrayList.class);

        System.out.println("LinkedList insert middle");
        linkedListTest.insertMiddle(LinkedList.class);
    }

    private static void insertBegin(ListTest arrayListTest, ListTest linkedListTest) {
        System.out.println("ArrayList insert begin");
        arrayListTest.insertBegin(ArrayList.class);

        System.out.println("LinkedList insert begin");
        linkedListTest.insertBegin(LinkedList.class);
    }

    private static void insertEnd(ListTest arrayListTest, ListTest linkedListTest) {
        System.out.println("ArrayList insert end");
        arrayListTest.insertEnd(ArrayList.class);

        System.out.println("LinkedList insert end");
        linkedListTest.insertEnd(LinkedList.class);
    }


}
