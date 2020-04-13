package com.ddc.projects.unittest.easymock;

import com.ddc.projects.unittest.mocks.Account;
import com.ddc.projects.unittest.mocks.AccountManager;
import com.ddc.projects.unittest.mocks.AccountService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

public class TestAccountServiceWithEasyMock {

    private AccountManager mockAccountManager;

    @Before
    public void setUp() {
        mockAccountManager = createMock("mockAccountManager", AccountManager.class);
    }

    @Test
    public void testTransferOk() {
        Account fromAccount = new Account("1", 200);
        Account toAccount = new Account("2", 200);

        mockAccountManager.updateAccount(fromAccount);
        mockAccountManager.updateAccount(toAccount);

        expect(mockAccountManager.findAccountByAccountId("1")).andReturn(fromAccount);
        expect(mockAccountManager.findAccountByAccountId("2")).andReturn(toAccount);

        replay(mockAccountManager);

        AccountService accountService = new AccountService();
        accountService.setAccountManager(mockAccountManager);
        accountService.transfer("1", "2", 50);

        assertEquals(150, fromAccount.getBalance());
        assertEquals(250, toAccount.getBalance());
    }

    @After
    public void after() {
        verify(mockAccountManager);
    }

}
