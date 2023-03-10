package com.ddc.projects.java11.java8.annotationdemo;

public @interface CustomAnnotation {

    String name() default "abc";

    int age() default 12;
}
