package com.ddc.projects.java8.basic;

public class ExceptionDemo extends ArithmeticException {

    public ExceptionDemo() {
        super();
    }

    public ExceptionDemo(String msg) {
        super(msg);
    }

    public String toString() {
        return "除数怎么可以为0呢，你小学数学是体育老师教的吧！";
    }

    public static void main(String[] args) {
        ExceptionDemo ed = new ExceptionDemo();
        System.out.println(ed);
    }
}
