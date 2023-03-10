package com.ddc.projects.java11.java8.annotationdemo;

import java.util.ArrayList;
import java.util.List;

public class Apple extends Fruit {

    @Override
    public void info() {
        System.out.println("This is Apple's info() method");
    }


/*    @Override
    //Method does not override method from its superclass
    public void inf() {
        System.out.println("This is Apple's info method");
    }*/

    @Deprecated
    public void getPlaceOfOrigin() {
        System.out.println("This is Apple's getPlaceOfOrigin() method");
    }

    @SuppressWarnings(value = "unchecked")
    public void getAllColor() {
        //Unchecked assignment: 'java.util.ArrayList' to 'java.util.List<java.lang.String>'
        List<String> colors = new ArrayList();
    }

    public static void main(String[] args) {
        new Apple().getPlaceOfOrigin();
    }

}
