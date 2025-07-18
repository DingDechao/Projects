package com.ddc.algorithm.linkedlist;

import java.util.Objects;

public class MyDeque<T> {

    private DoubleLinkedList<T> head;
    private DoubleLinkedList<T> tail;
    private int size;

    public MyDeque() {
        this.size = 0;
        this.tail = null;
        this.head = null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public DoubleLinkedList<T> pushHead(T value) {
        DoubleLinkedList<T> doubleLinkedList = new DoubleLinkedList<>(value);
        if (head == null) {
            head = doubleLinkedList;
            tail = doubleLinkedList;
        } else {
            head.setPrevious(doubleLinkedList);
            doubleLinkedList.setNext(head);
            head = doubleLinkedList;
        }
        size++;
        return doubleLinkedList;

    }

    public DoubleLinkedList<T> pushTail(T value) {
        DoubleLinkedList<T> doubleLinkedList = new DoubleLinkedList<>(value);
        if (tail == null) {
            tail = doubleLinkedList;
            head = doubleLinkedList;
        } else {
            tail.setNext(doubleLinkedList);
            doubleLinkedList.setPrevious(tail);
            tail = doubleLinkedList;
        }
        size++;
        return doubleLinkedList;
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


    public DoubleLinkedList<T> getHead() {
        return head;
    }

    public void setHead(DoubleLinkedList<T> head) {
        this.head = head;
    }

    public DoubleLinkedList<T> getTail() {
        return tail;
    }

    public void setTail(DoubleLinkedList<T> tail) {
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
