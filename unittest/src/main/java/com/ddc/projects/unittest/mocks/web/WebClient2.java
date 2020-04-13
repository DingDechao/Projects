package com.ddc.projects.unittest.mocks.web;

import java.io.IOException;
import java.io.InputStream;

public class WebClient2 {

    public String getContent(ConnectionFactory connectionFactory) throws IOException {
        String result;

        StringBuffer stringBuffer = new StringBuffer();
        InputStream inputStream = null;
        try {
            inputStream = connectionFactory.getData();
            int index;
            while ( -1 != (index = inputStream.read())) {
                stringBuffer.append(new String(Character.toChars(index)));
            }
            result = stringBuffer.toString();
        } catch (Exception e) {
            result = null;
        }

        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                result = null;
            }
        }
        return result;
    }
}
