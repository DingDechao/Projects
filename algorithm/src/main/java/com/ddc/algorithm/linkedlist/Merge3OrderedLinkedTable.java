package com.ddc.algorithm.linkedlist;

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

    public static SinglyListNode<Integer> mergeKOrderedLinkedTable(SinglyListNode<Integer>[] singlyListNodes) {
        SinglyListNode<Integer> singlyListNode = null;
        PriorityQueue<SinglyListNode<Integer>> head = new PriorityQueue<>(Comparator.comparingInt(SinglyListNode::getValue));
        for (var i = 0; i < singlyListNodes.length; i++) {
            if (singlyListNodes[i] != null) {
                head.add(singlyListNodes[i]);
            }
        }
        if (head.isEmpty()) return null;
        singlyListNode = head.poll();
        SinglyListNode<Integer> current = singlyListNode;
        if (current.getNext() != null) {
            head.add(current.getNext());
        }
        ;

        while (!head.isEmpty()) {
            SinglyListNode<Integer> s = head.poll();
            current.setNext(s);
            if (s.getNext() != null) {
                head.add(s.getNext());
            }
            current = s;
        }


        return singlyListNode;
    }

    public static SinglyListNode<Integer> generateFirstLinkedTable() {
        SinglyListNode<Integer> singlyListNode2 = new SinglyListNode<>(7, null);
        SinglyListNode<Integer> singlyListNode1 = new SinglyListNode<>(4, singlyListNode2);
        return new SinglyListNode<>(1, singlyListNode1);
    }

    public static SinglyListNode<Integer> generateSecondLinkedTable() {
        SinglyListNode<Integer> singlyListNode2 = new SinglyListNode<>(8, null);
        SinglyListNode<Integer> singlyListNode1 = new SinglyListNode<>(5, singlyListNode2);
        return new SinglyListNode<>(2, singlyListNode1);
    }

    public static SinglyListNode<Integer> generateThirdLinkedTable() {
        SinglyListNode<Integer> singlyListNode2 = new SinglyListNode<>(9, null);
        SinglyListNode<Integer> singlyListNode1 = new SinglyListNode<>(6, singlyListNode2);
        return new SinglyListNode<>(3, singlyListNode1);
    }

    public static void main(String[] args) {
        System.out.println(generateFirstLinkedTable());
        System.out.println(generateSecondLinkedTable());
        System.out.println(generateThirdLinkedTable());
        System.out.println(mergeKOrderedLinkedTable(new SinglyListNode[]{generateFirstLinkedTable(), generateSecondLinkedTable(), generateThirdLinkedTable()}));
    }

}
