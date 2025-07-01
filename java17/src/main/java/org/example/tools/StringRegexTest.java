package org.example.tools;

public class StringRegexTest {
    public static void main(String[] args) {
        String s = "aaa, bbb, ccc, ddd";
        System.out.println(s.replaceFirst("\\w*", "zzz"));
        System.out.println(s);
    }
}
