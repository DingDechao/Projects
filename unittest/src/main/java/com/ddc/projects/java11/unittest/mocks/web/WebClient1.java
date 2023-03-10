package com.ddc.projects.java11.unittest.mocks.web;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebClient1 {

    public String getContent(URL url) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            HttpURLConnection httpURLConnection = createHttpURLConnection(url);
            InputStream inputStream = httpURLConnection.getInputStream();

            int index;
            while (-1 != (index = inputStream.read())) {
                stringBuffer.append(new String(Character.toChars(index)));
            }
        } catch (IOException e) {
            return null;
        }
        return stringBuffer.toString();
    }

    protected HttpURLConnection createHttpURLConnection(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }
}
