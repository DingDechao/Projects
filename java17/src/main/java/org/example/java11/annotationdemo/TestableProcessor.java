package org.example.java11.annotationdemo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestableProcessor {

    public static void process(String clazz) throws ClassNotFoundException{
        for (Method method : Class.forName(clazz).getMethods()) {
            if (method.isAnnotationPresent(Testable.class)) {
                try {
                    method.invoke(null);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        TestableProcessor.process("com.ddc.projects.java8.annotationdemo.TestAnnotationTestable");
    }
}
