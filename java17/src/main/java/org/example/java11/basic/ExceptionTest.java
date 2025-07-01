package org.example.java11.basic;

public class ExceptionTest {

    public static void main(String[] args) {
        try {
            int c = 0;
            int a = 10;
            int b = 0;
            if (b == 0) throw new ExceptionDemo();
            c = a / b;
            System.out.println(c);
        } catch (ExceptionDemo e) {
            System.out.println(e);
        }
    }
}
