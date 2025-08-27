package com.ddc.algorithm.monotonicstack;

public class MonotonicStack {

    //单调栈
    //找到数组里面每个元素左边和右边第一个比它小的元素


//    //单调栈
//    //https://leetcode.cn/problems/next-greater-element-i/
//    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        int n = nums2.length;
//        int[] result = new int[nums1.length];
//        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
//        java.util.Stack<Integer> stack = new java.util.Stack<>();
//        for (int i = n - 1; i >= 0; i--) {
//            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
//                stack.pop();
//            }
//            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
//            stack.push(nums2[i]);
//        }
//        for (int i = 0; i < nums1.length; i++) {
//            result[i] = map.get(nums1[i]);
//        }
//        return result;
//    }
//
//    public static void main(String[] args) {
//        MonotonicStack test = new MonotonicStack();
//        int[] nums1 = {4,1,2};
//        int[] nums2 = {1,3,4,2};
//        int[] result = test.nextGreaterElement(nums1, nums2);
//        for (int r : result) {
//            System.out.print(r + " ");
//        }
//    }
}
