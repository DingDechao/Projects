package com.ddc.projects.java11.java8.array;

public class ArrayDemo {

    public void defineMultidimensionalArray() {
        int[][][][] a = new int[4][][][];
        int[][] b = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        //==》
        int[][] bb = new int[3][];
        /*b数组：
         * 1 2 3
         * 4 5 6
         * 7 8 9
         */
    }

    public void showMultidimensionalArray() {
        //我们可以把二维数组看做成一个特殊的一维数组
        //特殊在于：这个一维数组里面的元素存放的再不是我们的数值型元素而是另外一个一维数组
        //我们再定义，如果一个一维数组比较特殊，里面的元素也是一维数组，我们就把他另外取一个名字：叫做二维数组
        double[][] a = {{1, 2, 3}, {3, 4, 5}, {4, 5, 6}};
        double[][] b = {{12, 13, 14}, {23, 24, 25}, {34, 35, 36}};
        double[][] c = a;
        System.out.println("showMultidimensionalArray");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]);
                System.out.print(", ");
            }
            System.out.println();
        }
    }

    public void removeZeroFromArray(int[] intArray) {
        int totalZero = 0;
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] != 0) {
                totalZero++;
            }
        }
        int[] newArray = new int[totalZero];
        int newArrayIndex = 0;
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] != 0) {
                newArray[newArrayIndex] = intArray[i];
                newArrayIndex++;
            }
        }
        for (int j = 0; j < newArray.length; j++) {
            System.out.print(newArray[j] + "\t");
        }
    }

    public static void main(String[] args) {
        int intArray[] = {1, 3, 4, 5, 0, 0, 6, 6, 0, 5, 4, 7, 6, 7, 0, 0, 0, 0, 0, 5};
        ArrayDemo array = new ArrayDemo();
        array.removeZeroFromArray(intArray);
        System.out.println();
        array.showMultidimensionalArray();
    }
}

