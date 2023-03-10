package com.ddc.projects.java11.java8.algorithm.sort;

public class Sort {
    public static void main(String[] args) {
        int[] a = {100, 40, 60, 87, 34, 11, 56, 0};
        Sort s = new Sort();
        s.sort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; ++i) {
            System.out.print(a[i] + ",");
        }
        System.out.println("");
    }

    public void sort(int[] a, int low, int high) {
        if (low >= high)
            return;
        if ((high - low) == 1) {
            if (a[0] > a[1])
                swap(a, 0, 1);
            return;
        }
        int p = a[low];
        int left = low + 1;
        int right = high;
        while (left < right) {
            while (left < right && left <= high) {
                if (a[left] > p)
                    break;
                left++;
            }
            while (left <= right && right > low) {
                if (a[right] <= p)
                    break;
                right--;
            }
            if (left < right) {
                swap(a, right, left);
            }
        }
        swap(a, low, right);
        sort(a, low, right);
        sort(a, right + 1, high);
    }

    private void swap(int[] array, int i, int j) {
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

