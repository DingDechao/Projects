package com.ddc.projects.java8.enumdemo;

import static org.junit.Assert.*;

public class GenderTest {

    public void testEnumAsParameter(Gender gender){
        System.out.println(gender.name());
    }

    public void testInvokeMethodTestEnumAsParameter() {
        testEnumAsParameter(null);
    }

    public static void main(String[] args) {
        GenderTest genderTest = new GenderTest();
        genderTest.testInvokeMethodTestEnumAsParameter();
    }

}