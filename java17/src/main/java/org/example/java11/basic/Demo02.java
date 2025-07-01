//package org.example.java11.basic;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Demo02 {
//
//    public static ArrayList<Integer> show() {
//        ArrayList<Integer> b = new ArrayList<Integer>();
//        System.out.print("请输入n的值：");
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        int a = Integer.parseInt(str);
//        for (int i = 0; i < a; i++) {
//            b.add(new Integer(i));
//        }
//        int j = 1;
//        Object k;
//        while (b.size() > 1) {
//            for (int i = 0; i < b.size(); i++) {
//                if (j % 3 == 0) {
//                    k = b.remove(i);
//                    i -= 1;
//                }
//                j++;
//            }
//        }
//        return b;
//    }
//
//    public static void main(String[] args) {
//        System.out.println();
//        System.out.println(show());
//    }
//}
//
