package org.example.java11.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Scanner;

public class Program {
    //	文件系统
    String path = "E:/user.properties";
    String flag = "";

    public void showUserinfo(String path) {
        System.out.println("请输入你要查看用户的用户名：");
        Properties ppt = new Properties();
        try {
            FileInputStream fis = new FileInputStream(path);
            ppt.load(fis);
            Scanner sc = new Scanner(System.in);
            flag = sc.nextLine();
            if (null != ppt.getProperty(flag)) {
                System.out.println("请输入密码：");
                String pass = "";
                pass = sc.nextLine();
                if (pass.equals(ppt.getProperty(flag))) {
                    System.out.println("登陆成功，以下为用户信息：");
                    if (flag.equals("admin")) {
                        Enumeration er = ppt.propertyNames();
                        while (er.hasMoreElements()) {
                            String key = (String) er.nextElement();
                            String value = ppt.getProperty(key);
                            System.out.println("用户名：" + key + "\t" + "密码：" + value);
                        }
                    } else {
                        System.out.println("用户名：" + flag + "\t" + "密码：" + ppt.getProperty(flag));
                    }
                } else {
                    System.out.println("密码错误，请重新输入：");
                    Program b = new Program();
                    b.showUserinfo(path);
                }
            } else {
                System.out.println("找不到你要找的用户，请重新输入：");
                Program b = new Program();
                b.showUserinfo(path);
            }
            Program a = new Program();
            a.choice(a);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void midifyUsermsg(String path) {
        Properties ppt = new Properties();
        String name = "";
        String pass = "";
        try {
            FileInputStream fis = new FileInputStream(path);
            ppt.load(fis);
            FileOutputStream fos = new FileOutputStream(path);
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入用户名：");
            name = sc.nextLine();
            if (name.equals("admin")) {
                Enumeration er = ppt.propertyNames();
                while (er.hasMoreElements()) {
                    String key = (String) er.nextElement();
                    String value = ppt.getProperty(key);
                    System.out.println("用户名：" + key + "\t" + "密码" + value);
                    Program a = new Program();
                    a.choice(a);
                }
            } else {
                System.out.println("请输入你修改后的密码：");
                pass = sc.nextLine();
                ppt.put(name, pass);
                ppt.store(fos, "用户列表");
                System.out.println("密码修改成功！");
                Program a = new Program();
                a.choice(a);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void register(String path) {
        Properties ppt = new Properties();
        String name = "";
        String pass = "";
        try {
            FileInputStream fis = new FileInputStream(path);
            ppt.load(fis);
            System.out.println("欢迎注册新用户，请输入账户名：");
            Scanner sc = new Scanner(System.in);
            name = sc.nextLine();
            while (null != (ppt.getProperty(name))) {
                System.out.println("该用户已经被注册，请重新输入：");
                name = sc.nextLine();
            }
            System.out.println("恭喜你，此账户可以注册，请输入密码：");
            pass = sc.nextLine();
            System.out.println("注册成功");
            FileOutputStream fig = new FileOutputStream(path);
            ppt.put(name, pass);
            ppt.store(fig, "用户列表");
            Program a = new Program();
            a.choice(a);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void choice(Program user) {
        System.out.println("欢迎进入系统，请选择你要的操作，'1'显示用户列表；'2'修改密码；'3'注册新用户");
        Scanner sc = new Scanner(System.in);
        flag = sc.nextLine();
        Program use = user;
        if ("1".equals(flag)) {
            use.showUserinfo(path);
        } else if ("2".equals(flag)) {
            user.midifyUsermsg(path);
        } else if ("3".equals(flag)) {
            user.register(path);
        } else {
            System.out.println("你输入的数据有误，请重新输入！");
            use.choice(use);
        }
    }

    public static void main(String[] args) {
        Program user = new Program();
        user.choice(user);
    }
}

