package com.ddc.algorithm.array;

import java.util.Arrays;

public class ArrayTest0 {
    private int[] array;
    private int size;

    public ArrayTest0(int capacity) {
        this.array = new int[capacity];
        size = 0;

    }

    public void printArray() {
        System.out.println(Arrays.toString(array));
    }

    public boolean insert(int element, int index) {
        if (index < 0 || index > size) {
            return false;
        }

        if (size >= array.length) {
            resize();
        }

        for (var i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
        return true;
    }

    public boolean delete(int index) {
        if (index < 0 || index >= size) {
            return false;
        }
        for (var i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = 0;
        size--;
        return true;
    }

    private void resize() {
        int[] newArray = new int[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public static void main(String[] args) {
        ArrayTest0 arrayTest0 = new ArrayTest0(11);
        arrayTest0.printArray();
        arrayTest0.insert(3, 0);
        arrayTest0.printArray();
        arrayTest0.insert(1, 1);
        arrayTest0.printArray();
        arrayTest0.insert(2, 2);
        arrayTest0.printArray();
        arrayTest0.insert(5, 3);
        arrayTest0.printArray();
        arrayTest0.insert(4, 4);
        arrayTest0.printArray();
        arrayTest0.insert(9, 5);
        arrayTest0.printArray();
        arrayTest0.insert(10, 2);
        arrayTest0.printArray();
        arrayTest0.insert(11, 2);
        arrayTest0.printArray();
        arrayTest0.insert(12, 2);
        arrayTest0.printArray();
        arrayTest0.insert(13, 2);
        arrayTest0.printArray();
        arrayTest0.insert(14, 2);
        arrayTest0.printArray();
        arrayTest0.insert(15, 2);
        arrayTest0.printArray();
        arrayTest0.insert(16, 2);
        arrayTest0.printArray();
        arrayTest0.delete(2);
        arrayTest0.printArray();
//
//        int[] array = {3, 1, 2, 5, 4, 9, 7, 2};
//        System.out.println(array.length);
//        System.out.println(Arrays.toString(array));
//        int[] array1 = new int[8];
//        array1[0] = 3;
//        array1[1] = 1;
//        System.out.println(array1.length);
//        System.out.println(Arrays.toString(array1));
    }
}
