package org.example.thread;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest2 {
    public static void main(String[] args) throws InterruptedException {
        var completableFuture0 = CompletableFuture.supplyAsync(() -> {
            for (var i = 0; i < 100; i++) {
                System.out.println(("Current Thread Name=" + Thread.currentThread().getName()) + "--->i=" + i);
            }
            return 100;
        });
        var completableFuture1 = CompletableFuture.supplyAsync(() -> {
            for (var i = 0; i < 100; i++) {
                System.out.println(("Current Thread Name=" + Thread.currentThread().getName()) + "--->i=" + i);
            }
            return "Hello World";
        }).thenAcceptBoth(completableFuture0, (result1, result0) -> {
            System.out.println("Current Thread Name=" + Thread.currentThread().getName() + "--->result0=" + result0);
            System.out.println("Current Thread Name=" + Thread.currentThread().getName() + "--->result=" + result1);
        });

        for (var i = 0; i < 100; i++) {
            System.out.println(("Current Thread Name=" + Thread.currentThread().getName()) + "--->i=" + i);
        }
        Thread.sleep(5_00);
    }




}
