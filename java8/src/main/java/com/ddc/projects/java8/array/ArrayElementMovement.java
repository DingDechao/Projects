package com.ddc.projects.java8.array;

public class ArrayElementMovement {

    public void iteration(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 对给定数组中的元素进行移位
     *
     * @param array
     */
    /*
     * 如果一个数组需要移位，现在假定他有十个元素，试问至少需要多少个空间？
     * 因为数组长度一旦定义就无法改变，所以我们只有十个空间能够使用
     * 我们可以定义一个temp变量临时存放数组中的一个元素，一般习惯存放的是第一个下标为0的元素
     */
    public void move(int[] array) {
        int temp = array[0];
        for (int i = 1; i < array.length; i++) {
            array[i - 1] = array[i];
        }
        array[array.length - 1] = temp;
    }

    public static void main(String[] args) {
        ArrayElementMovement arrayElementMovement = new ArrayElementMovement();
        int[] numberArray = {1, 2, 3, 4, 5, 6};
        arrayElementMovement.iteration(numberArray);
        arrayElementMovement.move(numberArray);
        arrayElementMovement.iteration(numberArray);
/*
        1 2 3 4 5 6
        2 3 4 5 6 1
*/
    }
}

