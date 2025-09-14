package com.ddc.algorithm.sort;

import java.util.Arrays;

public class CountingSort {
    // 计数排序
    // 1. 找出数组中的最大值和最小值
    // 2. 创建一个计数数组，长度为最大值减最小值加1
    // 3. 遍历原数组，统计每个元素出现的次数，存入计数数组
    // 4. 遍历计数数组，将元素按出现次数放回原数组
    // 适用于数据范围不大的情况，时间复杂度O(N+K)，空间复杂度O(K)，K为数据范围
    public void countingSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] > max) {
                max = arr[i];
            }
        }
        int[] countArr = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i] - min]++;
        }
        int index = 0;
        for (int i = 0; i < countArr.length; i++) {
            while (countArr[i]-- > 0) {
                arr[index++] = i + min;
            }
        }
    }

    // 有稳定性的版本
    public void countingSortStable(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] > max) {
                max = arr[i];
            }
        }
        int[] countArr = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i] - min]++;
        }
        for (int i = 1; i < countArr.length; i++) {
            countArr[i] += countArr[i - 1];
        }
        int[] res = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            res[countArr[arr[i] - min] - 1] = arr[i];
            countArr[arr[i] - min]--;
        }
        System.arraycopy(res, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        int[] arr = {8, 7, 5, 3, 1, 9, 8, 7, 5, 3, 1, 9, 8, 7, 5, 3, 1, 9};
        CountingSort countingSort = new CountingSort();
        countingSort.countingSort(arr);
        System.out.println(Arrays.toString(arr));


        int[] arr2 = {8, 7, 5, 3, 1, 9, 8, 7, 5, 3, 1, 9, 8, 7, 5, 3, 1, 9};
        countingSort.countingSortStable(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}