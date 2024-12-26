package com.ddc.projects.java11.abstractdemo;

/*
 * abstract修饰的类叫做抽象类，修饰的方法叫做抽象方法，
 * 抽象方法是没有方法体（就是我们方法后面的{}）的，
 * 抽象方法只能存在在抽象类中，但是一个抽象类中是可以存在实现了的方法的。
 * 抽象类中可以完全没有抽象方法，但是这样就丧失了抽象的意义。
 *
 * 抽象方法不能定义成private（要实现该方法必须要有类继承他，
 * 然后重写实现，如果定义成了private那么该方法在子类中是无法重写的）
 *
 * 如果一个类继承了我们的一个抽象类，且里面存在未被实现的方法，要么当前类就去实现他，要么当前也成为一个抽象类
 * 抽象类中既可以包含常量，也可以包含变量。
 */
public abstract class AbstractDemo1 implements AbstractDemo3 {

    public final String URL = "www.baidu.com";

    public String name;

    public abstract void run();

    public abstract void a();

    public void print() {
    }
}
