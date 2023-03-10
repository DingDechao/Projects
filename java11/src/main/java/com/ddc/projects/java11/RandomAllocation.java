package com.ddc.projects.java11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomAllocation {
    static String[] allMemberName = {"ddc1", "ddc2", "ddc3", "ddc4", "ddc5", "ddc6"};

    static Map<Integer, List<String>> mapGroup = new HashMap<>();

    static int memberCountForEachGroup = 1;
    static int groupNumber = 6;

    public static void main(String[] args) {
        List<String> group1 = new ArrayList<>(memberCountForEachGroup);
        mapGroup.put(1, group1);


        List<String> group2 = new ArrayList<>(memberCountForEachGroup);
        mapGroup.put(2, group2);

        List<String> group3 = new ArrayList<>(memberCountForEachGroup);
        mapGroup.put(3, group3);

        List<String> group4 = new ArrayList<>(memberCountForEachGroup);
        mapGroup.put(4, group4);

        List<String> group5 = new ArrayList<>(memberCountForEachGroup);
        mapGroup.put(5, group5);

        List<String> group6 = new ArrayList<>(memberCountForEachGroup);
        mapGroup.put(6, group6);

        for (int i = 0; i < allMemberName.length; i++) {
            boolean ok = true;
            do {
                int randomNumber = getRandomNumber() + 1;
                if(mapGroup.get(randomNumber).size() < memberCountForEachGroup) {
                    mapGroup.get(randomNumber).add(allMemberName[i]);
                    ok = false;
                }
            } while (ok);
        }

        mapGroup.values().forEach(item -> System.out.println(item));
    }
    static int getRandomNumber() {
        return (int)(Math.random() * 100) % groupNumber;
    }

}
