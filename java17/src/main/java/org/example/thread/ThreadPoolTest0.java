package org.example.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest0 {



    public static void main(String[] args) {
        AAA aaa = new AAA();
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        executorService.submit(aaa);
        executorService.submit(aaa);
        executorService.shutdown();
    }
}

class AAA implements Runnable {
    @Override
    public void run() {
        for (var i = 0; i < 100; i++) {
            System.out.println((Thread.currentThread().getName() + "---> i=" + i));
        }
    }
}
