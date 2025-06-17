package org.example.thread;

public class JoinThreadTest0 extends Thread {

    public JoinThreadTest0(String name) {
        super(name);
    }

    public void run() {
        for (var i = 0; i < 100; i++) {
            System.out.println("Current Thread Name=" + getName() + "--> i=" + i);
        }
    }

    public static void main(String[] args) throws Exception{
        new JoinThreadTest0("New Thread").start();

        for (var i = 0; i < 100; i++) {

            if (i == 20) {
                var joinThread = new JoinThreadTest0("Join Thread");
                joinThread.start();
                joinThread.join();
            }
            System.out.println("Current Thread Name=" + Thread.currentThread().getName() + "--> i=" + i);
        }
    }
}
