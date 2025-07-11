package com.ddc.algorithm.mashibin.linkedlist;

import java.util.Arrays;

public class RoundRobinQueue {

    private int[] roundRobinQueue;
    private int front;
    private int rear;

    public RoundRobinQueue(int capacity) {
        roundRobinQueue = new int[capacity];
        front = 0;
        rear  = 0;
    }


    public boolean push(int element) {
        if ( (rear + 1) % roundRobinQueue.length == front) {
            return false;
        }
        roundRobinQueue[rear] = element;
        rear = (rear + 1) % roundRobinQueue.length;
        return true;
    }

    public int pop () throws Exception{
        if(front == rear) {
            throw new Exception("Queue is empty");
        }
        int element = roundRobinQueue[front];
        front = (front + 1) % roundRobinQueue.length;
        return element;
    }


    private void printQueue() {
//        System.out.println(Arrays.toString(roundRobinQueue));
        for(var i = front; i != rear; i=(i+1)%roundRobinQueue.length) {
            System.out.print(roundRobinQueue[i] + " ");
        }
        System.out.println();

    }


    public static void main(String[] args) throws Exception {
        RoundRobinQueue roundRobinQueue1 = new RoundRobinQueue(5);
        //roundRobinQueue1.pop();
        roundRobinQueue1.printQueue();
        roundRobinQueue1.push(1);
        roundRobinQueue1.printQueue();
        roundRobinQueue1.pop();
        roundRobinQueue1.printQueue();
    }
}
