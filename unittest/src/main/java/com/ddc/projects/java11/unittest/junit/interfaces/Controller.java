package com.ddc.projects.java11.unittest.junit.interfaces;

public interface Controller {
    Response processRequest(Request request);

    void addHandler(Request request, RequestHandler requestHandler);
}
