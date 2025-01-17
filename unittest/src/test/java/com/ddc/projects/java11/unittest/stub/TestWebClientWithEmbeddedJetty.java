package com.ddc.projects.java11.unittest.stub;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mortbay.jetty.HttpHeaders;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.AbstractHandler;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.util.ByteArrayISO8859Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

public class TestWebClientWithEmbeddedJetty {

    private WebClient webClient = new WebClient();

    @BeforeClass
    public static void setUp() throws Exception{
        Server server = new Server(8080);

        TestWebClientWithEmbeddedJetty testWebClientWithEmbeddedJetty = new TestWebClientWithEmbeddedJetty();

        Context contextOk = new Context(server, "/testGetContentOk");
        contextOk.setHandler(testWebClientWithEmbeddedJetty.new TestGetContentOkHandler());

        Context contextServerError = new Context(server, "/testGetContentServerError");
        contextServerError.setHandler(testWebClientWithEmbeddedJetty.new TestGetContentServerErrorHandler());

        Context contextNotFound = new Context(server, "/testGetContentNotFound");
        contextNotFound.setHandler(testWebClientWithEmbeddedJetty.new TestGetContentNotFoundHandler());

        server.setStopAtShutdown(true);
        server.start();
    }

    @Test
    public void testGetContentOk() throws Exception {
        String result = webClient.getContent(new URL("http://localhost:8080/testGetContentOk"));
        assertEquals("Working", result);
    }

    @Test
    public void testGetContentServerError() throws Exception {
        String result = webClient.getContent(new URL("http://localhost:8080/testGetContentServerError"));
        assertNull(result);
    }

    @Test
    public void testGetContentNotFound() throws Exception {
        String result = webClient.getContent(new URL("http://localhost:8080/testGetContentNotFound"));
        assertNull(result);
    }

    private class TestGetContentOkHandler extends AbstractHandler {

        @Override
        public void handle(String s, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, int i) throws IOException, ServletException {
            OutputStream outputStream = httpServletResponse.getOutputStream();
            ByteArrayISO8859Writer byteArrayISO8859Writer = new ByteArrayISO8859Writer();
            byteArrayISO8859Writer.write("Working");
            byteArrayISO8859Writer.flush();
            httpServletResponse.setIntHeader(HttpHeaders.CONTENT_LENGTH, byteArrayISO8859Writer.size());
            byteArrayISO8859Writer.writeTo(outputStream);
            outputStream.flush();
        }
    }

    private class TestGetContentServerErrorHandler extends AbstractHandler {

        @Override
        public void handle(String s, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, int i) throws IOException, ServletException {
           httpServletResponse.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
        }
    }

    private class TestGetContentNotFoundHandler extends AbstractHandler {

        @Override
        public void handle(String s, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, int i) throws IOException, ServletException {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
