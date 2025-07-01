package org.example.thread;

public class DaemonThreadTest0 extends Thread {

    private int i;

    public void run() {
        for (; i < 10_000; i++) {
            System.out.println((getName() + "-->" + i));
        }
    }

    public static void main(String[] args) {
        DaemonThreadTest0 daemonThreadTest0 = new DaemonThreadTest0();
        daemonThreadTest0.setDaemon(true);

        daemonThreadTest0.start();

        System.out.println("daemonThreadTest0.isDaemon()=" + daemonThreadTest0.isDaemon());

        for (var i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "--> i=" + i);
        }
    }

}
