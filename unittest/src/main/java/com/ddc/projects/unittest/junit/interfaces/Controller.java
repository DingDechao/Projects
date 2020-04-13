package com.ddc.projects.unittest.junit.interfaces;

public interface Controller {
    Response processRequest(Request request);

    void addHandler(Request request, RequestHandler requestHandler);
}
