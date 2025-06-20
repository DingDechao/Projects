package org.example.thread;

import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolTest1 {
}


class RecursiveTaskTest0 extends RecursiveTask<Integer> {
    private static final int THREADSHOLD = 10;
    private int[] arr;
    private int start;
    private int end;

    public RecursiveTaskTest0 (int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        if (end - start < THREADSHOLD) {
            for (var i = start; i < end; i++) {
                sum += arr[i];
            }
            return sum;
        } else {
            int middle = (end - start) / 2;
            var left = new RecursiveTaskTest0(arr, start, middle);
            var right = new RecursiveTaskTest0(arr, middle, end);
            left.fork();
            right.fork();
            return left.join() + right.join();
        }
    }
}