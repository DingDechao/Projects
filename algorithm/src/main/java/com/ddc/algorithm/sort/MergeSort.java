package com.ddc.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public void process(int[] array, int L, int R) {
        if (L == R) {
            return;
        }

        int middle = L + ((R - L) >> 1);
        process(array, L, middle);
        process(array, middle + 1, R);
        merge(array, L, middle, R);


    }

    public void merge(int[] array, int L, int M, int R) {
        int[] temp = new int[R - L + 1];
        int tempIndex = 0;
        int pL = L;
        int pR = M + 1;

        while (pL <= M && pR <= R) {
            temp[tempIndex++] = array[pL] < array[pR] ? array[pL++] : array[pR++];
        }

        while (pL <= M) {
            temp[tempIndex++] = array[pL++];
        }

        while (pR <= R) {
            temp[tempIndex++] = array[pR++];
        }

        for (var i = 0; i < temp.length; i++) {
            array[L + i] = temp[i];
        }
    }

    public int processAndCalculate(int[] array, int L, int R) {
        if (L == R) {
            return 0;
        }

        int middle = L + ((R - L) >> 1);
        int left =  processAndCalculate(array, L, middle);
        int right =  processAndCalculate(array, middle + 1, R);
        return left + right + mergeAndCalculate(array, L, middle, R);
    }

    public int mergeAndCalculate(int[] array, int L, int M, int R) {
        int[] temp = new int[R - L + 1];
        int tempIndex = 0;
        int pL = L;
        int pR = M + 1;
        int result = 0;
        while (pL <= M && pR <= R) {
            result += array[pL] < array[pR] ?  (R - pR + 1) * array[pL] : 0;
            temp[tempIndex++] = array[pL] < array[pR] ? array[pL++] : array[pR++];
        }

        while (pL <= M) {
            temp[tempIndex++] = array[pL++];
        }

        while (pR <= R) {
            temp[tempIndex++] = array[pR++];
        }

        for (var i = 0; i < temp.length; i++) {
            array[L + i] = temp[i];
        }

        return result;
    }

    public void processAndReversePair(int[] array, int L, int R, List result) {
        if (L == R) {
            return;
        }

        int middle = L + ((R - L) >> 1);
        processAndReversePair(array, L, middle, result);
        processAndReversePair(array, middle + 1, R, result);
        mergeAndCReversePair(array, L, middle, R, result);
    }

    public void mergeAndCReversePair(int[] array, int L, int M, int R, List result) {
        int[] temp = new int[R - L + 1];
        int tempIndex = temp.length - 1;
        int pL = M;
        int pR = R;
        while (pL >=L && pR > M) {
            if (array[pL] > array[pR]) {
                for (var i = (pR - M); i > 0; i-- ) {
                    result.add(array[pL] + "," + array[pR - i -1]);
                }
                temp[tempIndex--] = array[pL--];
            } else {
                temp[tempIndex--] = array[pR--];
            }
        }

        while (pL >=L) {
            temp[tempIndex--] = array[pL--];
        }

        while (pR > M) {
            temp[tempIndex--] = array[pR--];
        }

        for (var i = 0; i < temp.length; i++) {
            array[L + i] = temp[i];
        }
    }


    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] array = new int[]{1, 2, 2, 3, 5, 3, 7};
        int[] arrayAndCalculate = Arrays.copyOf(array, array.length);
        int[] arrayAndReversePair = Arrays.copyOf(array, array.length);
        mergeSort.process(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
        int result = mergeSort.processAndCalculate(arrayAndCalculate, 0 , arrayAndCalculate.length - 1);
        System.out.println(result);
        List list = new ArrayList();
        mergeSort.processAndReversePair(arrayAndReversePair, 0 , arrayAndCalculate.length - 1, list);
        System.out.println(list);
//        test();
    }

    public static void test() {
        System.out.println(((1 + 3) / 2));
        System.out.println((1 + ((3 -1 ) >> 1)));
    }
}
