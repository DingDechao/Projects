package com.ddc.algorithm.math;

public class BigNumberSum {
    // 字符串表示的大数相加
    public String bigNumberSum(String num1, String num2) {
        int maxLength = Math.max(num1.length(), num2.length()) + 1;
        int[] array1 = new int[maxLength];
        int[] array2 = new int[maxLength];
        int[] result = new int[maxLength];

        for (int i = 0; i < num1.length(); i++) {
            array1[i] = num1.charAt(num1.length() - 1 - i) - '0';
        }

        for (int i = 0; i < num2.length(); i++) {
            array2[i] = num2.charAt(num2.length() - 1 - i) - '0';
        }

        for (int i = 0; i < maxLength; i++) {
            int sum = array1[i] + array2[i] + result[i];
            result[i] = sum % 10;
            if (sum >= 10) {
                result[i + 1] += sum / 10;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = result.length - 1; i >= 0; i--) {
            if (stringBuilder.isEmpty() && result[i] == 0) {
                continue;
            }
            stringBuilder.append(result[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        BigNumberSum bigNumberSum = new BigNumberSum();
        System.out.println(bigNumberSum.bigNumberSum("123", "456"));
        System.out.println(bigNumberSum.bigNumberSum("12345678901234567890", "98765432109876543210"));
        // 随机生成两个大数相加
        String num1 = "";
        String num2 = "";
        for (int i = 0; i < 100; i++) {
            num1 += (int) (Math.random() * 10);
            num2 += (int) (Math.random() * 10);
        }
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(bigNumberSum.bigNumberSum(num1, num2));
    }
}
