package org.example.java11.javabasicclass;

import java.io.FileOutputStream;
import java.util.Map;
import java.util.Properties;

public class SystemAndRuntimeDemo {

    public static void main(String[] args) throws Exception {
        //Get all classpath variables
        Map<String, String> env = System.getenv();
        for (var name : env.keySet()) {
            System.out.println(name + "---->" + env.get(name));
        }

        //Get special variable from classpath
        System.out.println(System.getenv("JAVA_HOME"));

        //Get all system properties
        Properties properties = System.getProperties();
        properties.store(new FileOutputStream("properties.txt"), "System Properties");

        //Get special system property

        System.out.println("properties.getProperty(\"os.name\") ---> " + properties.getProperty("os.name"));

        var s1 = new String("Hello");
        var s2 = new String("Hello");
        System.out.println(s1.hashCode() + "----" + s2.hashCode());
        System.out.println(System.identityHashCode(s1) + "----" + System.identityHashCode(s2));

        var s3 = "JAVA";
        var s4 = "JAVA";
        System.out.println(System.identityHashCode(s3) + "----" + System.identityHashCode(s4));

        // Get java application runtime object
        var rt = Runtime.getRuntime();
        System.out.println("Process count" + rt.availableProcessors());
        System.out.println("Free memory" + rt.freeMemory());
        System.out.println("Total memory" + rt.totalMemory());
        System.out.println("Max memory" + rt.maxMemory());


    }
}
