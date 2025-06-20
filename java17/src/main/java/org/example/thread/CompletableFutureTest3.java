package org.example.thread;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest3 {
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
            return 100_00;
        }).acceptEither(completableFuture0, (firstResult) -> {
            System.out.println("Current Thread Name=" + Thread.currentThread().getName() + "--->firstResult=" + firstResult);
        });

        for (var i = 0; i < 100; i++) {
            System.out.println(("Current Thread Name=" + Thread.currentThread().getName()) + "--->i=" + i);
        }
        Thread.sleep(5_00);
    }




}
