package org.example.thread;

public class RunnableTest0 implements Runnable{

    private int i;

    @Override
    public void run() {
       for (; i < 100; i++) {
           System.out.println((Thread.currentThread().getName() + "-->" + i));
       }
    }

    public static void main(String[] args) {
        for (var i = 0; i < 100; i++) {
            System.out.println((Thread.currentThread().getName() + "-->" + i));
            if (i == 20) {
                var runnableTest = new RunnableTest0();
                new Thread(runnableTest, "Thread-1").start();
                new Thread(runnableTest, "Thread-2").start();
            }
        }


    }
}
