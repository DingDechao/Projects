package com.ddc.projects.java11.java8.factory;

import com.ddc.projects.java11.java8.basic.FinalDemo;

public class TeacherFactory {
    /*
     * 如果没有使用单例模式，每调用一次newInstantance()方法都会获得一个新的实例
     */
//		  public static FinalDemo newInstance(int a){
//			    	finademo = new FinalDemo();
//			    	finademo.print(a);
//			    return finademo;
//			  }
    //如果使用的单例模式，我们不管多少次调用都只会得到同一个实例（在这里就是我们第一次创建的那个实例）。
    static FinalDemo finademo;

    public static FinalDemo newInstance(int a) {
        if (finademo == null) {
            finademo = new FinalDemo();
            finademo.print(a);
        }
        return finademo;
    }

    /*如果使用上面这种写法注意：
     * 我们的对象变量必须是全局的static（使其与我们的类相关，供其他共享该变量的属性值统一）类型的，
     * 便于方便，也要求我们的该方法(newInstance)是static类型的，
     * 在if里面判断我们当前实例是否为null，如果不为null则使用new关键字创建一个实例，并return返回当前实例，
     *如果不为null则直接return之前已经存在的实例对象，
     *这样就实现了我们单例模式所需要设计的效果了。
     *
     */
    public static void main(String[] args) {
        newInstance(1);
        newInstance(2);
        newInstance(3);
        newInstance(4);
        newInstance(5);
        newInstance(6);
    }
}