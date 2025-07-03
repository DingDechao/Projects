package com.ddc.algorithm.mashibin.linkedlist;

import java.util.Objects;

public class MyStack<T> {

    private SinglyLinkedList<T> tail;
    private int size;

    public MyStack() {
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public SinglyLinkedList<T> push(T value) {
        SinglyLinkedList<T> singlyLinkedList = new SinglyLinkedList<>(value);
        if (tail == null) {
            tail = singlyLinkedList;
        } else {
            singlyLinkedList.setNext(tail);
            tail = singlyLinkedList;
        }
        size++;
        return singlyLinkedList;
    }

    public T pop() {
        T value = null;
        if (tail != null) {
            value = tail.getValue();
            tail = tail.getNext();
            size--;
        }
        return value;
    }

    public T peek() {
        T value = null;
        if (tail != null) {
            value = tail.getValue();
        }
        return value;
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
        MyStack<?> myQueue = (MyStack<?>) o;
        return size == myQueue.size && Objects.equals(tail, myQueue.tail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tail, size);
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "tail=" + tail +
                ", size=" + size +
                '}';
    }
}
