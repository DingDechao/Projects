package org.example.thread;

public class CallRunMethodTest0 extends Thread {

    private int i;

    public void run() {
        for (; i < 100; i++) {
            System.out.println("getName=" + getName() + "--> i=" + i);
            System.out.println("Current Thread Name=" + Thread.currentThread().getName() + "--> i=" + i);
        }
    }

    public static void main(String[] args) {
        new CallRunMethodTest0().run();
        new CallRunMethodTest0().run();
    }
}
