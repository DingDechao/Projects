package org.example.java11.Collection;

import org.example.java11.entity.Person22;

import java.util.HashMap;
import java.util.Map;

public class MapViewTest {
    private final static Map<String, Person22> personMap;

    static {
        personMap = new HashMap<>();
        Person22 personOne = new Person22("ddc1", 20);
        Person22 personTwo = new Person22("ddc2", 25);
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
