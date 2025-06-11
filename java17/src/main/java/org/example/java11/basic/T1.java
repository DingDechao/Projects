package org.example.java11.basic;

public class T1 {
    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void sort(int[] a, int low, int high) {
        if (low >= high) return;
        if ((high - low) == 1) {
            if (a[0] > a[1]) swap(a, 0, 1);
            return;
        }
        int p = a[low];
        int left = low + 1;
        int right = high;
        while (right > left) {
            while (right > left && left <= high) {
                if (a[left] > p) break;
                left++;
            }
            while (right >= left && right > low) {
                if (a[right] <= p) break;
                right--;
            }

            if (right > left) {
                swap(a, right, left);
            }
        }
        swap(a, low, right);
        sort(a, low, right);
        sort(a, right + 1, high);
    }

    public static void main(String[] args) {
        int[] a = {100, 40, 60, 87, 34, 11, 56, 0};
        T1 t = new T1();
        t.sort(a, 0, a.length - 1);
        for (int item : a) {
            System.out.print(item + " ");
        }
    }
}
