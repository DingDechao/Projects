package com.ddc.projects.unittest.junit.impl;

import com.ddc.projects.unittest.junit.interfaces.Request;
import com.ddc.projects.unittest.junit.interfaces.RequestHandler;
import com.ddc.projects.unittest.junit.interfaces.Response;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestDefaultController {

    private DefaultController defaultController;
    private Request request;
    private RequestHandler requestHandler;

    @Before
    public void setup() throws Exception {
        defaultController = new DefaultController();
        request = new TestRequest();
        requestHandler = new TestHandler();
        defaultController.addHandler(request, requestHandler);
    }

    @Test
    public void testMethod() {
        //throw new RuntimeException("implement me");
    }

    @Test
    public void testAddHandler() {
        RequestHandler testHandler = defaultController.getHandler(request);
        assertSame("Method getHandler() should return the same handler which just added", testHandler, requestHandler);
    }

    @Test
    public void testProcessRequest() {
        Response response = defaultController.processRequest(request);
        assertNotNull("Cannot return a null response", response);
        assertEquals("", new TestResponse(), response);
    }

    @Test
    public void testProcessRequestAnswersErrorResponse() {
        TestRequest testRequest = new TestRequest("testError");
        TestExceptionHandler testExceptionHandler = new TestExceptionHandler();
        defaultController.addHandler(testRequest, testExceptionHandler);
        Response response = defaultController.processRequest(testRequest);

        assertNotNull("Cannot return a null response", response);
        assertEquals(ErrorResponse.class, response.getClass());
    }

    @Test(expected = RuntimeException.class)
    public void testGetHandlerNotDefined() {
        TestRequest testRequest = new TestRequest("testNotDefined");
        defaultController.getHandler(testRequest);
    }

    @Test(expected = RuntimeException.class)
    public void testAddRequestDuplicateName() {
        TestRequest testRequest = new TestRequest();
        TestHandler testHandler = new TestHandler();
        defaultController.addHandler(testRequest, testHandler);
    }

    @Test(timeout = 130)
    @Ignore(value = "Skip this test")
    public void testProcessMultipleRequestTimeout() {
        Request request;
        Response response = new TestResponse();
        RequestHandler handler = new TestHandler();
        for (int i =0; i < 10_0000; i++) {
            request = new TestRequest(String.valueOf(i));
            defaultController.addHandler(request, handler);
            response = defaultController.processRequest(request);
            assertNotNull("Cannot return a null response", response);
            assertEquals(ErrorResponse.class, response.getClass());
        }
    }

    private class TestRequest implements Request {

        private static final String DEFAULT_NAME = "Test";

        private String name;

        public TestRequest(String name) {
            this.name = name;
        }

        public TestRequest() {
            this(DEFAULT_NAME);
        }

        @Override
        public String getName() {
            return this.name;
        }
    }

    private class TestHandler implements RequestHandler {

        @Override
        public Response process(Request request) throws Exception {
            return new TestResponse();
        }
    }

    private class TestExceptionHandler implements RequestHandler {

        @Override
        public Response process(Request request) throws Exception {
            throw new Exception("Error processing request");
        }
    }

    private class TestResponse implements Response {
        private static final String DEFAULT_NAME = "Test";

        private String name;

        public String getName() {
            return this.name;
        }

        public TestResponse(String name) {
            this.name = name;
        }

        public TestResponse() {
            this(DEFAULT_NAME);
        }

        public boolean equals(Object object) {
            boolean result = false;
            if (object instanceof TestResponse) {
                result = ((TestResponse)object).getName().equals(getName());
            }
            return result;
        }

        public int hashCode() {
            return this.name.hashCode();
        }
    }
}
