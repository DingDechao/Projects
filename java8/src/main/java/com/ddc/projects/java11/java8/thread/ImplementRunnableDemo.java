package com.ddc.projects.java11.java8.thread;

public class ImplementRunnableDemo implements Runnable {

    private int i;
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println((Thread.currentThread().getName() + "-" + i));
        }
    }

    /*
    *
        main-0
        main-1
        main-2
        main-3
        main-4
        main-5
        main-6
        main-7
        implementRunnableDemo_2-0
        implementRunnableDemo_1-0
        implementRunnableDemo_2-1
        main-8
        implementRunnableDemo_2-2
        implementRunnableDemo_1-1
        implementRunnableDemo_2-3
        main-9
        implementRunnableDemo_2-4
        implementRunnableDemo_1-2
        implementRunnableDemo_1-3
        implementRunnableDemo_2-5
        implementRunnableDemo_1-4
        implementRunnableDemo_1-5
        implementRunnableDemo_2-6
        implementRunnableDemo_1-6
        implementRunnableDemo_1-7
        implementRunnableDemo_1-8
        implementRunnableDemo_1-9
        implementRunnableDemo_2-7
        implementRunnableDemo_2-8
        implementRunnableDemo_2-9
    * */
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println((Thread.currentThread().getName() + "-" + i));
            if (i == 5) {
                Runnable runnable = new ImplementRunnableDemo();
                new Thread(runnable, "implementRunnableDemo_1").start();
                new Thread(runnable, "implementRunnableDemo_2").start();
            }
        }
    }
}
