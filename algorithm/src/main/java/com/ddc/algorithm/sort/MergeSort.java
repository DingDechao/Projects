package com.ddc.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    // 非递归方法实现
    public void mergeSore(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int step = 1;

        while (step < array.length) {
            int L = 0;
            while (L < array.length) {
                if (step >= array.length - 1 - L + 1) {
                    break;
                }

                int M = L + step - 1;
                int R = M + Math.min(step, array.length - 1 - M);
                merge(array, L, M, R);
                L = R + 1;
            }
            if (step > array.length / 2) {
                break;
            } else {
                step *= 2;
            }
        }

    }

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
        int left = processAndCalculate(array, L, middle);
        int right = processAndCalculate(array, middle + 1, R);
        return left + right + mergeAndCalculate(array, L, middle, R);
    }

    public int mergeAndCalculate(int[] array, int L, int M, int R) {
        int[] temp = new int[R - L + 1];
        int tempIndex = 0;
        int pL = L;
        int pR = M + 1;
        int result = 0;
        while (pL <= M && pR <= R) {
            result += array[pL] < array[pR] ? (R - pR + 1) * array[pL] : 0;
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

    public void processAndReversePair(int[] array, int L, int R, List<String> result) {
        if (L == R) {
            return;
        }

        int middle = L + ((R - L) >> 1);
        processAndReversePair(array, L, middle, result);
        processAndReversePair(array, middle + 1, R, result);
        mergeAndReversePair(array, L, middle, R, result);
    }

    public void mergeAndReversePair(int[] array, int L, int M, int R, List<String> result) {
        int[] temp = new int[R - L + 1];
        int tempIndex = temp.length - 1;
        int pL = M;
        int pR = R;
        while (pL >= L && pR > M) {
            if (array[pL] > array[pR]) {
                for (var i = (pR - M); i > 0; i--) {
                    result.add(array[pL] + "," + array[pR - i - 1]);
                }
                temp[tempIndex--] = array[pL--];
            } else {
                temp[tempIndex--] = array[pR--];
            }
        }

        while (pL >= L) {
            temp[tempIndex--] = array[pL--];
        }

        while (pR > M) {
            temp[tempIndex--] = array[pR--];
        }

        for (var i = 0; i < temp.length; i++) {
            array[L + i] = temp[i];
        }
    }

    public void processAndBiggerThanRightTwice(int[] array, int L, int R, List<String> result) {
        if (L == R) {
            return;
        }

        int middle = L + ((R - L) >> 1);
        processAndBiggerThanRightTwice(array, L, middle, result);
        processAndBiggerThanRightTwice(array, middle + 1, R, result);
        mergeAndBiggerThanRightTwice(array, L, middle, R, result);
    }

    public void mergeAndBiggerThanRightTwice(int[] array, int L, int M, int R, List<String> result) {
        int windowR = M + 1;
        for (int i = L; i <= M; i++) {
            while (windowR <= R && array[i] > array[windowR] * 2) {
                windowR++;
            }
            for (var j = M + 1; j < windowR ; j++) {
                result.add(array[i] + "," + array[j]);
            }
        }


        int[] temp = new int[R - L + 1];
        int tempIndex = temp.length - 1;
        int pL = M;
        int pR = R;
        while (pL >= L && pR > M) {
            temp[tempIndex--] = array[pL] > array[pR] ? array[pL--] : array[pR--];
        }

        while (pL >= L) {
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
        int result = mergeSort.processAndCalculate(arrayAndCalculate, 0, arrayAndCalculate.length - 1);
        System.out.println(result);
        List<String> list = new ArrayList<>();
        mergeSort.processAndReversePair(arrayAndReversePair, 0, arrayAndCalculate.length - 1, list);
        System.out.println(list);
        List<String> list1 = new ArrayList<>();

        int[] array8 = new int[]{9, 2, 2, 3, 5, 4, 7};
        mergeSort.processAndBiggerThanRightTwice(array8, 0, array8.length - 1, list1);
        System.out.println(list1);
    }

    public static void test() {
        System.out.println(((1 + 3) / 2));
        System.out.println((1 + ((3 - 1) >> 1)));
    }
}
