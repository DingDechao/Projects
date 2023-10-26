package com.ddc.projects.java11.unittest.junit.impl;

import com.ddc.projects.java11.unittest.junit.interfaces.Controller;
import com.ddc.projects.java11.unittest.junit.interfaces.Request;
import com.ddc.projects.java11.unittest.junit.interfaces.RequestHandler;
import com.ddc.projects.java11.unittest.junit.interfaces.Response;

import java.util.HashMap;
import java.util.Map;

public class DefaultController implements Controller {

    private Map requestHandlersMap = new HashMap<>();

    protected RequestHandler getHandler(Request request) {
        if (!this.requestHandlersMap.containsKey(request.getName())) {
            String message = "Cannot find handler for request name [" + request.getName() + "]";
            throw new RuntimeException(message);
        }
        return (RequestHandler) this.requestHandlersMap.get(request.getName());
    }

    @Override
    public Response processRequest(Request request) {
       Response response;
       try {
           response = getHandler(request).process(request);
       } catch (Exception e) {
           response = new ErrorResponse(request, e);
       }
       return response;
    }

    @Override
    public void addHandler(Request request, RequestHandler requestHandler) {
        if (this.requestHandlersMap.containsKey(request.getName())) {
            throw new RuntimeException("A request handler has already been registered for request name [" + request.getName() + "]");
        } else {
            this.requestHandlersMap.put(request.getName(), requestHandler);
        }
    }
}
