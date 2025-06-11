package org.example.java11.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableTest {

    public static void main(String[] args) {
        var callableTest = new CallableTest();
        FutureTask<Integer> task = new FutureTask<>((Callable<Integer>) () -> {
            var i = 0;
            for (; i < 100; i++) {
                System.out.println((Thread.currentThread().getName() + "i's value " + i));
            }
            return i;
        });


        for (var i = 0; i < 100; i++) {
            System.out.println((Thread.currentThread().getName() + "i's value " + i));
            if (i == 20) {
                new Thread(task, "Have value").start();
            }
        }

        try {
            System.out.println(("Thread's value " + task.get()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
