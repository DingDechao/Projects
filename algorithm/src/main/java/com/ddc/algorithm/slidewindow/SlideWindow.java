package com.ddc.algorithm.slidewindow;


public class SlideWindow {

    public static int[] maxSlidingWindowWithLinkedList(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1];
        java.util.Deque<Integer> deque = new java.util.LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    public static int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int maxIndex = -1;
        for (int i = 0; i <= n - k; i++) {
            if (maxIndex < i) {
                maxIndex = i;
                for (int j = i; j < i + k; j++) {
                    if (nums[j] > nums[maxIndex]) {
                        maxIndex = j;
                    }
                }
            } else if (nums[i + k - 1] >= nums[maxIndex]) {
                maxIndex = i + k - 1;
            }
            result[i] = nums[maxIndex];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result0 = maxSlidingWindow1(nums, k);
        int[] result1 = maxSlidingWindowWithLinkedList(nums, k);
        System.out.println("---测试开始---");
        for (int i = 0; i < result0.length; i++) {
           if (result0[i] != result1[i]) {
               System.out.println("测试失败");
               return;
           }

        }
        System.out.println("---测试结束---");
    }
}
