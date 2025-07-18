package com.ddc.algorithm.linkedlist;

import java.util.Objects;

public class SinglyLinkedList<T> {
    private T value;
    private SinglyLinkedList<T> next;

    public SinglyLinkedList(T value) {
        this.value = value;
    }

    public SinglyLinkedList(T value, SinglyLinkedList<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public SinglyLinkedList<T> getNext() {
        return next;
    }

    public void setNext(SinglyLinkedList<T> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SinglyLinkedList<?> that = (SinglyLinkedList<?>) o;
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
