package com.ddc.algorithm.linkedlist;

public class ReversedOrderForSinglyLinkedList {

    public static SinglyListNode<String> createExampleSinglyLinkedList() {
        SinglyListNode<String> singlyListNode2 = new SinglyListNode<>("3", null);
        SinglyListNode<String> singlyListNode1 = new SinglyListNode<>("2", singlyListNode2);
        return new SinglyListNode<>("1", singlyListNode1);
    }

    public static void printSinglyLinkedList(SinglyListNode<String> singlyListNode) {

        if (singlyListNode != null) {
            SinglyListNode<String> next = singlyListNode.getNext();
            System.out.println(singlyListNode);
            printSinglyLinkedList(next);
        }
    }

    public static void printSinglyLinkedList1(SinglyListNode<String> singlyListNode) {
        while (singlyListNode != null) {
            SinglyListNode<String> next = singlyListNode.getNext();
            System.out.println(singlyListNode);
            singlyListNode = next;
        }
    }

    public static SinglyListNode<String> reversedOrderForSinglyLinkedList(SinglyListNode<String> singlyListNode) {
        SinglyListNode<String> last = null;
        SinglyListNode<String> next;
        while (singlyListNode != null) {
            next = singlyListNode.getNext();
            singlyListNode.setNext(last);
            last = singlyListNode;
            singlyListNode = next;
        }
        return last;
    }

    public static void main(String[] args) {
        SinglyListNode<String> singlyListNode = createExampleSinglyLinkedList();
        printSinglyLinkedList1(singlyListNode);
        System.out.println(("==================="));
        printSinglyLinkedList(reversedOrderForSinglyLinkedList(singlyListNode));
    }
}
