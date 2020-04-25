package com.ddc.projects.java8.basic;

import java.io.*;

public class CatchException {
    public static void main(String[] args) {
        FileInputStream fis;
        try {
            fis = new FileInputStream("c:/a.txt");
            int b = fis.read();
            while (b != -1) {
                System.out.print((char) b);
                b = fis.read();
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
