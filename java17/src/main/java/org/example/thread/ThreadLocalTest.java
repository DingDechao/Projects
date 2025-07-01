package org.example.thread;

class Account {

    private ThreadLocal<String> name = new ThreadLocal<>();

    public Account(String str) {
        this.name.set(str);
        System.out.println("Current Thread = " + Thread.currentThread().getName() + "----> name = " + this.name.get());
    }

    public String getName() {
        return name.get();
    }

    public void setName(String str) {
        this.name.set(str);
    }
}

class MyTest extends Thread {
    private Account account;

    public MyTest(Account account, String name) {
        super(name);
        this.account = account;
    }

    public void run() {
        for (var i = 0; i < 10; i++) {
            if (i == 5) {
                account.setName(getName());
            }
            System.out.println("Current Thread = " + Thread.currentThread().getName() + "----> name = " + account.getName() + " ---> i = " + i);
        }
    }
}

public class ThreadLocalTest {
    public static void main(String[] args) {
        var at = new Account("Default Value");
        new MyTest(at, "Thread A").start();
        new MyTest(at, "Thread B").start();
    }
}
