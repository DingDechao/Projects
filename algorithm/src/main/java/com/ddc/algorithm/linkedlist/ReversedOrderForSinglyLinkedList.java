package com.ddc.algorithm.linkedlist;

public class ReversedOrderForSinglyLinkedList {

    public static SinglyLinkedList<String> createExampleSinglyLinkedList() {
        SinglyLinkedList<String> singlyLinkedList2 = new SinglyLinkedList<>("3", null);
        SinglyLinkedList<String> singlyLinkedList1 = new SinglyLinkedList<>("2", singlyLinkedList2);
        return new SinglyLinkedList<>("1", singlyLinkedList1);
    }

    public static void printSinglyLinkedList(SinglyLinkedList<String> singlyLinkedList) {

        if (singlyLinkedList != null) {
            SinglyLinkedList<String> next = singlyLinkedList.getNext();
            System.out.println(singlyLinkedList);
            printSinglyLinkedList(next);
        }
    }

    public static void printSinglyLinkedList1(SinglyLinkedList<String> singlyLinkedList) {
        while (singlyLinkedList != null) {
            SinglyLinkedList<String> next = singlyLinkedList.getNext();
            System.out.println(singlyLinkedList);
            singlyLinkedList = next;
        }
    }

    public static SinglyLinkedList<String> reversedOrderForSinglyLinkedList(SinglyLinkedList<String> singlyLinkedList) {
        SinglyLinkedList<String> last = null;
        SinglyLinkedList<String> next;
        while (singlyLinkedList != null) {
            next = singlyLinkedList.getNext();
            singlyLinkedList.setNext(last);
            last = singlyLinkedList;
            singlyLinkedList = next;
        }
        return last;
    }

    public static void main(String[] args) {
        SinglyLinkedList<String> singlyLinkedList = createExampleSinglyLinkedList();
        printSinglyLinkedList1(singlyLinkedList);
        System.out.println(("==================="));
        printSinglyLinkedList(reversedOrderForSinglyLinkedList(singlyLinkedList));
    }
}
