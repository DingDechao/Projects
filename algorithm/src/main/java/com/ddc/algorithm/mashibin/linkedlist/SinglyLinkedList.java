package com.ddc.algorithm.mashibin.linkedlist;

import java.util.Objects;

public class SinglyLinkedList {
    private Object value;
    private SinglyLinkedList next;

    public SinglyLinkedList(Object value, SinglyLinkedList next) {
        this.value = value;
        this.next = next;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public SinglyLinkedList getNext() {
        return next;
    }

    public void setNext(SinglyLinkedList next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SinglyLinkedList that = (SinglyLinkedList) o;
        return Objects.equals(value, that.value) && Objects.equals(next, that.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, next);
    }

    @Override
    public String toString() {
        return "SinglyLinkedList{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
