package com.ddc.algorithm.heap;

public class HeapTest0 {

    public void headSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        for (var i = 0; i < array.length; i++) {
            heapInsert(array, i);
        }

        swap(array, 0, array.length - 1);
        int size = array.length - 2;
        while (size > 0) {
            heapify(array, 0, size);
            swap(array, 0, size--);
        }
    }

    public void heapInsert(int[] array, int index) {
        while (array[index] > array[(index - 1) / 2]) {
            swap(array, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }


    public void heapify(int[] array, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largestIndex = left + 1 <= heapSize && array[left + 1] > array[left] ? left + 1 : left;
            largestIndex = array[largestIndex] > array[index] ? largestIndex : index;

            if (largestIndex == index) {
                break;
            }

            swap(array, largestIndex, index);
            index = largestIndex;
            left = index * 2 + 1;
        }
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        new HeapTest0().headSort(new int[]{9, 2, 2, 3, 5, 4, 7});
    }
}
