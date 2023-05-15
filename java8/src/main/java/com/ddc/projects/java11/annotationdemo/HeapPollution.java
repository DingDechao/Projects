package com.ddc.projects.java11.annotationdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HeapPollution {

    public void heapPollutionDemo1() {
        List list = new ArrayList<Integer>();
        //Unchecked call to 'add(E)' as a member of raw type 'java.util.List'
        list.add(20);

        List<String> stringList = list;

/*      Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
        at com.ddc.projects.java8.annotationdemo.HeapPollution.heapPollutionDemo(HeapPollution.java:15)
        at com.ddc.projects.java8.annotationdemo.HeapPollution.main(HeapPollution.java:20)*/
        System.out.println(stringList.get(0));
    }

    @SafeVarargs
    //Possible heap pollution from parameterized vararg type
    public final void heapPollutionDemo2(List<String>... listStringArray) {
        List[] listArray = listStringArray;
        List<Integer> integerList = new ArrayList<>();
        integerList.add(new Random().nextInt(100));

        listArray[0] = integerList;
/*
        Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
        at com.ddc.projects.java8.annotationdemo.HeapPollution.heapPollutionDemo2(HeapPollution.java:29)
        at com.ddc.projects.java8.annotationdemo.HeapPollution.main(HeapPollution.java:34)
*/
        String str = listStringArray[0].get(0);
    }

    public static void main(String[] args) {
        //new HeapPollution().heapPollutionDemo1();
        //Unchecked generics array creation for varargs parameter
        new HeapPollution().heapPollutionDemo2(Arrays.asList("Hello"), Arrays.asList("World"));
    }
}
