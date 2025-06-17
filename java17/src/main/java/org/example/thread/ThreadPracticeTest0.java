package org.example.thread;

import org.example.thread.entity.Count;


public class ThreadPracticeTest0 {

    public static void main(String[] args) {
        Count count = new Count();
        new A("A", count).start();
        new B("B", count).start();
    }
}

class A extends Thread {

    private Count count;

    public A(String name, Count count) {
        super(name);
        this.count = count;
    }

    public void run() {
        synchronized (count) {
            int aa = 0;
            for (var i = 0; i < 53; i++) {
                if (aa != 0 && aa % 2 == 0) {
                    try {
                        aa = 0;
                        count.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Current Thread Name=" + getName() + "---> i=" + i);
                aa++;
                count.notifyAll();
            }
        }

    }
}


class B extends Thread {

    private Count count;

    public B(String name, Count count) {
        super(name);
        this.count = count;
    }

    public void run() {
        synchronized (count) {
            boolean flag = false;
            for (var c = 'A'; c <= 'Z'; c++) {
                if (flag) {
                    try {
                        flag = false;
                        count.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Current Thread Name=" + getName() + "---> c=" + (c + ""));
                flag = true;
                count.notifyAll();
            }
        }

    }
}
