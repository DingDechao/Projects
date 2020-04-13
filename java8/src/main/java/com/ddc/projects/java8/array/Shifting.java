package com.ddc.projects.java8.array;

public class Shifting {

    /**
     * 遍历指定数值的值
     *
     * @param arr
     */
    public void bianLi(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 对给定数组中的元素进行移位
     *
     * @param arr
     */
    /*
     * 如果一个数组需要移位，现在假定他有十个元素，试问至少需要多少个空间？
     * 因为数组长度一旦定义就无法改变，所以我们只有十个空间能够使用
     * 我们可以定义一个temp变量临时存放数组中的一个元素，一般习惯存放的是第一个下标为0的元素
     */
    public void move(int[] arr) {
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = temp;
    }


    public static void main(String[] args) {
        Shifting p = new Shifting();

        int[] a = {1, 2, 3, 4, 5, 6};
        p.bianLi(a);
        p.move(a);
        p.bianLi(a);
    }
}
