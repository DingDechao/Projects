package com.ddc.algorithm.stack;

import java.util.Stack;

public class MyStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MyStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int element) {
        if (minStack.isEmpty() || element < getMin()) {
            minStack.push(element);
        } else {
            minStack.push(getMin());
        }
        this.stack.push(element);
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return minStack.peek();
    }

    public int pop() {
        if(stack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        minStack.pop();
        return stack.pop();
    }

    public static void main(String[] args) {
        MyStack stack2 = new MyStack();
        stack2.push(3);
        System.out.println(stack2.getMin());
        stack2.push(4);
        System.out.println(stack2.getMin());
        stack2.push(1);
        System.out.println(stack2.getMin());
        System.out.println(stack2.pop());
        System.out.println(stack2.getMin());
    }


}
