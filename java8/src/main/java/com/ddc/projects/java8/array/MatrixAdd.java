package com.ddc.projects.java8.array;

//功能：</b><DD>多维数组演示</DD></DL>
public class MatrixAdd {
    public static void main(String args[]) {
        //我们可以把二维数组看做成一个特殊的一维数组
        //特殊在于：这个一维数组里面的元素存放的再不是我们的数值型元素而是另外一个一维数组
        //我们再定义，如果一个一维数组比较特殊，里面的元素也是一维数组，我们就把他另外取一个名字：叫做二维数组
        double[][] a = {{1, 2, 3}, {3, 4, 5}, {4, 5, 6}};
        double[][] b = {{12, 13, 14}, {23, 24, 25}, {34, 35, 36}};
        double[][] c = a;
        System.out.println("Matrix add");
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]);
                System.out.print(", ");
            }
            System.out.println();
        }
    }
}