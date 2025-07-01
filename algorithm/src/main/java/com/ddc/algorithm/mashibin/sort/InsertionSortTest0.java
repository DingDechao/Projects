package com.ddc.algorithm.mashibin.sort;

import java.util.Arrays;

public class InsertionSortTest0 {
    //选择排序
    //两个两个比较，把大的往右边移动
    //第一轮结束 最大的肯定在最右边
    //。。。


    public void insertionSort(int[] arr) {
        for (var end = 1; end < arr.length-1; end++) {
            for (var j = end ; j > 0; j--) {
                if(arr[j] < arr[j-1]) {
                    swap(arr, j, j-1);
                }
            }
        }
    }

    private void swap(int[] arr, int oldIndex, int newIndex) {
        int tmp = arr[newIndex];
        arr[newIndex] = arr[oldIndex];
        arr[oldIndex] = tmp;
    }

    public void printIntArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {8,7,5,3,1,9};
        InsertionSortTest0 insertionSortTest0 = new InsertionSortTest0();
        insertionSortTest0.printIntArray(arr);
        insertionSortTest0.insertionSort(arr);
        insertionSortTest0.printIntArray(arr);
    }
}
