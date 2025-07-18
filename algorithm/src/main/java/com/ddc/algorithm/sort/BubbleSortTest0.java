package com.ddc.algorithm.sort;

import java.util.Arrays;

public class BubbleSortTest0 {
    //冒泡排序
    //两个两个比较，把大的往右边移动
    //第一轮结束 最大的肯定在最右边
    //。。。


    public void bubbleSort(int[] arr) {
        for (var end = arr.length - 1 ; end > 0; end--) {
            for (var j = 1; j <= end; j++) {
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
        BubbleSortTest0 bubbleSortTest0 = new BubbleSortTest0();
        bubbleSortTest0.printIntArray(arr);
        bubbleSortTest0.bubbleSort(arr);
        bubbleSortTest0.printIntArray(arr);
    }
}
