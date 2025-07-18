package com.ddc.algorithm;

public class PrintBinary {



    public static void bitOperation() {
        // int 32位 long 64位
        for (var i = 31; i >=0; i--) {
           printBinaryForInt( 1 << i);
        }
    }

    public static void printBinaryForInt(int number) {
        System.out.print((number + "'s binary number is "));
        // int 32位 long 64位
        for (var i = 31; i >=0; i--) {
            System.out.print((((1 << i) & number) == 0 ? "0" : "1"));
        }
        System.out.println();
    }



    public static void main(String[] args) {
        bitOperation();
        printBinaryForInt(0);
        printBinaryForInt(123456);
        printBinaryForInt(Integer.MAX_VALUE);
    }

/*    -2147483648's binary number is 10000000000000000000000000000000
            1073741824's binary number is 01000000000000000000000000000000
            536870912's binary number is 00100000000000000000000000000000
            268435456's binary number is 00010000000000000000000000000000
            134217728's binary number is 00001000000000000000000000000000
            67108864's binary number is 00000100000000000000000000000000
            33554432's binary number is 00000010000000000000000000000000
            16777216's binary number is 00000001000000000000000000000000
            8388608's binary number is 00000000100000000000000000000000
            4194304's binary number is 00000000010000000000000000000000
            2097152's binary number is 00000000001000000000000000000000
            1048576's binary number is 00000000000100000000000000000000
            524288's binary number is 00000000000010000000000000000000
            262144's binary number is 00000000000001000000000000000000
            131072's binary number is 00000000000000100000000000000000
            65536's binary number is 00000000000000010000000000000000
            32768's binary number is 00000000000000001000000000000000
            16384's binary number is 00000000000000000100000000000000
            8192's binary number is 00000000000000000010000000000000
            4096's binary number is 00000000000000000001000000000000
            2048's binary number is 00000000000000000000100000000000
            1024's binary number is 00000000000000000000010000000000
            512's binary number is 00000000000000000000001000000000
            256's binary number is 00000000000000000000000100000000
            128's binary number is 00000000000000000000000010000000
            64's binary number is 00000000000000000000000001000000
            32's binary number is 00000000000000000000000000100000
            16's binary number is 00000000000000000000000000010000
            8's binary number is 00000000000000000000000000001000
            4's binary number is 00000000000000000000000000000100
            2's binary number is 00000000000000000000000000000010
            1's binary number is 00000000000000000000000000000001
            123456's binary number is 00000000000000011110001001000000
            2147483647's binary number is 01111111111111111111111111111111*/
}
