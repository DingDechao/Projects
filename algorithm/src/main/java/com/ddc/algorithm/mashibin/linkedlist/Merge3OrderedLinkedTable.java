package com.ddc.algorithm.mashibin.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Merge3OrderedLinkedTable {
    /*
     * For given 2 ordered Linked Table
     * 1 : 1 -> 4 -> 7
     * 2:  2 -> 5 -> 8
     * 3:  3 -> 6 -> 9
     *
     * Merge 2 ordered Linked Table as below
     *  1 -> 2 -> 3 -> 4 -> 5 -> 6 ->7 -> 8 -> 9
     * */

    public static SinglyLinkedList<Integer> mergeKOrderedLinkedTable(SinglyLinkedList<Integer>[] singlyLinkedLists) {
        SinglyLinkedList<Integer> singlyLinkedList = null;
        PriorityQueue<SinglyLinkedList<Integer>> head = new PriorityQueue<>(Comparator.comparingInt(SinglyLinkedList::getValue));
        for (var i = 0; i < singlyLinkedLists.length; i++) {
            if (singlyLinkedLists[i] != null) {
                head.add(singlyLinkedLists[i]);
            }
        }
        if (head.isEmpty()) return null;
        singlyLinkedList = head.poll();
        SinglyLinkedList<Integer> current = singlyLinkedList;
        if (current.getNext() != null) {
            head.add(current.getNext());
        }
        ;

        while (!head.isEmpty()) {
            SinglyLinkedList<Integer> s = head.poll();
            current.setNext(s);
            if (s.getNext() != null) {
                head.add(s.getNext());
            }
            current = s;
        }


        return singlyLinkedList;
    }

    public static SinglyLinkedList<Integer> generateFirstLinkedTable() {
        SinglyLinkedList<Integer> singlyLinkedList2 = new SinglyLinkedList<>(7, null);
        SinglyLinkedList<Integer> singlyLinkedList1 = new SinglyLinkedList<>(4, singlyLinkedList2);
        return new SinglyLinkedList<>(1, singlyLinkedList1);
    }

    public static SinglyLinkedList<Integer> generateSecondLinkedTable() {
        SinglyLinkedList<Integer> singlyLinkedList2 = new SinglyLinkedList<>(8, null);
        SinglyLinkedList<Integer> singlyLinkedList1 = new SinglyLinkedList<>(5, singlyLinkedList2);
        return new SinglyLinkedList<>(2, singlyLinkedList1);
    }

    public static SinglyLinkedList<Integer> generateThirdLinkedTable() {
        SinglyLinkedList<Integer> singlyLinkedList2 = new SinglyLinkedList<>(9, null);
        SinglyLinkedList<Integer> singlyLinkedList1 = new SinglyLinkedList<>(6, singlyLinkedList2);
        return new SinglyLinkedList<>(3, singlyLinkedList1);
    }

    public static void main(String[] args) {
        System.out.println(generateFirstLinkedTable());
        System.out.println(generateSecondLinkedTable());
        System.out.println(generateThirdLinkedTable());
        System.out.println(mergeKOrderedLinkedTable(new SinglyLinkedList[]{generateFirstLinkedTable(), generateSecondLinkedTable(), generateThirdLinkedTable()}));
    }

}
