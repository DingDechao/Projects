package org.example.interfacetest;

public interface InterfaceTest {

    int MAX_SIZE = 50;
//    interface will add public static final by default
//    public static final int MAX_SIZE = 50;

    void test();
//    interface will add public abstract by default
//    public abstract void test();

//    default method
    default void print(String... msgs) {
        for (var msg : msgs) {
            System.out.println(msg);
        }
    }
//    static method
    static String staticMethod() {
        return "Helios World";
    }

//    private method
    private void privateMethod() {
        System.out.println("Interface -> private method");
    }
//    private static method
    private static void privateStaticMethod() {
        System.out.println("Interface -> private static mehtod");
    }
}
