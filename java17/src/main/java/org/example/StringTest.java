package org.example;

public class StringTest {
    public static void main(String[] args) {
        var stringTest = "a \n"
                + "b \n";
        System.out.println("stringTest : " + stringTest);

        var stringTestWithJDK17 = """
                        a
                        b
                        """;
        System.out.println("stringTestWithJDK17 : " + stringTestWithJDK17);
    }
}