package com.ddc.projects.java8.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class HomeWork01 {

    public void write() {
//		1完成一个16进制文件阅读器.
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("E:/aa/test.txt")));
            BufferedWriter bw = new BufferedWriter(new FileWriter("E:/qw1.txt"));
            String s = "";
            while ((s = br.readLine()) != null) {
                char[] cc = s.toCharArray();
                for (int i = 0; i < cc.length; i++) {
                    int sa = cc[i];
                    String str = Integer.toHexString(sa);
                    bw.write(str + " ");
                    System.out.println(sa);
                }
            }
            bw.flush();
            br.close();
            bw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read() {

        try {
            InputStreamReader fr = new FileReader("E:/qw1.txt");
            BufferedReader br = new BufferedReader(fr);
            String str = "";
            while ((str = br.readLine()) != null) {
                String[] ss = str.split(" ");
                for (int i = 0; i < ss.length; i++) {
                    int ii = Integer.parseInt(ss[i], 16);
                    ;
                    System.out.print((char) ii);
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        HomeWork01 brd = new HomeWork01();
        brd.write();
        brd.read();
    }
}

