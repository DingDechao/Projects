package org.example.java11.array;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

public class ArraysTest {
    public static void main(String[] args) {
        var a = new int[] {3, 4, 5, 6};
        var a2 = new int[] {3, 4, 5, 6};
        System.out.println(Arrays.equals(a, a2));

        var b = Arrays.copyOf(a, 6);
        System.out.println(Arrays.equals(a, b));
        System.out.println(Arrays.toString(b));
        Arrays.sort(b);
        System.out.println(Arrays.toString(b));

        var arr1 = new int[] {3, 4 ,5 ,6 ,7};
        Arrays.parallelSort(arr1);
        System.out.println(Arrays.toString(arr1));

        var arr2 = new int[] {3, 4 ,5 ,6 ,7};
        Arrays.parallelPrefix(arr2, new IntBinaryOperator() {
                    @Override
                    public int applyAsInt(int left, int right) {
                        return left * right;
                    }
                }
        );
        System.out.println(Arrays.toString(arr2));

        var arr3 = new int[5];
        Arrays.parallelSetAll(arr3, new IntUnaryOperator() {
            @Override
            public int applyAsInt(int operand) {
                return operand * 5;
            }
        });
        System.out.println(Arrays.toString(arr3));
    }
}
