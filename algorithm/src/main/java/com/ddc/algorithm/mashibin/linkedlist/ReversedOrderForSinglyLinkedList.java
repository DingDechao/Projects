package com.ddc.algorithm.mashibin.linkedlist;

public class ReversedOrderForSinglyLinkedList {

    public static SinglyLinkedList createExampleSinglyLinkedList() {
        SinglyLinkedList singlyLinkedList2 = new SinglyLinkedList("3", null);
        SinglyLinkedList singlyLinkedList1 = new SinglyLinkedList("2", singlyLinkedList2);
        SinglyLinkedList singlyLinkedList0 = new SinglyLinkedList("1", singlyLinkedList1);
        return singlyLinkedList0;
    }

    public static void printSinglyLinkedList(SinglyLinkedList singlyLinkedList) {

        if (singlyLinkedList != null) {
            SinglyLinkedList next = singlyLinkedList.getNext();
            System.out.println(singlyLinkedList.toString());
            printSinglyLinkedList(next);
        }
    }

    public static void printSinglyLinkedList1(SinglyLinkedList singlyLinkedList) {
        while (singlyLinkedList != null) {
            SinglyLinkedList next = singlyLinkedList.getNext();
            System.out.println(singlyLinkedList.toString());
            singlyLinkedList = next;
        }
    }

    public static SinglyLinkedList reversedOrderForSinglyLinkedList(SinglyLinkedList singlyLinkedList) {
        SinglyLinkedList last = null;
        SinglyLinkedList next = null;
        while (singlyLinkedList != null) {
            next = singlyLinkedList.getNext();
            singlyLinkedList.setNext(last);
            last = singlyLinkedList;
            singlyLinkedList = next;
        }

        return last;
    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = createExampleSinglyLinkedList();
        printSinglyLinkedList1(singlyLinkedList);
        System.out.println(("==================="));
        printSinglyLinkedList(reversedOrderForSinglyLinkedList(singlyLinkedList));
    }
}
