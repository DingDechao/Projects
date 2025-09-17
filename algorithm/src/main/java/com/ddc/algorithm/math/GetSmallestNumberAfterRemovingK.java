package com.ddc.algorithm.math;

public class GetSmallestNumberAfterRemovingK {

    // 删除k个数字后, 使得剩下的数字组成的数最小
    // 例如: 321321, k = 3, 删除3个数字后, 剩下的数字是121, 121是所有可能的结果中最小的
    // 思路: 使用一个栈, 从左到右遍历数字, 如果当前数字小于栈顶数字, 那么就弹出栈顶数字, 直到栈顶数字小于等于当前数字
    // 或者栈为空, 然后将当前数字入栈
    // 重复上述过程, 直到遍历完所有数字, 如果此时k还大于0, 那么就从栈顶弹出k个数字, 最后将栈中的数字组成一个字符串返回
    public static String getSmallestNumber(String str, int k) {
        if (str == null || str.isEmpty() || k < 0 || k >= str.length()) {
            return "";
        }
        char[] chars = str.toCharArray();
        int len = chars.length;
        char[] stack = new char[len - k]; // 栈的大小为len - k
        int top = 0; // 栈顶指针
        for (char cur : chars) {
            while (top > 0 && stack[top - 1] > cur && k > 0) {
                top--;
                k--;
            }
            stack[top++] = cur;
        }
        int offset = 0;
        while (offset < stack.length - 1 && stack[offset] == '0') {
            offset++;
        }
        return offset == stack.length ? "0" : new String(stack, offset, stack.length - offset);
    }

    // 删除k个数字后, 使得剩下的数字组成的数最小
    // 例如: 321321, k = 3, 删除3个数字后, 剩下的数字是121, 121是所有可能的结果中最小的
    // 暴力方法 ：每次删除一个数字, 直到删除k个数字为止
    public static String getSmallestNumberViolence(String str, int k) {
        if (str == null || str.isEmpty() || k < 0 || k >= str.length()) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < k; i++) {
            int index = 0;
            while (index < sb.length() - 1 && sb.charAt(index) <= sb.charAt(index + 1)) {
                index++;
            }
            sb.deleteCharAt(index);
        }
        // 去掉前导0
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(getSmallestNumber("321321", 3)); // 121
        System.out.println(getSmallestNumber("1593212", 3)); //1212
        System.out.println(getSmallestNumber("30200", 1)); //200
        System.out.println(getSmallestNumber("10", 2)); //
        System.out.println(getSmallestNumber("541270936", 3)); //120936

        System.out.println("=========");
        System.out.println(getSmallestNumberViolence("321321", 3)); // 121
        System.out.println(getSmallestNumberViolence("1593212", 3)); //1212
        System.out.println(getSmallestNumberViolence("30200", 1)); //200
        System.out.println(getSmallestNumberViolence("10", 2)); //
        System.out.println(getSmallestNumberViolence("541270936", 3)); //120936
    }
}
