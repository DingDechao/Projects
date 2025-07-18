package com.ddc.algorithm.bitoperation;


import java.util.*;

public class KM {
    //有个数组，某个数字出现了K次， 还有些数字出现了M次，K < M, M >1
    public int onlyKTimes(int[] array, int k, int m) {
        int[] temp = new int[32];
        for (int number : array) {
            for (var i = 0; i < 32; i++) {
                temp[i] += (number >> i) & 1;
            }
        }
        int tempNumber = 0;
        for (int i = 0; i < 32; i++) {
            int kOrZero = temp[i] % m;
            if (kOrZero != 0) {
                if (kOrZero == k) {
                    tempNumber |= (1 << i);
                } else {
                    return -1;
                }
            }
        }

        if (tempNumber == 0) {
            int count = 0;
            for (int number : array) {
                if (number == 0) {
                    count++;
                }
            }
            if (count != k) {
                return -1;
            }
        }
        return tempNumber;
    }


    //经典hash解决方案作为对数器使用
    public int mapTest(int[] array, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int number : array) {
            if (map.containsKey(number)) {
                map.put(number, map.get(number) + 1);
            } else {
                map.put(number, 1);
            }
        }
        for (int number : map.keySet()) {
            if (map.get(number) == k) {
                return number;
            }
        }
        return -1;
    }

    public int[] random(int maxKinds, int range, int k, int m) {
        int numberK = getRandomNumber(range);
        int numberKTimes = Math.random() < 0.5 ? k : ((int) (Math.random() * (m - 1)) + 1);
        int kinds = (int) (Math.random() * (maxKinds + 1)) + 2;
        int[] array = new int[numberKTimes + (kinds - 1) * m];
        var index = 0;
        for (; index < numberKTimes; index++) {
            array[index] = numberK;
        }
        kinds--;
        Set<Integer> set = new HashSet<>();
        set.add(numberK);
        while (kinds != 0) {
            int numberM = 0;
            do {
                numberM = getRandomNumber(range);
            } while (set.contains(numberM));
            set.add(numberM);
            for (var i = 0; i < m; i++) {
                array[index++] = numberM;
            }
            kinds--;
        }

        for (var i = 0; i < array.length; i++) {
            int j = (int) (Math.random() * array.length);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        return array;
    }


    private int getRandomNumber(int range) {
        return (int) (Math.random() * (range + 1)) - (int) (Math.random() * (range + 1));
    }


    public static void main(String[] args) {
        KM km = new KM();
//        int[] aaa = new int[]{0, 0, 0, -14, -14, 0, -14, -14, -14, -14, 0, 0, -14};
//        int b  = km.onlyKTimes(aaa, 4, 7);
        int maxKinds = 5;
        int range = 30;
        int testTimes = 1_000_00;
        int max = 9;
        System.out.println("Start testing");
        for (var i = 0; i < testTimes; i++) {
            int a = (int) (Math.random() * max) + 1;
            int b = (int) (Math.random() * max) + 1;
            int k = Math.min(a, b);
            int m = Math.max(a, b);
            if (k == m) {
                m++;
            }
            int[] array = km.random(maxKinds, range, k, m);

            int s = km.mapTest(array, k);
            int x = km.onlyKTimes(array, k, m);
            if (s != x) {
                System.out.println(Arrays.toString(array));
                System.out.println("k="+k+", "+ s + "," + x);
            }
        }
    }
}
