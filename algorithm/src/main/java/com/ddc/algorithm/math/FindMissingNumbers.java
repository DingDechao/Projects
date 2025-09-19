package com.ddc.algorithm.math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindMissingNumbers {

    // 生成一个1到100的数组
    public static int[] generateArray() {
        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            if (i == 98) {
                continue;
            }
            array[i] = i + 1;
        }
        return array;
    }

    // 找出1到100中缺失的数字，使用hash表
    public static int findMissingNumber1(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1 ; i <= 100 ; i++) {
            set.add(i);
        }
        for (int number : array) {
            set.remove(number);
        }
        if (set.size() == 1) {
            return set.iterator().next();
        } else {
            throw new RuntimeException("No missing number or more than one missing number");
        }
    }

    // 找出1到100中缺失的数字，先计算累加和，再减去数组的累加和
    public static int findMissingNumber2(int[] array) {
        int n = 100;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int number : array) {
            actualSum += number;
        }
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateArray()));
        System.out.println(findMissingNumber1(generateArray()));
        System.out.println(findMissingNumber2(generateArray()));
    }
}
