package org.example.lambdatest;


import javax.swing.*;

public class LambdaReference {

    public static void main(String[] args) {
        Converter converter0 = from -> Integer.valueOf(from);
        var value0 = converter0.convert("99");
        System.out.println(value0);


        Converter converter1 = Integer::valueOf;
        var value1 = converter1.convert("100");
        System.out.println(value1);

        Converter converter2 = from -> "Hello World".indexOf(from);
        var value2 = converter2.convert("ld");
        System.out.println(value2);

        Converter converter3 = "Hello World"::indexOf;
        var value3 = converter3.convert("ld");
        System.out.println(value3);

        ReferenceTest referenceTest0 = (a, b, c) -> a.substring(b, c);
        var value4 = referenceTest0.test("Hello World", 1, 2);
        System.out.println(value4);

        ReferenceTest referenceTest1 = String::substring;
        var value5 = referenceTest1.test("Hello World", 1, 2);
        System.out.println(value5);

        ConstructorReferenceTest constructorReferenceTest0 = a -> new JFrame(a);
        var value6 = constructorReferenceTest0.win("Hello World");
        System.out.println(value6);

        ConstructorReferenceTest constructorReferenceTest1 = JFrame::new;
        var value7 = constructorReferenceTest1.win("Hello World");
        System.out.println(value7);
    }


}

@FunctionalInterface
interface Converter {
    Integer convert(String from);
}

@FunctionalInterface
interface ReferenceTest {
    String test(String a, int b, int c);
}

@FunctionalInterface
interface ConstructorReferenceTest {
    JFrame win(String title);
}

