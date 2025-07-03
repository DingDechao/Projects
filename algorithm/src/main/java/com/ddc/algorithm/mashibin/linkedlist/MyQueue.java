package com.ddc.algorithm.mashibin.linkedlist;

import java.util.Objects;

public class MyQueue<T> {

    private SinglyLinkedList<T> head;
    private SinglyLinkedList<T> tail;
    private int size;

    public MyQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public SinglyLinkedList<T> offer(T value) {
        SinglyLinkedList<T> singlyLinkedList = new SinglyLinkedList<>(value);
        if (tail == null) {
            head = singlyLinkedList;
            tail = singlyLinkedList;
        } else {
            tail.setNext(singlyLinkedList);
            tail = singlyLinkedList;
        }
        size++;
        return singlyLinkedList;
    }

    public T poll() {
        T value = null;
        if(head != null) {
            value = head.getValue();
            head = head.getNext();
            size--;
        }
        if (head == null) tail = null;
        return value;
    }

    public T peek() {
        T value = null;
        if(head != null) {
            value = head.getValue();
        }
        return value;
    }

    public SinglyLinkedList<T> getHead() {
        return head;
    }

    public void setHead(SinglyLinkedList<T> head) {
        this.head = head;
    }

    public SinglyLinkedList<T> getTail() {
        return tail;
    }

    public void setTail(SinglyLinkedList<T> tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

//    public void setSize(int size) {
//        this.size = size;
//    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MyQueue<?> myQueue = (MyQueue<?>) o;
        return size == myQueue.size && Objects.equals(head, myQueue.head) && Objects.equals(tail, myQueue.tail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, tail, size);
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }
}
