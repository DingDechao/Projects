package com.ddc.algorithm.linkedlist;

public class ReversedOrderForDoubleLinkedList {

    public static DoubleLinkedList<String> createExampleDoubleLinkedList() {
        DoubleLinkedList<String> doubleLinkedList2 = new DoubleLinkedList<>();
        DoubleLinkedList<String> doubleLinkedList1 = new DoubleLinkedList<>();
        DoubleLinkedList<String> doubleLinkedList0 = new DoubleLinkedList<>();
        doubleLinkedList0.setValue("1");
        doubleLinkedList0.setPrevious(null);
        doubleLinkedList0.setNext(doubleLinkedList1);
        doubleLinkedList1.setValue("2");
        doubleLinkedList1.setPrevious(doubleLinkedList0);
        doubleLinkedList1.setNext(doubleLinkedList2);
        doubleLinkedList2.setValue("3");
        doubleLinkedList2.setPrevious(doubleLinkedList1);
        doubleLinkedList2.setNext(null);
        return doubleLinkedList0;
    }

    public static void printDoubleLinkedList(DoubleLinkedList<String> doubleLinkedList) {
        if (doubleLinkedList != null) {
            System.out.println(doubleLinkedList);
            printDoubleLinkedList(doubleLinkedList.getNext());
        }

    }

    public static DoubleLinkedList<String> reversedOrderForDoubleLinkedList(DoubleLinkedList<String> doubleLinkedList) {
        DoubleLinkedList<String> previous = null;
        DoubleLinkedList<String> next;
        while (doubleLinkedList != null) {
            next = doubleLinkedList.getNext();
            doubleLinkedList.setNext(previous);
            doubleLinkedList.setPrevious(next);
            previous = doubleLinkedList;
            doubleLinkedList = next;
        }
        return previous;
    }

    public static void main(String[] args) {
        DoubleLinkedList<String> doubleLinkedList0 = createExampleDoubleLinkedList();
        printDoubleLinkedList(doubleLinkedList0);
        System.out.println("=============================");
        DoubleLinkedList<String> doubleLinkedList = reversedOrderForDoubleLinkedList(doubleLinkedList0);
        printDoubleLinkedList(doubleLinkedList);

    }
}
