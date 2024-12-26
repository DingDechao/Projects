package com.ddc.projects.java11.basic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


public class zip {
    public static void main(String[] args) {
        String zippath = "E:/homework06.zip";
        try {
            ZipFile zf = new ZipFile(zippath);
            String path = zf.getName();
            System.out.println(path);
            String[] parentpath = zippath.split(".zip");
            System.out.println(parentpath.length + "/////" + parentpath[0]);
            File file = new File(parentpath[0]);
            file.createNewFile();
            Enumeration<? extends ZipEntry> er = zf.entries();
            while (er.hasMoreElements()) {
                ZipEntry ze = (ZipEntry) er.nextElement();
                System.out.println(ze.getName());
                int endindex = ze.getName().lastIndexOf("/");
                if (endindex > 0) {
                    String str = ze.getName().substring(0, endindex);
                    System.out.println(str);
                    File file2 = new File(parentpath[0] + "/" + str);
                    file2.createNewFile();
                }
                System.out.println(ze.getName());
                String s = parentpath[0] + "/" + ze.getName();
                if (s.contains(".")) {
                    InputStream is = zf.getInputStream(ze);
                    FileOutputStream os = new FileOutputStream(parentpath[0] + "/" + ze.getName());
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