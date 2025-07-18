package com.ddc.algorithm.sort;

import java.util.Arrays;

public class SelectionSortTest0 {
    // 选择排序
    // 找出0-N-1上面最小的,把最小的放到第0位
    // 找出1-N-1上面最小的,把最小的放到第1位
    // 找出2-N-1上面最小的,把最小的放到第2位

    public void selectionSort(int[] arr) {
        for (var i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            for (var j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
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
        SelectionSortTest0 selectionSortTest0 = new SelectionSortTest0();
        selectionSortTest0.printIntArray(arr);
        selectionSortTest0.selectionSort(arr);
        selectionSortTest0.printIntArray(arr);
    }
}
