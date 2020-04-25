package com.ddc.projects.java8.thread;

import com.ddc.projects.java8.entity.Bank;
import org.junit.Test;

public class BankTest {
    public static final int TOTALACCOUNTS = 100;
    public static final double BALANCE = 1000;
    public static final double MAX_AMOUNT = 1000;
    public static final int DELAY = 10;

    @Test
    public void test() {
        Bank bank = new Bank(TOTALACCOUNTS, BALANCE);
        for (int i =0; i < TOTALACCOUNTS; i++) {
            int from = i;
            Runnable r = () -> {
                try {
                    while (true) {
                        int to = (int)(bank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(from, to, amount);
                        Thread.sleep((int)(DELAY * Math.random()));
                    }
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            Thread thread = new Thread(r);
            thread.start();
        }
    }

}
