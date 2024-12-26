package com.ddc.projects.java11.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class BookReader {

    public void write() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("E:/aa/test.txt")));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("E:/qw1.txt"));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                char[] charArray = line.toCharArray();
                for (int i = 0; i < charArray.length; i++) {
                    int number = charArray[i];
                    String str = Integer.toHexString(number);
                    bufferedWriter.write(str + " ");
                    System.out.println(str);
                }
            }
            bufferedWriter.flush();
            bufferedReader.close();
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read() {
        try {
            InputStreamReader inputStreamReader = new FileReader("E:/qw1.txt");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = "";
            while ((str = bufferedReader.readLine()) != null) {
                String[] s = str.split(" ");
                for (int i = 0; i < s.length; i++) {
                    int ii = Integer.parseInt(s[i], 16);
                    System.out.print((char) ii);
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BookReader brd = new BookReader();
        brd.write();
        brd.read();
    }
}

