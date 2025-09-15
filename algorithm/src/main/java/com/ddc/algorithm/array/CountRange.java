package com.ddc.algorithm.array;

// 给定一个数组arr，和两个整数a和b（a <= b），求arr中有多少个子数组的累加和在[a,b]范围上，返回达标的子数组的数量
public class CountRange {

//    // 构建前缀和数组
//    public static int[] prefixSumArray(int[] array) {
//        int[] prefixSum = new int[array.length + 1];
//        prefixSum[0] = 0;
//        for (var i = 0; i < array.length; i++) {
//            prefixSum[i + 1] = prefixSum[i] + array[i];
//        }
//        return prefixSum;
//    }
//
//
//    public static void main(String[] args) {
//        int[] array = {3, -2, 4, 3, 6, -1};
//        int[] prefixSum = prefixSumArray(array);
//        for (int i : array) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
//        for (int i : prefixSum) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
//    }
}
