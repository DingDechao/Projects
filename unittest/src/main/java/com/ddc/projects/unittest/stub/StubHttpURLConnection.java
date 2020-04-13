package com.ddc.projects.unittest.stub;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class StubHttpURLConnection extends HttpURLConnection {

    private boolean isInput = true;

    protected StubHttpURLConnection(URL url) {
        super(url);
    }

    public InputStream getInputStream() throws IOException {
        if(!isInput) {
            throw new ProtocolException("Cannot read from URLConnection if isInput=false (call setDoInput(true))" );
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("Working".getBytes());
        return byteArrayInputStream;
    }

    @Override
    public void disconnect() {

    }

    @Override
    public boolean usingProxy() {
        return false;
    }

    @Override
    public void connect() throws IOException {

    }
}
