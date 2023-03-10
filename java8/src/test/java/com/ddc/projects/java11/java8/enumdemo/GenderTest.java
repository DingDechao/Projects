package com.ddc.projects.java11.java8.enumdemo;

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