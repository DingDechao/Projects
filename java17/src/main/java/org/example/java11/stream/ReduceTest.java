package org.example.java11.stream;

import java.util.ArrayList;
import java.util.List;

public class ReduceTest {

    public static void main(String[] args) {
        List<String> stringList1 = new ArrayList<>();//List.of("aaa", "bbb", "ccc");
        stringList1.add("aaa");
        stringList1.add("bbb");
        stringList1.add("ccc");
        List<String> stringList2 = new ArrayList<>();//List.of("ddd", "eee", "fff");
        stringList1.add("ddd");
        stringList1.add("eee");
        stringList1.add("fff");
        List<String> stringList3 = new ArrayList<>();//List.of("ggg", "hhh", "iii");
        stringList1.add("ggg");
        stringList1.add("hhh");
        stringList1.add("iii");
        List<List<String>> list = new ArrayList<>();
        list.add(stringList1);
        list.add(stringList2);
        list.add(stringList3);
        List<String> l = list.stream().reduce((list1, list2) -> {
            list1.addAll(list2);
            return list1;
        }).get();
        System.out.println(l);
    }
}
