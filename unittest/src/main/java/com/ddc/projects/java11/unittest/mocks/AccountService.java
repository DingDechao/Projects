package com.ddc.projects.java11.unittest.mocks;

public class AccountService {

    private AccountManager accountManager;

    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public void transfer(String fromAccountId, String toAccountId, long amount) {
        Account fromAccount = accountManager.findAccountByAccountId(fromAccountId);
        Account toAccount = accountManager.findAccountByAccountId(toAccountId);

        fromAccount.debit(amount);
        toAccount.credit(amount);

        accountManager.updateAccount(fromAccount);
        accountManager.updateAccount(toAccount);
    }
}
