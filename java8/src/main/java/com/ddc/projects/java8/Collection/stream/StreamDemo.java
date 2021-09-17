package com.ddc.projects.java8.Collection.stream;

import java.util.Arrays;
import java.util.List;

public class StreamDemo {

    static List<String> stringList = Arrays.asList("AAA", "BBB", "CCC", "DDD");

    public static void main(String[] args) {
        System.out.println(stringList.stream().findAny());
        System.out.println(stringList.stream().parallel().findAny());
    }
}
