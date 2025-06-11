package org.example.java11.properties;

public class SystemProperties {
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("java.vendor"));
        System.out.println(System.getProperty("java.vendor.url"));
        System.out.println(System.getProperty("java.class.version"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("os.arch"));
        System.out.println(System.getProperty("file.separator"));
        System.out.println(System.getProperty("path.separator"));
        System.out.println(System.getProperty("line.separator"));
        System.out.println(System.getProperty("java.specification.version"));
        System.out.println(System.getProperty("java.vm.specification.version"));
        System.out.println(System.getProperty("java.vm.specification.vendor"));
        System.out.println(System.getProperty("java.vm.specification.name"));
        System.out.println(System.getProperty("java.vm.version"));
        System.out.println(System.getProperty("java.vm.vendor"));
        System.out.println(System.getProperty("java.vm.name"));
    }

    /**
     1.8.0_131
     Oracle Corporation
     http://java.oracle.com/
     52.0
     Mac OS X
     10.12.6
     x86_64
     /
     :


     1.8
     1.8
     Oracle Corporation
     Java Virtual Machine Specification
     25.131-b11
     Oracle Corporation
     Java HotSpot(TM) 64-Bit Server VM
     */
}
