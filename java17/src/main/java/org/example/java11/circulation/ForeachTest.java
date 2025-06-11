package org.example.java11.circulation;

public class ForeachTest {

    public static void main(String[] args) {
        var stringArray = new String[] {"aaa", "bbb", "ccc"};
        for (var string : stringArray) {
            string = "ddd";
            System.out.println(string);
        }
        System.out.println(stringArray[0]);
    }
}
