package com.ddc.projects.java8.basic;

public class FinalDemo {

    /*
     * final修饰的变量名他所指代的值是一个常量，不允许被修改（final修饰的变量名字母必须全部大写）
     * final:用来修饰类、属性和方法：
     * 用final修饰类，表明这个类不能够被继承
     * 用final修饰属性，表明属性的值不能被改变
     * 用final修饰方法，表示方法不能够被重写
     */

    public final static String NAME = "zhangsan";

    public void print(int a) {
        System.out.println("我是finaldemo类中的print方法:" + a);
    }

    public final void changeValue() {
        // NAME="lisi";
    }
}
