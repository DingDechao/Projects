package com.ddc.algorithm.linkedlist;

import java.util.Objects;

public class MyDeque<T> {

    private DoubleListNode<T> head;
    private DoubleListNode<T> tail;
    private int size;

    public MyDeque() {
        this.size = 0;
        this.tail = null;
        this.head = null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public DoubleListNode<T> pushHead(T value) {
        DoubleListNode<T> doubleListNode = new DoubleListNode<>(value);
        if (head == null) {
            head = doubleListNode;
            tail = doubleListNode;
        } else {
            head.setPrevious(doubleListNode);
            doubleListNode.setNext(head);
            head = doubleListNode;
        }
        size++;
        return doubleListNode;

    }

    public DoubleListNode<T> pushTail(T value) {
        DoubleListNode<T> doubleListNode = new DoubleListNode<>(value);
        if (tail == null) {
            tail = doubleListNode;
            head = doubleListNode;
        } else {
            tail.setNext(doubleListNode);
            doubleListNode.setPrevious(tail);
            tail = doubleListNode;
        }
        size++;
        return doubleListNode;
    }

    public T pollHead() {
        T value = null;
        if (head == null) {
            return value;
        }
        size--;
        value = head.getValue();
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
            head.setPrevious(null);
        }
        return value;
    }

    public T pollTail() {
        T value = null;
        if (tail == null) {
            return value;
        }
        size--;
        value = tail.getValue();
        if (tail == head) {
            tail = null;
            head = null;
        } else {
            tail = tail.getPrevious();
            tail.setNext(null);
        }
        return value;
    }

    public T peekHead() {
        T value = null;
        if (head != null) {
            value = head.getValue();
        }
        return value;
    }

    public T peekTail() {
        T value = null;
        if (tail != null) {
            value = tail.getValue();
        }
        return value;
    }


    public DoubleListNode<T> getHead() {
        return head;
    }

    public void setHead(DoubleListNode<T> head) {
        this.head = head;
    }

    public DoubleListNode<T> getTail() {
        return tail;
    }

    public void setTail(DoubleListNode<T> tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MyDeque<?> myDeque = (MyDeque<?>) o;
        return size == myDeque.size && Objects.equals(head, myDeque.head) && Objects.equals(tail, myDeque.tail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, tail, size);
    }

    @Override
    public String toString() {
        return "MyDeque{" +
                "head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }
}
