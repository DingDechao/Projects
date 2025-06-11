package org.example.java11.filedemo;

import java.io.File;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) throws IOException {
        // Create File object based on current path
        var file = new File(".");
        // Print .
        System.out.println(file.getName());
        // Print null
        System.out.println(file.getParent());
        // Print absolute path /Users/xxx/Projects/JavaProject/Projects/.
        System.out.println(file.getAbsoluteFile());
        // Print last path /Users/xxx/Projects/JavaProject/Projects
        System.out.println(file.getAbsoluteFile().getParent());
        // Create temp file in current path
        File tempFile = File.createTempFile("aaa", ".txt", file);
        // Delete temp file while JVM exit
        tempFile.deleteOnExit();
        // Create new file based on current time
        File timeFile = new File(System.currentTimeMillis() + "");
        System.out.println("timeFile is existed or not : " + timeFile.exists());
        // Create new file
        timeFile.createNewFile();
        // Create new folder, as this is a file so can not create folder
        boolean createOrNot = timeFile.mkdir();
        System.out.println(createOrNot);

        // List all files and folders
        String[] fileList = file.list();
        System.out.println("--------------------");
        for (var fileName : fileList) {
            System.out.println(fileName);
        }

        // List root path
        File[] files = File.listRoots();
        System.out.println("--------------------");
        for (var f : files) {
            System.out.println(f);
        }
    }
}
