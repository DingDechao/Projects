package com.ddc.algorithm.linkedlist;

public class Merge2OrderedLinkedTable {
    /*
     * For given 2 ordered Linked Table
     * 1 : 1 -> 3 -> 5
     * 2:  2 -> 4 ->6
     *
     * Merge 2 ordered Linked Table as below
     *  1 -> 2 -> 3 -> 4 -> 5 -> 6
     * */

    public SinglyListNode<Integer> merge2OrderedLinkedTable(SinglyListNode<Integer> first, SinglyListNode<Integer> second) {

        if (first == null || second == null) {
            return first == null ? second : first;
        }
        SinglyListNode<Integer> head = first.getValue() <= second.getValue() ? first : second;
        SinglyListNode<Integer> current = head;
        SinglyListNode<Integer> head1 = head.getNext();
        SinglyListNode<Integer> another1 = (head == first ? second : first);
        ;
        while (head1 != null && another1 != null) {
            if (head1.getValue() <= another1.getValue()) {
                current.setNext(head1);
                head1 = head1.getNext();
            } else {
                current.setNext(another1);
                another1 = another1.getNext();
            }
            current = current.getNext();
        }
        if (head1 == null) {
            current.setNext(another1);
        } else {
            current.setNext(head1);
        }

        return head;
    }

    public SinglyListNode<Integer> generateFirstLinkedTable() {
        SinglyListNode<Integer> singlyListNode2 = new SinglyListNode<>(5, null);
        SinglyListNode<Integer> singlyListNode1 = new SinglyListNode<>(3, singlyListNode2);
        return new SinglyListNode<>(1, singlyListNode1);
    }

    public SinglyListNode<Integer> generateSecondLinkedTable() {
        SinglyListNode<Integer> singlyListNode2 = new SinglyListNode<>(6, null);
        SinglyListNode<Integer> singlyListNode1 = new SinglyListNode<>(4, singlyListNode2);
        return new SinglyListNode<>(2, singlyListNode1);
    }

    public static void main(String[] args) {
        Merge2OrderedLinkedTable merge2OrderedLinkedTable = new Merge2OrderedLinkedTable();
        System.out.println(merge2OrderedLinkedTable.generateFirstLinkedTable());
        System.out.println(merge2OrderedLinkedTable.generateSecondLinkedTable());
        System.out.println(merge2OrderedLinkedTable.merge2OrderedLinkedTable(merge2OrderedLinkedTable.generateFirstLinkedTable(), merge2OrderedLinkedTable.generateSecondLinkedTable()));
    }

}
