package com.miskevich.performance.lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

    private List<Integer> list;
    private final int ATTEMPTS = 10;

    public ListTest(List<Integer> list) {
        this.list = list;
    }

    public void populateList() {
        for (int i = 0; i < 10_000; i++) {
            list.add(i);
        }
    }

    public void insertMiddle(Class<?> zclass) {
        int total = 0;

        for (int i = 0; i < ATTEMPTS; i++) {
            List<Integer> clone = initializeCloneList(zclass);
            classNameCheck(clone);
            clone.addAll(list);

            long start = System.currentTimeMillis();

            for (int j = 0; j < 10_000; j++) {
                clone.add(clone.size() / 2, j);
            }

            long end = System.currentTimeMillis() - start;

            System.out.println("Insert middle took: " + end + " ms");
            total += end;
        }
        System.out.println("Average: " + total / ATTEMPTS);
    }

    public void insertBegin(Class<?> zclass) {
        int total = 0;

        for (int i = 0; i < ATTEMPTS; i++) {
            List<Integer> clone = initializeCloneList(zclass);
            classNameCheck(clone);
            clone.addAll(list);

            long start = System.currentTimeMillis();

            for (int j = 0; j < 10_000; j++) {
                clone.add(0, j);
            }

            long end = System.currentTimeMillis() - start;

            System.out.println("Insert begin took: " + end + " ms");
            total += end;
        }
        System.out.println("Average: " + total / ATTEMPTS);
    }

    public void insertEnd(Class<?> zclass) {
        int total = 0;

        for (int i = 0; i < ATTEMPTS; i++) {
            List<Integer> clone = initializeCloneList(zclass);
            classNameCheck(clone);
            clone.addAll(list);

            long start = System.currentTimeMillis();

            for (int j = 0; j < 1_000_000; j++) {
                clone.add(j);
            }

            long end = System.currentTimeMillis() - start;

            System.out.println("Insert end took: " + end + " ms");
            total += end;
        }
        System.out.println("Average: " + total / ATTEMPTS);
    }

    private List<Integer> initializeCloneList(Class<?> zclass) {
        if (zclass.getName().equals(ArrayList.class.getName())) {
            return new ArrayList<>();
        } else if (zclass.getName().equals(LinkedList.class.getName())) {
            return new LinkedList<>();
        }
        return null;
    }

    private void classNameCheck(List<Integer> clone) {
        if (clone == null) {
            throw new RuntimeException("You've passed incorrect class name");
        }
    }
}
