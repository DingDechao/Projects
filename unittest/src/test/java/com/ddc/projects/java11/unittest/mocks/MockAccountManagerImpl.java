package com.ddc.projects.java11.unittest.mocks;

import java.util.HashMap;
import java.util.Map;

public class MockAccountManagerImpl implements AccountManager {

    private Map<String, Account> accountMap = new HashMap<>();

    public void addAccount(String accountId, Account account) {
        accountMap.put(accountId, account);
    }

    @Override
    public Account findAccountByAccountId(String accountId) {
        return accountMap.get(accountId);
    }

    @Override
    public void updateAccount(Account account) {
        System.out.println(String.format("update account %s successfully", account.getAccountId()));
    }
}
