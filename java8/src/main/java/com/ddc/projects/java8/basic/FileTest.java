package com.ddc.projects.java8.basic;

import java.io.File;

public class FileTest {

    //	public static void deletefile(File file){
//		if(file.isFile()){
//			file.delete();
//		}else{
//			File[] files=file.listFiles();
//			for (int i = 0; i < files.length; i++) {
//				deletefile(files[i]);
//			}
//		}
//	}
    public static void deletefiles(File file) {
        while (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                file.delete();
            } else {
                for (int i = 0; i < files.length; i++) {
                    deletefiles(files[i]);
                }
            }
        }
        if (file.isFile()) {
            file.delete();
        }
    }

    public static void main(String[] args) {
        File file = new File("E:/aa");
        deletefiles(file);
    }
}
