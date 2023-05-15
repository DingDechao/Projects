package com.ddc.projects.java11.unittest.mocks.web;


import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class TestWebClient1 {

    @Test
    public void testGetContentOk() throws Exception{
        MockHttpURLConnection mockHttpURLConnection = new MockHttpURLConnection();
        mockHttpURLConnection.setInputStream(new ByteArrayInputStream("Working".getBytes()));

        TestableWebClient1 testableWebClient1 = new TestableWebClient1();
        testableWebClient1.setHttpURLConnection(mockHttpURLConnection);

        String result = testableWebClient1.getContent(new URL("http://localhost"));

        assertEquals("Working", result);
    }

    private class TestableWebClient1 extends WebClient1 {
        private HttpURLConnection httpURLConnection;

        public void setHttpURLConnection(HttpURLConnection httpURLConnection) {
            this.httpURLConnection = httpURLConnection;
        }

        public HttpURLConnection createHttpURLConnection(URL url) throws IOException {
            return this.httpURLConnection;
        }
    }
}
