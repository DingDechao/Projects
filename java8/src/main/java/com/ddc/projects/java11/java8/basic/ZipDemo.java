package com.ddc.projects.java11.java8.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipDemo {

    public static void dozip(FileInputStream in, String path) {
        try {
            File file = new File(path);
            String name = file.getName();
            System.out.println(name);
            int index = name.indexOf(".");
            System.out.println(index);
            String zipname = name.substring(0, index);
            System.out.println(zipname);
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream("E:/" + zipname + ".zip"));
            out.putNextEntry(new ZipEntry("001.mp3"));
            byte[] buff = new byte[1024];
            int len = -1;
            while ((len = in.read(buff)) != -1) {
                out.write(buff, 0, len);
            }
            out.closeEntry();
            FileInputStream in2 = new FileInputStream("E:/c/001.JPG");
            out.putNextEntry(new ZipEntry("001.JPG"));
            while ((len = in2.read(buff)) != -1) {
                out.write(buff, 0, len);
            }
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String path = "E:/c/001.mp3";
        try {
            FileInputStream in = new FileInputStream(path);
            dozip(in, path);
//			path="E:/c/001.JPG";
//			dozip(in,path);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

