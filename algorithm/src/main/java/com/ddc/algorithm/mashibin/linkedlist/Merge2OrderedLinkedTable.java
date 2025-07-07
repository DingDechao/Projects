package com.ddc.algorithm.mashibin.linkedlist;

public class Merge2OrderedLinkedTable {
    /*
     * For given 2 ordered Linked Table
     * 1 : 1 -> 3 -> 5
     * 2:  2 -> 4 ->6
     *
     * Merge 2 ordered Linked Table as below
     *  1 -> 2 -> 3 -> 4 -> 5 -> 6
     * */

    public SinglyLinkedList<Integer> merge2OrderedLinkedTable(SinglyLinkedList<Integer> first, SinglyLinkedList<Integer> second) {

        if (first == null || second == null) {
            return first == null ? second : first;
        }
        SinglyLinkedList<Integer> head = first.getValue() <= second.getValue() ? first : second;
        SinglyLinkedList<Integer> current = head;
        SinglyLinkedList<Integer> head1 = head.getNext();
        SinglyLinkedList<Integer> another1 = (head == first ? second : first);
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

    public SinglyLinkedList<Integer> generateFirstLinkedTable() {
        SinglyLinkedList<Integer> singlyLinkedList2 = new SinglyLinkedList<>(5, null);
        SinglyLinkedList<Integer> singlyLinkedList1 = new SinglyLinkedList<>(3, singlyLinkedList2);
        return new SinglyLinkedList<>(1, singlyLinkedList1);
    }

    public SinglyLinkedList<Integer> generateSecondLinkedTable() {
        SinglyLinkedList<Integer> singlyLinkedList2 = new SinglyLinkedList<>(6, null);
        SinglyLinkedList<Integer> singlyLinkedList1 = new SinglyLinkedList<>(4, singlyLinkedList2);
        return new SinglyLinkedList<>(2, singlyLinkedList1);
    }

    public static void main(String[] args) {
        Merge2OrderedLinkedTable merge2OrderedLinkedTable = new Merge2OrderedLinkedTable();
        System.out.println(merge2OrderedLinkedTable.generateFirstLinkedTable());
        System.out.println(merge2OrderedLinkedTable.generateSecondLinkedTable());
        System.out.println(merge2OrderedLinkedTable.merge2OrderedLinkedTable(merge2OrderedLinkedTable.generateFirstLinkedTable(), merge2OrderedLinkedTable.generateSecondLinkedTable()));
    }

}
