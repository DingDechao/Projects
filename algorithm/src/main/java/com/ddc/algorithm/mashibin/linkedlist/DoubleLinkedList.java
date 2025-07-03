package com.ddc.algorithm.mashibin.linkedlist;


import java.util.Objects;

public class DoubleLinkedList {
    private Object value;
    private DoubleLinkedList previous;
    private DoubleLinkedList next;

    public DoubleLinkedList() {
    }

    public DoubleLinkedList(Object value, DoubleLinkedList previous, DoubleLinkedList next) {
        this.value = value;
        this.previous = previous;
        this.next = next;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public DoubleLinkedList getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleLinkedList previous) {
        this.previous = previous;
    }

    public DoubleLinkedList getNext() {
        return next;
    }

    public void setNext(DoubleLinkedList next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DoubleLinkedList that = (DoubleLinkedList) o;
        return Objects.equals(value, that.value) && Objects.equals(previous, that.previous) && Objects.equals(next, that.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, previous, next);
    }

    @Override
    public String toString() {
        return "DoubleLinkedList{" +
                "value=" + value +
                ", previous=" + (previous !=null ? previous.getValue().toString() : null) +
                ", next=" + (next !=null ? next.getValue().toString() : null) +
                "}";
    }
}
