package com.ddc.projects.unittest.junit.impl;

import com.ddc.projects.unittest.junit.interfaces.Request;
import com.ddc.projects.unittest.junit.interfaces.Response;

public class ErrorResponse implements Response {

    private Request originalRequest;
    private Exception originalException;

    public ErrorResponse(Request request, Exception exception) {
        this.originalRequest = request;
        this.originalException = exception;
    }

    public Request getOriginalRequest() {
        return this.originalRequest;
    }

    public Exception getOriginalException() {
        return  this.originalException;
    }
}
