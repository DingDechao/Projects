package com.ddc.projects.java11.reflection;

import java.lang.reflect.Modifier;

public class ModifierDemo {
    public static void main(String[] args) {
        Modifier m = new Modifier();
        System.out.println(m.PUBLIC);
        System.out.println(m.STATIC);
        System.out.println(m.ABSTRACT);
        System.out.println(m.FINAL);
        System.out.println(m.NATIVE + "----------");
        System.out.println(m.PROTECTED);
        System.out.println(m.TRANSIENT);
        System.out.println(m.INTERFACE);
        System.out.println(m.PRIVATE);
        System.out.println(m.STRICT);
        System.out.println(m.TRANSIENT);
        System.out.println(m.VOLATILE);
    }
}

