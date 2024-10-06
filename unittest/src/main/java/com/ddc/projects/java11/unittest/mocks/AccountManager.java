package com.ddc.projects.java11.unittest.mocks;

public interface AccountManager {

    Account findAccountByAccountId(String accountId);

    void updateAccount(Account account);
}
