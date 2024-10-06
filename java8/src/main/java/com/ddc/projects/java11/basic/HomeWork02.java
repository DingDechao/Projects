package com.ddc.projects.java11.basic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HomeWork02 {
    //	2在一个目录下创建一个文本文件,并向文件里写入当前的创建时间,要求文件名的格式为yyyyMMddhhmmssSSS.txt
    public static void main(String[] args) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
            Date date = new Date();
            String str = sdf.format(date);
            OutputStream out = new FileOutputStream("E:/" + str + ".txt");
            out.write(str.getBytes());
            out.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
