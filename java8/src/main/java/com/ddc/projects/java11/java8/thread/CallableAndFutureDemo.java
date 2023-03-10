package com.ddc.projects.java11.java8.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableAndFutureDemo {

    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<>((Callable<Integer>)() -> {
            Integer i = 0;
            for (i = 0; i < 100; i++) {
                System.out.println((Thread.currentThread().getName() + "---" + i));
            }
            return i;
        });

        for (int i = 0; i < 100; i++) {
            System.out.println((Thread.currentThread().getName() + "-" + i));
            if(i == 20) {
                new Thread(futureTask, "callable's thread").start();
            }
        }

        try {
            System.out.println("------" + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
