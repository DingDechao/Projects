package com.ddc.projects.java11.unittest.jmock;

import com.ddc.projects.java11.unittest.mocks.Account;
import com.ddc.projects.java11.unittest.mocks.ConfigurationAccountManagerImpl;
import com.ddc.projects.java11.unittest.mocks.configurations.Configuration;
import org.apache.commons.logging.Log;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNull;

@RunWith(JMock.class)
public class TestConfigurationAccountManagerImplWithJmock {

    private Mockery mockery = new JUnit4Mockery();

    private Configuration mockConfiguration;
    private Log mockLogger;

    @Before
    public void setUp() {
        mockConfiguration = mockery.mock(Configuration.class);
        mockLogger = mockery.mock(Log.class);
    }

    @Test
    public void testFindAccountByUser() {
        mockery.checking( new Expectations(){{
            oneOf(mockLogger).debug("Getting account for user 1234");

            oneOf(mockConfiguration).getSQL("sqlId");
            will(returnValue("select * from dual"));
        }});

        ConfigurationAccountManagerImpl configurationAccountManager = new ConfigurationAccountManagerImpl(mockLogger, mockConfiguration);

        Account account = configurationAccountManager.findAccountByAccountId("1234");

        assertNull(account);
    }
}
