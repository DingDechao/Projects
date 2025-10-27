package com.ddc.algorithm.leetcode.topN;

// 88: https://leetcode.com/problems/merge-sorted-array/description/
public class MergeSortedArray0088 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1;
        int right = n - 1;
        int index = m + n - 1;
        while (left >= 0 && right >= 0) {
           if(nums1[left] > nums2[right]) {
               nums1[index--] = nums1[left--];
           } else {
               nums1[index--] = nums2[right--];
           }
        }
        while (right >= 0) {
            nums1[index--] = nums2[right--];
        }
    }

    public void merge0(int[] nums1, int m, int[] nums2, int n) {
        int left = 0;
        int right = 0;
        int[] help = new int[m + n];
        int index = 0;
        while (left < m && right < n) {
            if (nums1[left] <= nums2[right]) {
                help[index++] = nums1[left++];
            } else {
                help[index++] = nums2[right++];
            }
        }

        while (left < m) {
            help[index++] = nums1[left++];
        }
        while (right < n) {
            help[index++] = nums2[right++];
        }
        nums1 = help;
    }

    public static void main(String[] args) {
        MergeSortedArray0088 mergeSortedArray0088 = new MergeSortedArray0088();
        mergeSortedArray0088.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
//        mergeSortedArray0088.merge(new int[]{0}, 0, new int[]{1}, 1);
    }
}
