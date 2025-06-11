package org.example.collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("Test","Test1");
        System.out.println(map.size());
        map.put("Test","Test2");
        System.out.println(map.size());
        System.out.println(map);
    }

}
