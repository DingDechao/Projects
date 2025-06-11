package org.example.java11.thread;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MyThread02 extends Thread {

    FileInputStream fis;
    FileOutputStream fos;

    public MyThread02(FileInputStream fis, FileOutputStream fos) {
        this.fis = fis;
        this.fos = fos;
    }

    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            PrintWriter pw = new PrintWriter(fos);
            String str = null;
            while ((str = br.readLine()) != null) {
                pw.println(str);
                pw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
