package com.ddc.algorithm.linkedlist;

import java.util.Objects;

public class MyQueue<T> {

    private SinglyListNode<T> head;
    private SinglyListNode<T> tail;
    private int size;

    public MyQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public SinglyListNode<T> offer(T value) {
        SinglyListNode<T> singlyListNode = new SinglyListNode<>(value);
        if (tail == null) {
            head = singlyListNode;
            tail = singlyListNode;
        } else {
            tail.setNext(singlyListNode);
            tail = singlyListNode;
        }
        size++;
        return singlyListNode;
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

    public SinglyListNode<T> getHead() {
        return head;
    }

    public void setHead(SinglyListNode<T> head) {
        this.head = head;
    }

    public SinglyListNode<T> getTail() {
        return tail;
    }

    public void setTail(SinglyListNode<T> tail) {
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
