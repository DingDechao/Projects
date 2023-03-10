package com.ddc.projects.java11.java8.basic;

public class StringDemo1 {

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
//		Boolean bl2 = ed == ed2;
//		System.out.println(bl2);
        String a = new String("abc");
        String b = a;

        a = new String("123");
        System.out.println(b);
        /*
         * 当我们使用new关键字创建好一个String对象后，执行String a=new String("abc")之后，会在堆中创建一块内存空间存放我们的
         * “abc”对象，以内存地址来标识他存放的位置。当我们通过变量传值形式（String b=a）赋值给新的变量的时候，传递的是该对象的内存地址，
         * 且该地址给新变量后只要不改变新变量的指向，地址也不会改变。如果我们此时再去改变a的指向（a=new String("123")）改变的只是a在栈
         * 中存放的一个地址，对b没有影响。
         *
         */
    }
}

