package com.ddc.projects.java11.Collection;


import java.util.HashMap;
import java.util.Map;

public class MapStringString {

    public void addItemIntoMap() {
        Map<String, String> map = new HashMap<>();
        map.put("test1", "test1");
        System.out.println(map);
        addItemIntoMapByOtherMethod(map);
        System.out.println(map);
    }

    private void addItemIntoMapByOtherMethod(Map<String, String> map) {
        map.put("test2", "test2");
    }

    public static void main(String[] args) {
        MapStringString mapStringString = new MapStringString();
        mapStringString.addItemIntoMap();
    }
}
