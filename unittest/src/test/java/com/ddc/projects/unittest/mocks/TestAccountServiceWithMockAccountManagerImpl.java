package com.ddc.projects.unittest.mocks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestAccountServiceWithMockAccountManagerImpl {

    @Test
    public void testTransferOk() {
        MockAccountManagerImpl mockAccountManagerImpl = new MockAccountManagerImpl();
        Account fromAccount = new Account("1", 200);
        Account toAccount = new Account("2", 200);
        mockAccountManagerImpl.addAccount("1", fromAccount);
        mockAccountManagerImpl.addAccount("2", toAccount);

        AccountService accountService = new AccountService();
        accountService.setAccountManager(mockAccountManagerImpl);
        accountService.transfer("1", "2", 50);

        assertEquals(150, fromAccount.getBalance());
        assertEquals(250, toAccount.getBalance());

    }
}
