package com.ddc.projects.unittest.stub;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.xml.ws.RequestWrapper;
import java.io.IOException;
import java.net.*;

import static org.junit.Assert.assertEquals;

public class TestWebClientWithStubHttpConnection {

    @BeforeClass
    public static void setUp() {
        TestWebClientWithStubHttpConnection testWebClientWithStubHttpConnection = new TestWebClientWithStubHttpConnection();

        URL.setURLStreamHandlerFactory(testWebClientWithStubHttpConnection.new StubStreamHandlerFactory());
    }

    @Test
    public void testGetContentOk() throws Exception {
        WebClient webClient = new WebClient();
        String result = webClient.getContent(new URL("http://localhost:8080/"));
        assertEquals("Working", result);
    }

    private class StubStreamHandlerFactory implements URLStreamHandlerFactory {

        @Override
        public URLStreamHandler createURLStreamHandler(String protocol) {
            return new StubHttpURLStreamHandler();
        }
    }

    private class StubHttpURLStreamHandler extends URLStreamHandler {

        @Override
        protected URLConnection openConnection(URL u) throws IOException {
            return new StubHttpURLConnection(u);
        }
    }
}
