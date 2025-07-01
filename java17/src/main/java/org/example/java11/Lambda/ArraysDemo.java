package org.example.java11.Lambda;

import java.util.Arrays;
import java.util.Objects;

public class ArraysDemo {

    public static void main(String[] args) {

        var stringArray = new String[] { "a", "aaaaa" , "aa", "aaaa", "aaa"};
        System.out.println(Arrays.toString(stringArray));
        Arrays.parallelSort(stringArray, (o1, o2) -> o2.length() - o1.length());
        System.out.println(Arrays.toString(stringArray));
        Arrays.parallelSort(stringArray, (o1, o2) -> o1.length() - o2.length());
        System.out.println(Arrays.toString(stringArray));


        var intArray = new int[] {1, 4, 2, 3, 5};
        System.out.println(Arrays.toString(intArray));
        Arrays.parallelPrefix(intArray, (left, right) -> left + right);
        System.out.println(Arrays.toString(intArray));

        Arrays.parallelSetAll(intArray, operand -> operand * intArray[operand]);
        System.out.println(Arrays.toString(intArray));
    }
}
