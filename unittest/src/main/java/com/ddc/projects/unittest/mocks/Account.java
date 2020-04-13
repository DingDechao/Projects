package com.ddc.projects.unittest.mocks;

public class Account {

    private String accountId;
    private long balance;

    public Account(String accountId, long balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public void debit(long amount) {
        this.balance -= amount;
    }

    public void credit(long amount) {
        this.balance += amount;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public long getBalance() {
        return this.balance;
    }

}
