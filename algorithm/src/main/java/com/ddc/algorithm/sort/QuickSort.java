package com.ddc.algorithm.sort;

import java.util.Arrays;

public class QuickSort {
    //快速排序
    //1.在数组中随机选一个数作为基准数
    //2.把小于基准数的放左边，大于基准数的放右边
    //3.对左边和右边的数组重复1、2步骤，直到数组有序
    // 时间复杂度O(N*logN)
    // 实现方式有两种，双边循环法和单边循环法



    public static void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process1(arr, 0, arr.length - 1); //递归调用
    }

    public static void process1(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        //随机选一个数作为基准数
        swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
        int[] p = partition1(arr, L, R);
        process1(arr, L, p[0] - 1);
        process1(arr, p[1] + 1, R);
    }

    // 双边循环法
    // 设置两个指针，左指针从左往右移动，右指针从右往左移动
    // 左指针找到第一个大于等于基准数的位置，右指针找到第一个小于等于基准数的位置
    // 交换两个指针指向的数
    // 重复上述过程，直到左指针大于右指
    public static int[] partition1(int[] arr, int L, int R) {
        int less = L - 1; //小于基准数的区域
        int more = R; //大于基准数的区域
        int index = L; //当前指针
        while (index < more) { //当前指针没有碰到大于基准数的区域
            if (arr[index] < arr[R]) { //当前数小于基准数
                swap(arr, ++less, index++);
            } else if (arr[index] > arr[R]) { //当前数大于基准数
                swap(arr, --more, index);
            } else { //当前数等于基准数
                index++;
            }
        }
        swap(arr, more, R); //把基准数放到中间
        return new int[]{less + 1, more}; //返回等于基准数的区域

    }

    public static void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process2(arr, 0, arr.length - 1); //递归调用
    }


    public static void process2(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        //随机选一个数作为基准数
        swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
        int[] p = partition2(arr, L, R);
        process2(arr, L, p[0] - 1);
        process2(arr, p[1] + 1, R);
    }

    // 单边循环法
    // 设置一个指针，指向小于基准数的区域的最后一个位置
    // 遍历数组，如果当前数小于基准数，指针加1，交换当前数和指针指向的数
    // 如果当前数大于等于基准数，指针不动,继续遍历
    // 遍历结束后，交换指针加1的位置和基准数
    public static int[] partition2(int[] arr, int L, int R) {
        int less = L - 1; //小于基准数的区域
        int index = L; //当前指针
        while (index < R) { //当前指针没有碰到基准数
            if (arr[index] < arr[R]) { //当前数小于基准数
                swap(arr, ++less, index);
            }
            index++;
        }
        swap(arr, ++less, R); //把基准数放到中间
        return new int[]{less, less}; //返回等于基准数的区域
    }

    private static void swap(int[] arr, int oldIndex, int newIndex) {
        int tmp = arr[newIndex];
        arr[newIndex] = arr[oldIndex];
        arr[oldIndex] = tmp;
    }


    public static void main(String[] args) {
        int[] arr1 = {2, 3, 4, 5, 6, 7, 8, 1};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(arr1));
        quickSort1(arr1);
        System.out.println("排序后：");
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {2, 3, 4, 5, 6, 7, 8, 5};
        //int[] arr2 = {1, 2, 4, 3, 2, 3, 4, 3};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(arr2));
        quickSort2(arr2);
        System.out.println("排序后：");
        System.out.println(Arrays.toString(arr2));

    }
}
