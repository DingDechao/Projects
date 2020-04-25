package com.ddc.projects.java8.basic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Demo {
    public static void main(String[] args) {
        String zippath = "E:/aa.zip";
        try {
            ZipFile zf = new ZipFile(zippath);
            int size = zf.size();
            System.out.println(size);
            String path = zf.getName();
            System.out.println(path);
            String[] parentpath = zippath.split(".zip");
            System.out.println(parentpath.length + "////////////////////" + parentpath[0]);
            File f = new File(parentpath[0]);
            f.mkdirs();
            Enumeration er = zf.entries();
            while (er.hasMoreElements()) {
                ZipEntry ze = (ZipEntry) er.nextElement();
                System.out.println(ze.getName() + ze.isDirectory() + ze.getMethod());
                int endindex = ze.getName().lastIndexOf("/");
                if (endindex > 0) {
                    String top = ze.getName().substring(0, endindex);
                    System.out.println(top + "...");
                    System.out.println(parentpath[0] + "/" + top);
                    File file2 = new File(parentpath[0] + "/" + top);
                    file2.mkdirs();
                }
                InputStream is = zf.getInputStream(ze);
                System.out.println("【" + parentpath[0] + "/" + ze.getName() + "】");
                if (!ze.isDirectory()) {
                    OutputStream os = new FileOutputStream(parentpath[0] + "/" + ze.getName());
                    //E:/001/001.mp3
                    int len = -1;
                    while ((len = is.read()) != -1) {
                        os.write(len);
                    }
                    os.flush();
                    is.close();
                    os.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

