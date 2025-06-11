package org.example.java11.javabasicclass;

import java.util.Objects;

public class ObjectsDemo {

    static ObjectsDemo objectsDemo;

    public static void main(String[] args) {
        System.out.println(Objects.hashCode(objectsDemo));
        System.out.println(Objects.toString(objectsDemo));
        Objects.requireNonNull(objectsDemo);
    }
}
