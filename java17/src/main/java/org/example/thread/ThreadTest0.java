package org.example.thread;

public class ThreadTest0 extends Thread {

    private int i;

    public void run() {
        for (; i < 100; i++) {
            System.out.println((getName() + "-->" + i));
        }
    }

    public static void main(String[] args) {
        for (var i = 0; i < 100; i++) {
            System.out.println((Thread.currentThread().getName() + "-->" + i));
            if ( i == 20) {
                new ThreadTest0().start();
                new ThreadTest0().start();
            }
        }
    }
}
