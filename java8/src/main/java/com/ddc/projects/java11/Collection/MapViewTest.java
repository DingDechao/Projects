package com.ddc.projects.java11.Collection;

import com.ddc.projects.java11.entity.Person;

import java.util.HashMap;
import java.util.Map;

public class MapViewTest {
    private final static Map<String, Person> personMap;

    static {
        personMap = new HashMap<>();
        Person personOne = new Person("ddc1", 20);
        Person personTwo = new Person("ddc2", 25);
        personMap.put("ddc1", personOne);
        personMap.put("ddc2", personTwo);
    }

    private static void forEachTest() {
        personMap.forEach((k, v) -> {
            System.out.println(v);
        });
    }

    public static void main(String[] args) {
        MapViewTest.forEachTest();
    }
}
