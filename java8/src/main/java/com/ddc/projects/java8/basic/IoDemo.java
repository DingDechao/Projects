package com.ddc.projects.java8.basic;

import java.util.Scanner;

public class IoDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//		InputStream is=new InputStream();
        String src = "";
        System.out.println("请输入你要输出的内容：");
//		src=sc.nextLine();
        src = sc.next();
        System.out.println("打印：" + src);
//		src=sc.next();
        int a = sc.nextInt();
        System.out.println("打印2：" + a);
        sc.nextLine();
        src = sc.nextLine();
        System.out.println("打印3:" + src);
        /*
         * nextxx()获取的使我们两个分隔符之间的内容，并且不会换行，执行结束，光标停留在内和结束分隔符之间；
         * 如果此时直接后面接着执行nextLine()，系统会认为我们的nextLine执行结束，直接换行，所以此时nextLine()
         * 获取的内容为空。但是如果此事后面接着执行的不是nextLine90而是nextxx，他会以第一次结尾的分隔符为下一个标记的
         * 开始，直至本次输入达到行尾给他一个结束符，获取的是两个分隔符之间的内容。
         */
    }
}
