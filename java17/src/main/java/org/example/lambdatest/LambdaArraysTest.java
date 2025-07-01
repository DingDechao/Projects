package org.example.lambdatest;

import java.util.Arrays;

public class LambdaArraysTest {
    public static void main(String[] args) {
        var array1 = new String[]{"a", "aaa", "aa"};
        Arrays.parallelSort(array1, (a1, a2) -> (a1.length() - a2.length()));
        System.out.println(Arrays.toString(array1));

        var array2 = new int[]{ 1, 5, 3};
        Arrays.parallelPrefix(array2, (left, right) -> left * right);
        System.out.println(Arrays.toString(array2));

        var array3 = new long[5];
        Arrays.parallelSetAll(array3, index -> index * 5);
        System.out.println(Arrays.toString(array3));
    }
}
