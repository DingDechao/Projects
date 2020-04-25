package com.ddc.projects.java8.basic;

import com.ddc.projects.java8.entity.Pair;

public class ArrayTest {

    public void test(){
        Pair<String> pair = Pair.makePair(String::new);
        Pair<String>[] table = (Pair<String>[]) new Pair<?>[10];
    }
}
