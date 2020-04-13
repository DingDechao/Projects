package com.ddc.projects.unittest.mocks.web;

import java.io.InputStream;

public class MockConnectionFactoryImpl implements ConnectionFactory {

    private InputStream inputStream;

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public InputStream getData() throws Exception {
        return inputStream;
    }
}
