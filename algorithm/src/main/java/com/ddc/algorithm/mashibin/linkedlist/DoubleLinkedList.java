package com.ddc.algorithm.mashibin.linkedlist;


import java.util.Objects;

public class DoubleLinkedList<T> {
    private T value;
    private DoubleLinkedList<T> previous;
    private DoubleLinkedList<T> next;

    public DoubleLinkedList() {
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public DoubleLinkedList<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleLinkedList<T> previous) {
        this.previous = previous;
    }

    public DoubleLinkedList<T> getNext() {
        return next;
    }

    public void setNext(DoubleLinkedList<T> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DoubleLinkedList<?> that = (DoubleLinkedList<?>) o;
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
