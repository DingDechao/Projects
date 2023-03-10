package com.ddc.projects.java11.java8.basic;

public class InterfaceDemoTest implements InterfaceDemo {

    public void run() {
    }

    public static void main(String[] args) {
        InterfaceDemoTest test = new InterfaceDemoTest();
        //接口也不能通过new关键字来获取自己的对象
//		InterfaceDemo i2=new InterfaceDemo();
        //父类接口如果想要获取对象，也可以通过new 非抽象/非接口子类（子类完全实现了父类中的抽象方法。）
        //接口可以多实现（单继承多实现）
        InterfaceDemo i = new InterfaceDemoTest();
//		InterfaceDemo.name="sss";
//		i.name="sasa";
//		System.out.println(i.name);
    }
}

