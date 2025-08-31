package com.ddc.algorithm;

import java.math.BigDecimal;

public class Test {

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.hammingWeight(11);

        int number = 30_0000;
//        BigDecimal bigDecimal = new BigDecimal((3d )/100/12, 2);
        double rate = 3d / 100/ 12;
        System.out.println(String.valueOf(number / 36 /2));
//        for (int i = 1 ; i <= 36; i++) {
//            double principal = 0;
//            double interest = number * rate;
//        }
    }
}

class Solution {
    public int hammingWeight(int n) {
       int[] arr = new int[32];
        for (var i=31; i >= 0; i--) {
           arr[i] = (n >> i) & 1;
        }
        int count = 0;
        for (int s : arr) {
            if (s == 1) {
                count++;
            }
        }
        return count;
    }
}
