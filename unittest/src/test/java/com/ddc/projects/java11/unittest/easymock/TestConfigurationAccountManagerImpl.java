package com.ddc.projects.java11.unittest.easymock;

import com.ddc.projects.java11.unittest.mocks.Account;
import com.ddc.projects.java11.unittest.mocks.configurations.Configuration;
import com.ddc.projects.java11.unittest.mocks.ConfigurationAccountManagerImpl;
import org.apache.commons.logging.Log;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertNull;

public class TestConfigurationAccountManagerImpl {

    private Log logger;
    private Configuration configuration;

    @Before
    public void setUp() {
        logger = createMock("logger", Log.class);
        configuration = createMock("configuration", Configuration.class);
    }

    @Test
    public void testFindAccountByUser() {
        expect(configuration.getSQL("sqlId")).andReturn("select * from dual");
        replay();

        ConfigurationAccountManagerImpl configurationAccountManager = new ConfigurationAccountManagerImpl();

        Account account = configurationAccountManager.findAccountByAccountId("1234");
        assertNull(account);
    }
}
