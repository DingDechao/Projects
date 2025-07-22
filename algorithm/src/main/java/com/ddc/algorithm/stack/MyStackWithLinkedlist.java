package com.ddc.algorithm.stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStackWithLinkedlist {

    public Queue<Integer> queue;
    public Queue<Integer> anotherQueue;


    public MyStackWithLinkedlist() {
        queue = new LinkedList<>();
        anotherQueue = new LinkedList<>();
    }

    public void push(int element) {
        queue.offer(element);
    }

    public int pop() {
        while (queue.size() > 1) {
            anotherQueue.offer(queue.poll());
        }
        int element = queue.poll();
        Queue<Integer> temp = queue;
        queue = anotherQueue;
        anotherQueue = temp;
        return element;
    }

    public int peek() {
        while (queue.size() > 1) {
            anotherQueue.offer(queue.poll());
        }
        int element = queue.poll();
        anotherQueue.offer(element);
        Queue<Integer> temp = queue;
        queue = anotherQueue;
        anotherQueue = temp;
        return element;
    }
}
