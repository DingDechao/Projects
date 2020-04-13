package com.ddc.projects.java8.array;

import com.ddc.projects.java8.entity.Pair;

public class ArrayTest {

    public void test(){
        Pair<String> p = Pair.makePair(String::new);

        Pair<String>[] table = (Pair<String>[]) new Pair<?>[10];
        
    }
}
