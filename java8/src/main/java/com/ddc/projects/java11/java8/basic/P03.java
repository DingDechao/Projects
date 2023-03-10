package com.ddc.projects.java11.java8.basic;

public class P03 {
    public static void main(String[] args) {
        String str = "java 你好";
        char[] tochar = str.toCharArray();
        int sum = 0;
        for (int i = 0; i < tochar.length; i++) {
            sum += tochar[i];
        }
        System.out.println(sum);
    }
}
