package com.ddc.algorithm.linkedlist;

import java.util.Stack;

public class MyQueueWithStack {
    // 用两个栈实现队列
    // push栈负责入队, pop栈负责出队
    // 当pop栈为空时, 将push栈的元素全部倒入pop栈
    // 当pop栈不为空时, 直接从pop栈出队
    // 这样就能保证队列的先进先出
    // 时间复杂度: push O(1), pop O(1) 平均时间复杂度O(1)
    // 空间复杂度: O(N)
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
