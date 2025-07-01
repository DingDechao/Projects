package org.example.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

public class ForkJoinPoolTest0 {
    public static void main(String[] args) throws Exception{
        var forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(new RecursiveActionTest0(0, 50));
        forkJoinPool.awaitTermination(2, TimeUnit.SECONDS);
        forkJoinPool.shutdown();
    }
}

class RecursiveActionTest0 extends RecursiveAction {
    private static final int THRESHOLD = 10;
    private int start;
    private int end;

    public RecursiveActionTest0(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if (end - start <= THRESHOLD) {
            for (var i = start; i <= end; i++) {
                System.out.println((Thread.currentThread().getName() + "---> i=" + i));
            }
        } else {
            int middle = (start + end) /2;
            var left = new RecursiveActionTest0(start, middle);
            var right = new RecursiveActionTest0(middle, end);

            left.fork();
            right.fork();
        }
    }
}
