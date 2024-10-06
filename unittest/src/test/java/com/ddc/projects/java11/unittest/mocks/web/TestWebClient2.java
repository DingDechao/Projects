package com.ddc.projects.java11.unittest.mocks.web;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TestWebClient2 {

    @Test
    public void testGetContentOk() throws IOException {
        MockConnectionFactoryImpl mockConnectionFactoryImpl = new MockConnectionFactoryImpl();
        MockInputStream mockInputStream = new MockInputStream();
        mockInputStream.setBuffer("Working");

        mockConnectionFactoryImpl.setInputStream(mockInputStream);

        WebClient2 webClient2 = new WebClient2();
        String result = webClient2.getContent(mockConnectionFactoryImpl);

        assertEquals("Working", result);
        mockInputStream.verify();
    }

    @Test
    public void testGetContentOkWithoutMockInputStream() throws IOException {
        MockConnectionFactoryImpl mockConnectionFactoryImpl = new MockConnectionFactoryImpl();
        mockConnectionFactoryImpl.setInputStream(new ByteArrayInputStream("Working".getBytes()));

        WebClient2 webClient2 = new WebClient2();
        String result = webClient2.getContent(mockConnectionFactoryImpl);

        assertEquals("Working", result);
    }
}
