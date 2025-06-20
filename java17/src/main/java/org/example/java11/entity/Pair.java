package org.example.java11.entity;

import java.util.function.Supplier;

public class Pair<T> {
    private T first;
    private T second;

    private Pair() {
        first = null;
        second = null;
    }

    private Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public static <T> Pair<T> makePair(Supplier<T> constr) {
        return new Pair<>(constr.get(), constr.get());
    }
}
