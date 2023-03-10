package com.ddc.projects.java11.java8.basic;

public class OverloadDemo {

    /*
     * 构造器的重载： 构造器也可以实现重载 我们可以在构造器中实现我们不同构造器的调用，使用的使我们的this关键字来调用;
     * 使用关键字this关键字调用构造器时必须把this关键字放在该构造器方法执行之前；
     *
     * this关键字：
     *1.当我们this出现在构造器中时this就代表当前类的对象
     * 2.当this出现在方法中时this指代我们即将调用该方法的对象(只要能够调用该方法this就指代该对象)
     * 	 一般this就指代当前类的对象
     */

    public OverloadDemo() {
        this(7);
        System.out.println("我是无参构造器");
    }

    public OverloadDemo(int a) {
        // this();
        System.out.println("我是有参构造器");
    }

    /*
     * 方法的重载： 1.方法名后面()之前的内容要一致，传递参数的个数不一样； 2.传递参数的类型不一样； 3.或者这两者都不一样
     * 4.重载后方法的返回类型可以不一样
     */

    public static void main(String[] args) {
        OverloadDemo od = new OverloadDemo();
    }

    /*
     * Overload和Override的区别。Overloaded的方法是否可以改变返回值的类型?
     *
     * 方 法的重写Overriding和重载Overloading是Java多态性的不同表现
     *
     * 。重写Overriding是父类与子类之间多态性的一种表现，重 载
     *
     * Overloading是一个类中多态性的一种表现。如果在子类中定义某方法
     *
     * 与其父类有相同的名称和参数，我们说该方法被重写 (Overriding)。
     *
     * 子类的对象使用这个方法时，将调用子类中的定义，对它而言，父类
     *
     * 中的定义如同被"屏蔽"了。如果在一个类中定义了多个同名的方 法，
     *
     * 它们或有不同的参数个数或有不同的参数类型，则称为方法的重载
     *
     * (Overloading)。Overloaded的方法是可以改变返回值的类型。
     *
     *
     */
    //
    // public void print(){
    //
    // }
    //
    //
    // public void print(int a){
    //
    // }
    //
    // public void print(int a,int b){
    //
    // }
    //
    //
    // public void print(String a,String b){
    //
    // }
    //
    // public int print(String a){
    // return 0;
    // }
}

