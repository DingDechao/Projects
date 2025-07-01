package org.example.thread;

import java.util.concurrent.FutureTask;

public class CallableTest0 {
    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            var i = 0;
            for (; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "----------------> i = " + i);
            }
            return i;
        });

        for (var i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "-----------------> i = " + i);
            if (i == 20) {
                new Thread(futureTask, "CallableTest0").start();
            }
        }

        try {
            System.out.println("futureTask.get() ---> " + futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
