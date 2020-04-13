package com.ddc.projects.unittest.mocks;

public interface AccountManager {

    Account findAccountByAccountId(String accountId);

    void updateAccount(Account account);
}
