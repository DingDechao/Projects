package org.example.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("a*b");
        Matcher matcher = pattern.matcher("aaaaaaaaaaaaaaaaaaaaaaaaaaaab");
        boolean b = matcher.matches();
        System.out.println("b="+b);

        boolean c= Pattern.matches("a*b", "aaaaaaaaaaaaaaaaaaaaaaaaaaaab");
        System.out.println("c="+c);
    }
}
