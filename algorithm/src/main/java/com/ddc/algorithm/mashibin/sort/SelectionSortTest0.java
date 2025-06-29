package com.ddc.algorithm.mashibin.sort;

import java.util.Arrays;

public class SelectionSortTest0 {
    //选择排序
    // 找出0-N-1上面最小的,把最小的放到第0位
    // 找出1-N-1上面最小的,把最小的放到第1位

    private void selectionSort(int[] arr) {

    }

    private void printIntArray(int[] arr) {
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
