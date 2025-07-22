package com.ddc.algorithm.linkedlist;

public class ReversedOrderForDoubleLinkedList {

    public static DoubleListNode<String> createExampleDoubleLinkedList() {
        DoubleListNode<String> doubleListNode2 = new DoubleListNode<>();
        DoubleListNode<String> doubleListNode1 = new DoubleListNode<>();
        DoubleListNode<String> doubleListNode0 = new DoubleListNode<>();
        doubleListNode0.setValue("1");
        doubleListNode0.setPrevious(null);
        doubleListNode0.setNext(doubleListNode1);
        doubleListNode1.setValue("2");
        doubleListNode1.setPrevious(doubleListNode0);
        doubleListNode1.setNext(doubleListNode2);
        doubleListNode2.setValue("3");
        doubleListNode2.setPrevious(doubleListNode1);
        doubleListNode2.setNext(null);
        return doubleListNode0;
    }

    public static void printDoubleLinkedList(DoubleListNode<String> doubleListNode) {
        if (doubleListNode != null) {
            System.out.println(doubleListNode);
            printDoubleLinkedList(doubleListNode.getNext());
        }

    }

    public static DoubleListNode<String> reversedOrderForDoubleLinkedList(DoubleListNode<String> doubleListNode) {
        DoubleListNode<String> previous = null;
        DoubleListNode<String> next;
        while (doubleListNode != null) {
            next = doubleListNode.getNext();
            doubleListNode.setNext(previous);
            doubleListNode.setPrevious(next);
            previous = doubleListNode;
            doubleListNode = next;
        }
        return previous;
    }

    public static void main(String[] args) {
        DoubleListNode<String> doubleListNode0 = createExampleDoubleLinkedList();
        printDoubleLinkedList(doubleListNode0);
        System.out.println("=============================");
        DoubleListNode<String> doubleListNode = reversedOrderForDoubleLinkedList(doubleListNode0);
        printDoubleLinkedList(doubleListNode);

    }
}
