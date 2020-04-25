package com.ddc.projects.java8.basic;

public class Test1 {

    public void BubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        for (int item : a) {
            System.out.print(item + "\t");
        }
    }

    public void QuickSprt(int[] a, int i, int j) {
        int key = a[i];
        while (i < j) {
            while (i < j && a[j] >= key) {
                j--;
            }
            a[i] = a[j];

            while (i < j && a[i] <= key) {
                i++;
            }
            a[j] = a[i];
        }
        a[i] = key;

    }

    public void MidCheck(int[] a, int c) {
        BubbleSort(a);
        int low = 0;
        int hight = a.length - 1;
        int mid = (low + hight) / 2;

        while (mid != low && mid != hight) {
            if (c <= a[mid]) {
                hight = mid;
                mid = (low + hight) / 2;
            } else {
                low = mid;
                mid = (low + hight) / 2;
            }
        }
        if (c == a[low] || c == a[hight]) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }


    public static void main(String[] args) {
        int[] a = {100, 40, 60, 87, 34, 11, 56, 0};
        Test1 test1 = new Test1();
//		test.BubbleSort(a);
//		test.QuickSprt(a, 0, 7);
//		for(int item:a){
//			System.out.println(item);
//		}
        test1.MidCheck(a, 20);
    }
}
