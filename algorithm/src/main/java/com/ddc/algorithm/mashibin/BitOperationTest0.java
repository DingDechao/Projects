package com.ddc.algorithm.mashibin;

public class BitOperationTest0 {
    public static void main(String[] args) {

        negationOperation(-5);
        negationOperation(5);

    }

    public static void negationOperation(int number) {
        System.out.println(number + "取反+1得到正数/负数：" + (~number + 1));
    }


}
