package com.ddc.projects.java11.basic;

import java.io.File;

public class FileDemo {

    public static void main(String[] args) {
//        String path = new Test().path;
//        File file = new File(path);
        //删除该文件指代的文件对象
//		boolean b=file.delete();
        //该文件对象是否存在
//		boolean b=file.exists();
        //获取当前文件的父路径
//		String b=file.getParent();
        //是否隐藏
//		boolean b=file.isHidden();
        //最后修改时间
//		long b=file.lastModified();
        //获取文件的长度（字节数）
//		long b=file.length();
//		System.out.println(b);

        //获得当前路径下的所有文件的文件名，返回的是一个String[]
//		String[] name=file.list();
//
//		for (int i = 0; i < name.length; i++) {
//			File file2=new File(path+"/"+name[i]);
//
//			boolean b=file2.isHidden();
//
//			System.out.println(name[i]+"/"+b);
//		}

//		这里获取的是具体的每一个文件对象
//		File[] files=file.listFiles();
//
//		for (int i = 0; i < files.length; i++) {
//			String name=files[i].getName();
//			boolean b=files[i].isHidden();
//
//			System.out.println(name+"/"+b);
//		}

//		获取的是电脑系统中可用的磁盘的盘符
//		File[] files=file.listRoots();
//
//		for (int i = 0; i < files.length; i++) {
////			String name=files[i].getName();
////			boolean b=files[i].isHidden();
//
//			System.out.println(files[i]);
//		}

        //这两种创建只能创建目录而不能直接创建文件
        //mkdir只能创建单层的目录
//		boolean b=file.mkdir();
        //mkdirs可以创建包括有父目录的文件目录
//		boolean b=file.mkdirs();
//		System.out.println(b);

//		File file2=new File("E:/aa/aaa/bb.txt");
//
//		//如果要给指定文件重命名，需要传递一个file对象，
//		//该对象创建过程中传递的path是与我们需要重命名的
//		//文件所在的路径一致，后面接上我们需要命名的新名字.后缀
//		boolean b=file.renameTo(file2);
//
//		System.out.println(b);

//		boolean b=file.setReadOnly();

//		file.toURI();
//        System.out.println(file.toURI());
    }
}

