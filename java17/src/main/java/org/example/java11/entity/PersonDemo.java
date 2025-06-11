package org.example.java11.entity;

public class PersonDemo {
    public String name;
    public String gender;
    public int age;
    public String nationality;

    public PersonDemo() {
    }

    public PersonDemo(int age) {
        System.out.println("我是person类中的有参构造器");
    }

    public void run() {
        System.out.println("跑的好累!");
    }

    public void sleep() {
        System.out.println("这个气温睡觉真舒服！");
    }
}

