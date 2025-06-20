package org.example.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLEncoderDecoderTest0 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "你好，JAVA";
        String urlEncoder = URLEncoder.encode(s, "GBK");
        System.out.println(urlEncoder);//%C4%E3%BA%C3%A3%ACJAVA

        String urlDecoder = URLDecoder.decode(urlEncoder, "GBK");
        System.out.println(urlDecoder);
    }
}
