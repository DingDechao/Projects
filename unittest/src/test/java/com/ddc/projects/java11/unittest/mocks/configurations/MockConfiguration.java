package com.ddc.projects.java11.unittest.mocks.configurations;

public class MockConfiguration implements Configuration {

    public void setSQL(String sqlId) {

    }

    @Override
    public String getSQL(String sqlId) {
        return null;
    }
}
