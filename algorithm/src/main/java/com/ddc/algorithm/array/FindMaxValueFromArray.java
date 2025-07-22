package com.ddc.algorithm.array;

public class FindMaxValueFromArray {

    public static int findMaxValueFromArray(int[] array) {
        return process(array, 0, array.length -1);
    }

    public static int process(int[] array, int L, int R) {
        //base case
        if (L == R) {
            return array[L];
        }
        int middle = L + (R - L) >> 1;
        int leftMax = process(array, L, middle);
        int rightMax = process(array, middle + 1 , R);
        return Math.max(leftMax, rightMax);
    }
}
