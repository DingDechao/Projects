package com.ddc.algorithm.linkedlist;

public class RoundRobinQueue1 {

    public int begin;
    public int end;
    public int size;
    public int[] array;

    public RoundRobinQueue1(int capacity) {
        this.begin = 0;
        this.end = 0;
        this.size = 0;
        this.array = new int[capacity];
    }

    public void push(int element) {
        if (size >= array.length) {
            throw new RuntimeException("Queue is full");
        }

        size++;
        array[end] = element;
        end = nextIndex(end);
    }

    public int pop() {
        if (size < 1) {
            throw new RuntimeException("Queue is empty");
        }
        size--;
        int element = array[begin];
        begin = nextIndex(begin);
        return element;
    }

    private int nextIndex(int i) {
        return i < array.length - 1 ? i + 1 : 0;
    }
}
