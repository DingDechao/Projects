package com.ddc.projects.java11;

public class RandomStringTest {
    public static void main(String[] args) {
        var result = "";
        for (var i = 0; i <6; i++) {
            var intValue = (int) (Math.random() * 26 + 97);
            result += (char) intValue;
        }
        System.out.println(result);
    }
}
