package com.ddc.projects.java11.Lambda;

public class MethodRefer {

    public static void main(String[] args) {
        Converter converter1 = form -> Integer.parseInt(form);
        System.out.println(converter1.convert("123"));

        // Use method refer instead of lambda expression, below code is same as above
        // The all parameters will pass to below static method
        Converter converter2 = Integer::parseInt;
        System.out.println(converter2.convert("123"));

        Converter converter3 = from -> "Hello".indexOf(from);
        System.out.println(converter3.convert("2"));

        // Use method refer instead of lambda expression, below code is same as above
        // The all parameters will pass to below String's instant method
        Converter converter4 = "Hello"::indexOf;
        System.out.println(converter4.convert("2"));

        MyTest myTest1 = (a, b, c) -> a.substring(b, c);
        System.out.println(myTest1.test("Hello", 1, 2));


        // Use method refer instead of lambda expression, below code is same as above
        // The first parameter will set as invoker, other will pass to the method
        MyTest myTest2 = String::substring;
        System.out.println(myTest2.test("Hello", 1, 2));

        NewInstance newInstance1 = (name, age) -> new Person(name, age);
        System.out.println(newInstance1.create("hello", "100").getName());


        // Use constructor refer instead of lambda expression, below code is same as above
        // parameters need to match constructor
        NewInstance newInstance2 = Person::new;
        System.out.println(newInstance1.create("hello", "100").getName());

    }
}

@FunctionalInterface
interface Converter {
    Integer convert(String from);
}

@FunctionalInterface
interface MyTest {
    String test(String s, int a, int b);
}

@FunctionalInterface
interface NewInstance {
    Person create(String name, String age);

}

class Person {
    private String name;
    public Person() {};
    public Person(String name, String age) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}