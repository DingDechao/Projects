package com.ddc.projects.java11.unittest.mocks;

import com.ddc.projects.java11.unittest.mocks.configurations.Configuration;
import com.ddc.projects.java11.unittest.mocks.configurations.ConfigurationImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ConfigurationAccountManagerImpl implements AccountManager {

    private Log logger;

    private Configuration configuration;

    public ConfigurationAccountManagerImpl() {
        this(LogFactory.getLog(ConfigurationAccountManagerImpl.class), new ConfigurationImpl("config"));
    }

    public ConfigurationAccountManagerImpl(Log logger, Configuration configuration) {
        this.logger = logger;
        this.configuration = configuration;
    }

    @Override
    public Account findAccountByAccountId(String accountId) {
        logger.debug(String.format("Getting account for user %s", accountId));
        configuration.getSQL("sqlId");
        return null;
    }

    @Override
    public void updateAccount(Account account) {

    }


}
