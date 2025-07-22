package com.ddc.algorithm.linkedlist;

import java.util.Stack;

public class MyQueueWithStack {

    public Stack<Integer> pushStack;
    public Stack<Integer> popStack;

    public MyQueueWithStack() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void pushToPop() {
        if (popStack.empty()) {
            while (!pushStack.empty()) {
                popStack.push(pushStack.pop());
            }
        }
    }

    public void push(int element) {
        pushStack.push(element);
        pushToPop();
    }

    public int poll() {
        if (popStack.empty() && pushStack.empty()) {
            throw new RuntimeException("Queue is empty");
        }

        pushToPop();
        return popStack.pop();
    }

    public int peek() {
        if (popStack.empty() && pushStack.empty()) {
            throw new RuntimeException("Queue is empty");
        }

        pushToPop();
        return popStack.peek();
    }

    public static void main(String[] args) {
        MyQueueWithStack test = new MyQueueWithStack();
        test.push(1);
        test.push(2);
        test.push(3);
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
    }
}
