package com.ddc.projects.unittest.mocks;

import com.ddc.projects.unittest.mocks.configurations.MockConfiguration;
import org.junit.Test;

import static org.junit.Assert.assertNull;
public class TestConfigurationAccountManagerImpl {

    @Test
    public void testFindAccountByUser() {
        MockLog mockLog = new MockLog();
        MockConfiguration mockConfiguration = new MockConfiguration();
        mockConfiguration.setSQL("sqlId");
        ConfigurationAccountManagerImpl configurationAccountManager = new ConfigurationAccountManagerImpl();

        Account account = configurationAccountManager.findAccountByAccountId("1234");

        assertNull(account);
    }
}
