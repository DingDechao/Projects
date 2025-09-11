package com.ddc.algorithm.sort;

import java.util.Arrays;

public class BubbleSort {
    //冒泡排序
    //两个两个比较，把大的往右边移动
    //第一轮结束 最大的肯定在最右边
    // 一共需要遍历元素数量减一轮，遍历一次确定一个，遍历N-1轮,那么N-1个元素就有序了，最后一个元素不用遍历了就在正确的位置上了
    //。。。


    public void bubbleSort(int[] arr) {
        // 优化思路2：每一轮比较时，记录最后一次交换的位置，作为下一轮比较的结束位置
        int lastExchangeIndex = 0;
        int sortBorder = arr.length - 1;
        for (var end = arr.length - 1; end > 0; end--) {
            // 优化思路1：如果某一轮没有进行交换，说明数组已经有序，可以提前结束排序
            boolean swapped = false;
            for (var j = 1; j <= sortBorder; j++) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                    swapped = true;
                    lastExchangeIndex = j - 1;
                }
            }
            sortBorder = lastExchangeIndex;
            if (!swapped) {
                break;
            }
        }
    }

    public void swap(int[] arr, int oldIndex, int newIndex) {
        int tmp = arr[newIndex];
        arr[newIndex] = arr[oldIndex];
        arr[oldIndex] = tmp;
    }

    public void printIntArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = {8, 7, 5, 3, 1, 9};
        bubbleSort.printIntArray(arr);
        bubbleSort.bubbleSort(arr);
        bubbleSort.printIntArray(arr);

        int[] arr2 = new int[]{5, 8, 6, 3, 9, 2, 1, 7};
        bubbleSort.printIntArray(arr2);
        bubbleSort.bubbleSort(arr2);
        bubbleSort.printIntArray(arr2);

        int[] arr3 = new int[]{3, 4, 2, 1, 5 ,6, 7, 8   };
        bubbleSort.printIntArray(arr3);
        bubbleSort.bubbleSort(arr3);
        bubbleSort.printIntArray(arr3);
    }
}
