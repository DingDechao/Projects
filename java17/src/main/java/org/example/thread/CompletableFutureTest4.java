package org.example.thread;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class CompletableFutureTest4 {
    public static void main(String[] args) throws InterruptedException {
        Supplier<Integer> supplier = () -> {
            for (var i = 0; i < 100; i++) {
                System.out.println(("Current Thread Name=" + Thread.currentThread().getName()) + "--->i=" + i);
            }
            return 100;
        };
        CompletableFuture.allOf(CompletableFuture.supplyAsync(supplier),
                CompletableFuture.supplyAsync(supplier),
                CompletableFuture.supplyAsync(supplier)).thenRun(() -> {
            System.out.println("Current Thread Name=" + Thread.currentThread().getName() + "--->" + "All task is done");
        });

        for (var i = 0; i < 100; i++) {
            System.out.println(("Current Thread Name=" + Thread.currentThread().getName()) + "--->i=" + i);
        }
        Thread.sleep(5_00);
    }




}
