package com.ddc.projects.java8.basic;

public class StringDemo {
    public static void main(String[] args) {
//		String a=new String("         asa   asas          ");
//		StringBuffer as=new StringBuffer("ffdfdsfdfsfdsfs");
//
//		int aa=a.length();
//		int bb=as.length();
//		System.out.println(aa+"/"+bb);
        /*
         * 1970-------方法调用之前距离1970年的毫秒数start
         * 方法调用之后距离1970年的毫秒数end
         * end-start就是我们做这件事情耗费时间（单位是毫秒）
         *
         * 如果一个表达式中包含有我们的String类型的数据（""+1），
         * 同时使用了“+”进行拼接我们的其他简单数值型数据类型的数据，
         * 会自动把这些内容转换成String类型
         */
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 30000; i++) {
            s = s + i;
        }
        //012345689
        System.out.println(System.currentTimeMillis() - start);
        System.out.println("___________________________________");
        //字符串相加方法二：
        long start2 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 30000; i++) {
            sb.append(i);
        }
        System.out.println(System.currentTimeMillis() - start2);
    }
}

