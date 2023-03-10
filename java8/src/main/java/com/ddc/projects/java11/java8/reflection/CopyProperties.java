package com.ddc.projects.java11.java8.reflection;

import com.ddc.projects.java11.java8.basic.Students;

import java.lang.reflect.Field;

public class CopyProperties {

    public static void main(String[] args) {
        Students s1 = new Students();
        //Students2 s2 = new Students2();
        try {
            //取得对该类的一个描述
            Class cfrom = s1.getClass();
            //创建一个对象
            Object ob1 = cfrom.newInstance();
            //Class cto = s2.getClass();
            //得到该类中的属性列表
            //Field[] fs = cto.getDeclaredFields();
            //Object ob2 = cto.newInstance();
            Field[] fs2 = cfrom.getDeclaredFields();
            //遍历出每一个属性
            //for (int i = 0; i < fs.length; i++) {
//			fs[i].setAccessible(true);
//			fs2[i].setAccessible(true);
            //动态构建方法名
            //String name = fs[i].getName().substring(0, 1).toUpperCase() + fs[i].getName().substring(1);
            //String getname = "get" + name;
            //String setname = "set" + name;

            //调用students类中的get方法取到每一个属性的值
            //Method m1 = cfrom.getMethod(getname, null);
            // o1 = m1.invoke(ob1, null);
            //System.out.println(o1);

            //调用students2的set方法把刚取到的值设置给Students2的对应属性
            //Class retyoe = fs[i].getType();
            //Method m2 = cto.getMethod(setname, retyoe);
            //m2.invoke(ob2, o1);

            //调用students2的get方法取出我们copy的属性值
            //Method m3 = cto.getMethod(getname, null);
            //Object o3 = m3.invoke(ob2, null);
            //System.out.println(o3);
            //}
//				Method m3=cto.getMethod("getName", null);
//				Object o3=m3.invoke(cto.newInstance(), null);
//				System.out.println(o3);

            //} catch (NoSuchMethodException e) {
            //     e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            //} catch (InvocationTargetException e) {
            //    e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}