package org.example.java11.entity;

import java.util.Arrays;

public class Bank {
    private final double[] accounts;

    public Bank(int numberOfAccounts, double balance) {
        accounts = new double[numberOfAccounts];
        Arrays.fill(accounts, balance);
    }

    public void transfer(int from, int to, double amount) {
        if (accounts[from] < amount) {
            return;
        }
        System.out.print(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf(" %10.2f from %d to %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf(" Total balance: %10.2f%n", getTotalBalance());
    }

    public double getTotalBalance() {
        double sum = 0;
        for (double balance : accounts) {
            sum += balance;
        }
        return sum;
    }

    public int size() {
        return accounts.length;
    }
}
