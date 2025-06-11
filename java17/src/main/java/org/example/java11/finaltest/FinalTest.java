package org.example.java11.finaltest;

public class FinalTest {

    final int a;

    public FinalTest() {
        // Allow method to access the final variable before setup value for this variable
        // Maybe this a JAVA defect
        test();
        a = 100;
        System.out.println(a);
    }

    public void test () {
        System.out.println(a);
    }

    public static void main(String[] args) {
        new FinalTest();
    }
}
