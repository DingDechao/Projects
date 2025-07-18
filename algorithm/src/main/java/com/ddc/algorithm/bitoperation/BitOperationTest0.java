package com.ddc.algorithm.bitoperation;

import java.util.HashMap;
import java.util.Map;

public class BitOperationTest0 {
    public static void main(String[] args) {

        negationOperation(-5);
        negationOperation(5);

        swapNumberWithoutVar(3, 12);

        printOddNumberWithinArray(new int[]{1, 1, 3});


        int[] array = new int[]{4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2};
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : array) {
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }
        System.out.println(map);
        print2OddNumberWithinArray(array);
    }

    public static void swapNumberWithoutVar(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("a=" + a + ", b = " + b);
    }

    //一个数组中只有一个数字出现奇数次数
    public static void printOddNumberWithinArray(int[] array) {
        int number = 0;
        for (var i = 0; i < array.length; i++) {
            number ^= array[i];
        }
        System.out.println(number);
    }

    //一个数组中只有两个数字出现奇数次数
    public static void print2OddNumberWithinArray(int[] array) {
        int number = 0;
        for (var i = 0; i < array.length; i++) {
            number ^= array[i];
        }
        // 此时,number等于这两个奇数异或的结果
        //接下来, 找出 number 32位中最后一个1的位置
        // number  00110010110111000
        // ~number 01001101001000111 + 1 =
        // +1      01001101001001000
        // lastOne=00000000000001000
        int lastOne = number & (-number);
        int oneOfOdd = 0;
        for (var i = 0; i < array.length; i++) {
            if ((array[i] & lastOne) == 1) {
                oneOfOdd ^= array[i];
            }
        }
        System.out.println("One is " + oneOfOdd + ", another is " + (number ^ oneOfOdd));
    }

    public static void negationOperation(int number) {
        System.out.println(number + "取反+1得到正数/负数：" + (~number + 1));
    }


}
