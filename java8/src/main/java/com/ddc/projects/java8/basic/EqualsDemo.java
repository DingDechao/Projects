package com.ddc.projects.java8.basic;

public class EqualsDemo {

    /*
     * ==和equals()的区别： 1,“==”：如果是比较两个简单数据类型，那么比较的是他们的值，
     * 如果是引用类型，那么比较的是他们所指向的对象(如果他们所指向的是同一个对象则返回true)
     * 2，equals（），直接比较的就是他们的内容（就是他们所代表的具体值）
     */
    public static void main(String[] args) {

        String s1 = "abcd";
        String s2 = "ab";
        String s3 = "cd";
        String s4 = s2 + s3;
        String s5 = new String("abcd");

//		Boolean b1=s1==s5;
//		Boolean b2=s1==s4;//==>>"abcd"?
//		Boolean b3=s1==s2;
        Boolean b1 = s1.equals(s5);
        Boolean b2 = s1.equals(s4);
        Boolean b3 = s1.equals(s2);
        System.out.println(b1 + "\t" + b2 + "\t" + b3);
        /*
         * 在String类中==比较的再不是每个变量的具体的值，而是他们的值的内存地址了，
         * 如果没有使用new关键字来创建我们的新的字符串对象，那么我们再次赋予其他变量相同的值的时候，会指向已经存在的同一个对象
         *
         */
//		EqualsDemo ed = new EqualsDemo();
//		EqualsDemo ed2 = ed;
//
//		int a = 12;
//		int b = 12;
//		Boolean bl = a == b;
//
//		Boolean bl2 = ed == ed2;
//
//		System.out.println(bl2);
    }
}

