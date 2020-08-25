package com.ddc.projects.java8.thread;

public class InheritThreadDemo extends Thread {

    private int i;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println((getName() + "-" + i));
        }
    }

    /*
        main-0
        main-1
        main-2
        main-3
        main-4
        main-5
        main-6
        InheritThreadDemo_1-0
        InheritThreadDemo_1-1
        InheritThreadDemo_2-0
        main-7
        main-8
        main-9
        main-10
        main-11
        main-12
        main-13
        main-14
        main-15
        InheritThreadDemo_2-1
        InheritThreadDemo_1-2
        InheritThreadDemo_2-2
        main-16
        InheritThreadDemo_2-3
        InheritThreadDemo_1-3
        InheritThreadDemo_1-4
        InheritThreadDemo_1-5
        InheritThreadDemo_1-6
        InheritThreadDemo_1-7
        InheritThreadDemo_1-8
        InheritThreadDemo_2-4
        main-17
        InheritThreadDemo_2-5
        InheritThreadDemo_2-6
        InheritThreadDemo_1-9
        InheritThreadDemo_2-7
        InheritThreadDemo_2-8
        InheritThreadDemo_2-9
        main-18
        main-19
    */
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println((Thread.currentThread().getName() + "-" + i));
            if (i == 5) {
                Thread inheritThreadDemo_1 = new InheritThreadDemo();
                inheritThreadDemo_1.setName("InheritThreadDemo_1");
                inheritThreadDemo_1.start();
                Thread inheritThreadDemo_2 = new InheritThreadDemo();
                inheritThreadDemo_2.setName("InheritThreadDemo_2");
                inheritThreadDemo_2.start();
            }
        }
    }
}
