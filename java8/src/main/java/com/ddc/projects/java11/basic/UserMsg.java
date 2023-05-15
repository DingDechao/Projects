package com.ddc.projects.java11.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Scanner;

public class UserMsg {
    Properties ppt = new Properties();

    public boolean login(String name, String pass, String path) {
        boolean flag = false;
        try {
            FileInputStream fis = new FileInputStream(path);
            ppt.load(fis);
            String userpass = ppt.getProperty(name);
            flag = pass.equals(userpass);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public void showUserMsg(String name, String path) {
        System.out.println("所有用户信息列表如下：");
        try {
            FileInputStream fis = new FileInputStream(path);
            ppt.load(fis);
            if ("admin".equals(name)) {
                Enumeration<?> er = ppt.propertyNames();
                while (er.hasMoreElements()) {
                    String key = (String) er.nextElement();
                    String value = ppt.getProperty(key);
                    System.out.println("用户名：" + key + "\t" + "密码：" + value);
                }
            } else {
                String value = ppt.getProperty(name);
                System.out.println("用户名：" + name + "\t" + "密码：" + value);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adminMidifyUsermsg(String path) {
        String name = "";
        String pass = "";
        try {
            FileInputStream fis = new FileInputStream(path);
            ppt.load(fis);
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入你要修改的用户名：");
            name = sc.nextLine();
            System.out.println("请输入你修改后的密码：");
            pass = sc.nextLine();
            FileOutputStream fos = new FileOutputStream(path);
            ppt.put(name, pass);
            ppt.store(fos, "welcome");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void midifyUsermsg(String name, String path) {
        String pass = "";
        try {
            FileInputStream fis = new FileInputStream(path);
            ppt.load(fis);
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入你修改后的新密码：");
            pass = sc.nextLine();
            FileOutputStream fos = new FileOutputStream(path);
            ppt.put(name, pass);
            ppt.store(fos, "welcome");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean regist(String name, String path) {
        boolean flag = false;
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入你要设置的密码：");
            String pass1 = sc.nextLine();
            System.out.println("请再次输入确定密码：");
            String pass2 = sc.nextLine();
            if ("".equals(pass1) || "".equals(pass2)) {
                System.out.println("密码和确认密码不能为空!!!请重新操作！");
                regist(name, path);
            } else {
                if (pass1.equals(pass2)) {
                    FileOutputStream fos = new FileOutputStream(path);
                    ppt.put(name, pass1);
                    ppt.store(fos, "welcome");
                    System.out.println("注册成功，请登录");
                    flag = true;
                } else {
                    System.out.println("两次密码不一致，请重新操作");
                    regist(name, path);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean isin(String name, String path) {
        boolean b = false;
        try {
            FileInputStream fis = new FileInputStream(path);
            ppt.load(fis);
            String userpass = ppt.getProperty(name);
            if (userpass != null) {
                b = true;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }

    public void mainWindows() {
        Scanner sc = new Scanner(System.in);
        String path = "E:/user.properties";
        String name = "";
        boolean islogin = false;

        System.out.println("+------------------------------------------------------------------------+");
        System.out.println("|************************************************************************|");
        System.out.println("|***********************欢迎使用XX系统，请先登录系统**************************|");
        System.out.println("|**********************没有账号直接输入需要注册的用户名************************|");
        System.out.println("|************************************************************************|");
        System.out.println("+------------------------------------------------------------------------+");
        System.out.println("请输入用户名：");
        name = sc.nextLine();
        if (isin(name, path)) {
            System.out.println("请输入密码：");
            String pass = sc.nextLine();
            islogin = login(name, pass, path);
            if (islogin) {
                showMainWindows(name, path);
            } else {
                System.out.println("密码错误！");
                mainWindows();
            }
        } else {
            System.out.println("该用户名不存在，开始快速注册！");
            regist(name, path);
            mainWindows();
        }
    }

    public void showMainWindows(String name, String path) {
        String flag = "";
        Scanner sc = new Scanner(System.in);
        //____________________________________________________________________________
        System.out.println("+------------------------------------------------------------------------+");
        System.out.println("|************************************************************************|");
        System.out.println("|******************欢迎进入XX系统，请输入你需要进行的操作：*********************|");
        System.out.println("|****************1.查看信息 2.修改信息 【输入其他退出系统!!!】******************|");
        System.out.println("|************************************************************************|");
        System.out.println("+------------------------------------------------------------------------+");
        //____________________________________________________________________________
        flag = sc.nextLine();
        if ("1".equals(flag)) {
            showUserMsg(name, path);
            showMainWindows(name, path);
        } else if ("2".equals(flag)) {
            if ("admin".equals(name)) {
                adminMidifyUsermsg(path);
                showMainWindows(name, path);
            } else {
                midifyUsermsg(name, path);
                showMainWindows(name, path);
            }
        } else {
            System.out.println("系统已成功退出！！！");
        }
    }

    public static void main(String[] args) {
//		System.exit(0);
        UserMsg user = new UserMsg();
        user.mainWindows();
    }
}
