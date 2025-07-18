package com.ddc.algorithm.mashibin;

public class BitOperationTest0 {
    public static void main(String[] args) {

        negationOperation(-5);
        negationOperation(5);

        swapNumberWithoutVar(3, 12);

        printOddNumberWithinArray(new int[]{1, 1, 3});
    }

    public static void swapNumberWithoutVar(int a , int b) {
        a = a ^b;
        b = a ^ b;
        a = a ^b;

        System.out.println("a=" + a + ", b = "+b);
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
        
    }
    // 找出自己二进制的第一位1


    public static void negationOperation(int number) {
        System.out.println(number + "取反+1得到正数/负数：" + (~number + 1));
    }


}
