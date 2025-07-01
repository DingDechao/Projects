package org.example.thread;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest0 {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.supplyAsync(() -> {
            for (var i = 0; i < 100; i++) {
                System.out.println(("Current Thread Name=" + Thread.currentThread().getName()) + "--->i=" + i);
            }
            return 100;
        }).whenComplete((result, ex) -> {
            System.out.println(result);
            ex.printStackTrace();
        });

        for (var i = 0; i < 100; i++) {
            System.out.println(("Current Thread Name=" + Thread.currentThread().getName()) + "--->i=" + i);
        }
        Thread.sleep(5_00);
    }




}
