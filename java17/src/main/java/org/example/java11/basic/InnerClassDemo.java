package org.example.java11.basic;

/*
    在一个原文件中，并列的几个类中只允许出现一个public修饰的class，且我们的文件名与之一致。
*/
public class InnerClassDemo {
    public static String name;
    interface Test2 {
    }

    abstract class test3 {
    }
    /*
     * ，定义在方法中的内部类不能访问方法中的局部变量，但是能够访问方法中常量和类中的属性
     */

    public void aa() {
        String sex = "男";
        final int AGE = 20;
        class B {
            public void cc() {
                System.out.println(AGE);
            }
        }
    }

    class Test {
        //			static String aa;
        public void run() {
            name = "zhangsan";
        }
    }

    public void zz() {
//			static class q{
//
//			}
    }


    public static void main(String[] args) {
//		public String ss="lisi";
        //非静态
//		InnerClassDemo.Test it=  new InnerClassDemo().new Test();
//		InnerClassDemo.Test it=  new InnerClassDemo.Test();
//		it.run();
    }
}

//public class C{
//
//
//}
