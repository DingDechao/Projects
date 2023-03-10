package com.ddc.projects.java11.unittest.stub;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebClient {

     public String getContent(URL url) {
         StringBuffer stringBuffer = new StringBuffer();
         try {
             HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
             httpURLConnection.setDoInput(true);
             InputStream inputStream = httpURLConnection.getInputStream();
             byte[] bytes = new byte[2048];
             int index;
             while ( -1 != (index = inputStream.read(bytes))) {
                 stringBuffer.append(new String(bytes, 0, index));
             }
         } catch (IOException e) {
             return null;
         }
         return stringBuffer.toString();
     }
}
