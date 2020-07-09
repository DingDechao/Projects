package com.ddc.projects.java8.annotationdemo;

public @interface CustomAnnotation {

    String name() default "abc";

    int age() default 12;
}
