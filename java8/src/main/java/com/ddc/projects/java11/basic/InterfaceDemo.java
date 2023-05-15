package com.ddc.projects.java11.basic;

/*
 * 接口中不能存在变量,可以包含常量。
 * 接口中只存在未被实现的方法，即我们的抽象方法。
 *
 * 接口派生出子类。子类使用的再不是extends关键字来继承了，
 * 接口使用implements关键字，实现接口
 *
 * 抽象类也可以实现（使用关键字implements）接口，
 * 但是反过来，接口既不能实现也不能继承抽象类。
 *
 * 接口和接口之间的关系是继承（extends），而不是实现（implements）！
 *
 */

public interface InterfaceDemo {
    //在接口中，如果定义了“变量”（是必须要给定初值的）那么系统会默认给他final和static修饰
//	public  String name="百度";
    //==>>
    public final String NAME = "百度";
    public void run();
//	public void sleep(){
//	}

}
