package com.ddc.projects.java8.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipDemo1 {

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
            out.putNextEntry(new ZipEntry("a/001.mp3"));

            byte[] buff = new byte[1024];
            int len = -1;
            while ((len = in.read(buff)) != -1) {
                out.write(buff, 0, len);
            }
            out.closeEntry();
            FileInputStream in2 = new FileInputStream("E:/c/001.JPG");
            out.putNextEntry(new ZipEntry("b/c/c/c/d/f/001.JPG"));
            while ((len = in2.read(buff)) != -1) {
                out.write(buff, 0, len);
            }

            //新建空文件条目，即压缩空文件夹
            out.putNextEntry(new ZipEntry("d/aa/"));

            FileInputStream in3 = new FileInputStream("E:/aa/test.txt");
            out.putNextEntry(new ZipEntry("b/c/c/c/d/f/test.txt"));
            while ((len = in3.read(buff)) != -1) {
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
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

