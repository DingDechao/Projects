package com.ddc.algorithm.mashibin.sort;

import java.util.Arrays;

public class InsertionSortTest0 {
    //插入排序
    //先保证0-1上有序
    //再保证0-2上有序
    //。。。
    //O(N^2) -时间复杂度一般指的最差情况
    //[7, 6 ,5, 4] 需要交换 1次，2次，3次。。。等差数列


    public void insertionSort(int[] arr) {
        for (var end = 1; end < arr.length; end++) {
            for (var j = end ; j > 0 && arr[j] < arr[j-1]; j--) {
                swap(arr, j, j-1);
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
        //int[] arr = {3, 2 ,1};
        InsertionSortTest0 insertionSortTest0 = new InsertionSortTest0();
        insertionSortTest0.printIntArray(arr);
        insertionSortTest0.insertionSort(arr);
        insertionSortTest0.printIntArray(arr);
    }
}
