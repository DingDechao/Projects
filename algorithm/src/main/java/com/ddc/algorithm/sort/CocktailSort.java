package com.ddc.algorithm.sort;

import java.util.Arrays;

public class CocktailSort {
    // 鸡尾酒排序
    // 实际上是冒泡排序的的升级版，双向冒泡：冒泡是每次遍历把最大的放到最右边，而鸡尾酒排序是每次遍历把最大的放到最右边，把最小的放到最左边
    // TODO : 还可以继续优化，记录最后一次交换的位置，下一次遍历只需要遍历到这个位置即可
    public void cocktailSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        // 假如一共10个元素，遍历5次就够了，因为每次遍历会把最大的放到最右边，把最小的放到最左边
        // 假如一共11个元素，遍历5次就够了，因为每次遍历会把最大的放到最右边，把最小的放到最左边，最后一个元素不大不小正好放中间
        for (var i = 0; i < array.length >> 2; i++) {
            System.out.println("遍历了" + (i + 1) + "次");
            boolean swapped = false;
            // 从左到右冒泡，把最大的放到最右边
            for (var j = i; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            swapped = false;
            // 从右到左冒泡，把最小的放到最左边
            for (var j = array.length - 2 - i; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }


    private void swap(int[] arr, int oldIndex, int newIndex) {
        int tmp = arr[newIndex];
        arr[newIndex] = arr[oldIndex];
        arr[oldIndex] = tmp;
    }

    public static void main(String[] args) {
        CocktailSort cocktailSort = new CocktailSort();
        int[] arr = {2, 3, 4, 5, 6, 7, 8, 1};
        System.out.println(Arrays.toString(arr));
        cocktailSort.cocktailSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
