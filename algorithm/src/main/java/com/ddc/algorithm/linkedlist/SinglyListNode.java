package com.ddc.algorithm.linkedlist;

import java.util.Objects;

public class SinglyListNode<T> {
    private T value;
    private SinglyListNode<T> next;

    public SinglyListNode(T value) {
        this.value = value;
    }

    public SinglyListNode(T value, SinglyListNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public SinglyListNode<T> getNext() {
        return next;
    }

    public void setNext(SinglyListNode<T> next) {
        this.next = next;
    }


    public SinglyListNode<T> removeNode(SinglyListNode<T> singlyListNode, T value) {
        while (singlyListNode != null) {
            if (singlyListNode.value != value) {
                break;
            }
            singlyListNode = singlyListNode.next;
        }
        SinglyListNode<T> pre = singlyListNode;
        SinglyListNode<T> current = singlyListNode;
        while (current != null) {
            if (current.value == value) {
                pre.next = current.next;
            } else {
                pre = current;
            }
            current = current.next;
        }
        return singlyListNode;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SinglyListNode<?> that = (SinglyListNode<?>) o;
        return Objects.equals(value, that.value) && Objects.equals(next, that.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, next);
    }

    @Override
    public String toString() {
        return "SinglyListNode{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
