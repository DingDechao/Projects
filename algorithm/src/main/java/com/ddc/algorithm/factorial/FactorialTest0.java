package com.ddc.algorithm.factorial;

public class FactorialTest0 {

    // 1! + 2! + 3! + ... + N!

    private int factoricalSum0(int n) {
        if (n < 1) {
            return 0;
        }
        int result = 0;
        for (var i = 1; i <= n; i++) {
            result += factorial(i);
        }
        return result;
    }

    private int factoricalSum1(int n) {
        if (n < 1) {
            return 0;
        }
        int result = 0;
        int last = 1;
        for (var i = 1; i <= n; i++) {
            result += last * i;
            last = factorial(i);
        }
        return result;
    }

    private int factoricalSum2(int n) {
        if (n < 1) {
            return 0;
        }
        int result = 0;
        int current = 1;
        for (var i = 1; i <= n; i++) {
            current = current * i;
            result += current;
        }
        return result;
    }

    private int factorial(int n) {
        if (n < 1) {
            return 0;
        }
        int result = 1;
        for (var i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        FactorialTest0 factorialTest0 = new FactorialTest0();

//        System.out.println(factorialTest0.factorial(0));
//        System.out.println(factorialTest0.factorial(1));
//        System.out.println(factorialTest0.factorial(2));
//        System.out.println(factorialTest0.factorial(3));
//        System.out.println(factorialTest0.factorial(4));
//        System.out.println(factorialTest0.factorial(5));

        System.out.println("0-->" + factorialTest0.factoricalSum0(0));
        System.out.println("1-->" + factorialTest0.factoricalSum0(1));
        System.out.println("2-->" + factorialTest0.factoricalSum0(2));
        System.out.println("3-->" + factorialTest0.factoricalSum0(3));
        System.out.println("4-->" + factorialTest0.factoricalSum0(4));
        System.out.println("5-->" + factorialTest0.factoricalSum0(5));

        System.out.println("0-->" + factorialTest0.factoricalSum1(0));
        System.out.println("1-->" + factorialTest0.factoricalSum1(1));
        System.out.println("2-->" + factorialTest0.factoricalSum1(2));
        System.out.println("3-->" + factorialTest0.factoricalSum1(3));
        System.out.println("4-->" + factorialTest0.factoricalSum1(4));
        System.out.println("5-->" + factorialTest0.factoricalSum1(5));

        System.out.println("0-->" + factorialTest0.factoricalSum2(0));
        System.out.println("1-->" + factorialTest0.factoricalSum2(1));
        System.out.println("2-->" + factorialTest0.factoricalSum2(2));
        System.out.println("3-->" + factorialTest0.factoricalSum2(3));
        System.out.println("4-->" + factorialTest0.factoricalSum2(4));
        System.out.println("5-->" + factorialTest0.factoricalSum2(5));
    }
}
