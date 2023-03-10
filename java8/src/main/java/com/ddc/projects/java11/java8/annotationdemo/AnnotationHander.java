package com.ddc.projects.java11.java8.annotationdemo;

import java.lang.annotation.Annotation;

public class AnnotationHander {
    public static void main(String[] args) {
        try {
            Annotation[] annotations = Class.forName("A").getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
