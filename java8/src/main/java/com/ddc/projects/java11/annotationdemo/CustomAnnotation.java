package com.ddc.projects.java11.annotationdemo;

public @interface CustomAnnotation {

    String name() default "abc";

    int age() default 12;
}
