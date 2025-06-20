package org.example.thread.example0;

class A {
    public synchronized void foo(B b) {
        System.out.println("Current Thread Name: " + Thread.currentThread().getName() + " entering method foo() of instant A");
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Current Thread Name: " + Thread.currentThread().getName() + " Trying to call method last() of instance B");
        b.last();
    }

    public synchronized void last() {
        System.out.println("Entering Class A's last() method");
    }
}

class B {
    public synchronized void bar(A a) {
        System.out.println("Current Thread Name: " + Thread.currentThread().getName() + " entering method bar() of instant B");
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Current Thread Name: " + Thread.currentThread().getName() + " Trying to call method last() of instance A");
        a.last();
    }

    public synchronized void last() {
        System.out.println("Entering Class B's last() method");
    }
}

public class DeadLock implements Runnable {
    A a = new A();
    B b = new B();

    public void init() {
        Thread.currentThread().setName("Main Thread");
        a.foo(b);
        System.out.println("After entering Main Thread ");
    }

    public void run() {
        Thread.currentThread().setName("Sub Thread");
        b.bar(a);
        System.out.println("After entering Sub Thread");
    }

    public static void main(String[] args) {
        var dl = new DeadLock();
        new Thread(dl).start();
        dl.init();
    }
}

