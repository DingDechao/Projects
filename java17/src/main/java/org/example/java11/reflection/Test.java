//package org.example.java11.reflection;
//
//import java.lang.reflect.Constructor;
//import java.lang.reflect.Field;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//
//
//public class Test {
//    public static void main(String[] args) {
//        try {
//            //Students stu = new Students();
//           // Class c1 = stu.getClass();
//            //Class c2 = new Students().getClass();
//            //提供类所在包的地址通过class类返回该对象的一个类的描述
//            Class c3 = Class.forName("org.example.java11.basic.Students");
//
////			System.out.println(stu);
////			System.out.println(c1);
////			System.out.println(c2);
////			System.out.println(c3);
////			System.out.println("-----------------------------------------------");
////			//通过getConstructors方法返回当前类中所有公共构造器的一个数组
////			Constructor[] ct=c3.getConstructors();
////			for (int i = 0; i < ct.length; i++) {
////				System.out.println(ct[i].getName());
////			}
////			System.out.println("----------------------------------------------------");
////			//通过getDeclaredFields方法返回当前类中的所有属性
////			Field[] fs=c3.getDeclaredFields();
////			for (int i = 0; i < fs.length; i++) {
////				System.out.println(fs[i].getName());
////			}
////			System.out.println("-------------------------------------------------");
//            //通过getMethods方法获取到当前类中的所有方法以及所有相关父接口和父类中的所有公共方法
//            Method[] m = c3.getMethods();
//            for (int i = 0; i < m.length; i++) {
//                //getDeclaringClass方法返回该方法所在的类
//                Class c4 = m[i].getDeclaringClass();
//                System.out.println(m[i].getName() + "/" + c4.getName());
////				System.out.println("-----------------------------------------------");
////				Object o=m[i].getDefaultValue();
////				System.out.println(o);
////				int a=m[i].getModifiers();
////				System.out.println(a);
//            }
//            //有一个参数传递，无返回参数的方法调用
//            Object oo2 = m[3].invoke(c3.newInstance(), "haha");
//            System.out.println(m[3].getName() + ":" + oo2);
//            //无参数传递有返回参数的方法调用
//            Object oo = m[2].invoke(c3.newInstance(), null);
//            System.out.println(m[2].getName() + ":" + oo);
//            //有多个参数传递，无返回参数的方法调用
//            //参数列表数组
//            Object[] oj = {"haha", 122222};
//            Object oo3 = m[6].invoke(c3.newInstance(), oj);
//            System.out.println(m[6].getName() + ":" + oo3);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SecurityException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
