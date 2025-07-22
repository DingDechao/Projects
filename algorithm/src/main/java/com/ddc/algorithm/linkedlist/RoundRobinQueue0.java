package com.ddc.algorithm.linkedlist;

public class RoundRobinQueue0 {

    private int[] roundRobinQueue;
    private int front;
    private int rear;

    public RoundRobinQueue0(int capacity) {
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
        for(var i = front; i != rear; i=(i+1)%roundRobinQueue.length) {
            System.out.print(roundRobinQueue[i] + " ");
        }
        System.out.println();

    }


    public static void main(String[] args) throws Exception {
        RoundRobinQueue0 roundRobinQueue01 = new RoundRobinQueue0(5);
        //roundRobinQueue01.pop();
        roundRobinQueue01.printQueue();
        roundRobinQueue01.push(1);
        roundRobinQueue01.printQueue();
        roundRobinQueue01.pop();
        roundRobinQueue01.printQueue();
    }
}
