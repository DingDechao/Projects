package com.ddc.projects.java11.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesDemo {

    public static void main(String[] args) {
        Properties pp = new Properties();
        try {
            FileInputStream fis = new FileInputStream("E:/test.properties");
            pp.load(fis);
            Enumeration er = pp.propertyNames();
            while (er.hasMoreElements()) {
                Object obj = er.nextElement();
                String key = (String) obj;
                String name = pp.getProperty(key);
                System.out.println(key + "=" + name);
            }
            FileOutputStream fos = new FileOutputStream("E:/test1.properties");
            pp.put("sa", "345");
            pp.put("zxzx", "124");
            pp.store(fos, "this is user infor:");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//		pp.put("aaa", "111");
//		pp.put("bbb", "222");
//		pp.put("ccc", "333");
//		pp.put("ddd","444");
//		pp.put("aaa", "555");
//		/*Properties属性类长度是可变的，
//		 * 如果我们调用put()给其赋值且传递的参数的key值与其中已经存在的某个key值一样，则只是修改了与之对应的value值，
//		 * 并不是新增了一条。
//		 */
//
//		Enumeration er=pp.propertyNames();
//		while(er.hasMoreElements()){
//			Object obj=er.nextElement();
//			String key=(String)obj;
//			String name=pp.getProperty(key);
//			System.out.println(key+"="+name);
//		}
    }
}
