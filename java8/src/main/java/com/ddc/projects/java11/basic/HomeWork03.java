package com.ddc.projects.java11.basic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class HomeWork03 {
    //	3将一个99乘法表输出到文件中。
    public static String display() {
        String s = "";
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                s += (i + "*" + j + "=" + i * j + "\t");
            }
            s += "\r\n";
        }
        return s;
    }

    public static void main(String[] arg) {
        String str = display();
        File file = new File("E:/jiujiu.txt");
        try {
            file.createNewFile();
            OutputStream out = new FileOutputStream("E:/jiujiu.txt");
            out.write(str.getBytes());
            out.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
