package com.ddc.algorithm.linkedlist;


import java.util.Objects;

public class DoubleListNode<T> {
    private T value;
    private DoubleListNode<T> previous;
    private DoubleListNode<T> next;

    public DoubleListNode() {
    }

    public DoubleListNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public DoubleListNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleListNode<T> previous) {
        this.previous = previous;
    }

    public DoubleListNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleListNode<T> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DoubleListNode<?> that = (DoubleListNode<?>) o;
        return Objects.equals(value, that.value) && Objects.equals(previous, that.previous) && Objects.equals(next, that.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, previous, next);
    }

    @Override
    public String toString() {
        return "DoubleListNode{" +
                "value=" + value +
                ", previous=" + (previous !=null ? previous.getValue().toString() : null) +
                ", next=" + (next !=null ? next.getValue().toString() : null) +
                "}";
    }
}
