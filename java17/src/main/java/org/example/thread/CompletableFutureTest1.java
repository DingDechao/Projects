package org.example.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

public class CompletableFutureTest1 {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.supplyAsync(() -> {
                    for (var i = 0; i < 100; i++) {
                        System.out.println(("Current Thread Name=" + Thread.currentThread().getName()) + "--->i=" + i);
                    }
                    return 100;
                }).thenApplyAsync(result -> {
                    System.out.println("Current Thread Name=" + Thread.currentThread().getName() + "--->result=" + result);
                    return result * result;
                }, Executors.newCachedThreadPool())
                .whenComplete((result, ex) -> {
                    System.out.println("Current Thread Name=" + Thread.currentThread().getName() + "--->result=" + result);
                    ex.printStackTrace();
                });

        for (var i = 0; i < 100; i++) {
            System.out.println(("Current Thread Name=" + Thread.currentThread().getName()) + "--->i=" + i);
        }
        Thread.sleep(5_00);
    }


}
