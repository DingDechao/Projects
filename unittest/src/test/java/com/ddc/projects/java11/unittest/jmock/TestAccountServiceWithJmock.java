package com.ddc.projects.java11.unittest.jmock;

import com.ddc.projects.java11.unittest.mocks.Account;
import com.ddc.projects.java11.unittest.mocks.AccountManager;
import com.ddc.projects.java11.unittest.mocks.AccountService;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JMock.class)
public class TestAccountServiceWithJmock {

    private Mockery mockery = new JUnit4Mockery();

    private AccountManager mockAccountManager;

    @Before
    public void setUp() {
        mockAccountManager = mockery.mock(AccountManager.class);
    }

    @Test
    public void testTransferOk() {
        final Account fromAccount = new Account("1", 200);
        final Account toAccount = new Account("2", 200);

        mockery.checking(new Expectations(){{
            oneOf(mockAccountManager).findAccountByAccountId("1");
            will(returnValue(fromAccount));

            oneOf(mockAccountManager).findAccountByAccountId("2");
            will(returnValue(toAccount));

            oneOf(mockAccountManager).updateAccount(fromAccount);
            oneOf(mockAccountManager).updateAccount(toAccount);
        }});

        AccountService accountService = new AccountService();
        accountService.setAccountManager(mockAccountManager);
        accountService.transfer("1", "2", 50);

        assertEquals(150, fromAccount.getBalance());
        assertEquals(250, toAccount.getBalance());
    }
}
