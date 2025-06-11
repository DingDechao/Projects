package org.example.java11.Collection;

import java.util.Hashtable;
import java.util.Iterator;

public class CollectionDemo {

    /*collection是所有集合类的父类接口，collections是一个java类，主要实现了Array里面的方法和操作。
     *
     * list,set都是collection的子类，区别在于:list存放数据是有序的，而set是无序的；
     * list里面可以存放相同的元素，set里面不允许有重复的元素。
     *
     * arraylist的直接父类是abstractlist，abstractlist又实现了list接口，
     * 所以我们可以把一个arraylist对象赋给我们的list类型变量。而且在这里要求以后
     * 都这样来创建ArrayList类。（List list=new ArrayList();）
     *
     * arraylist是一个实现不同步的类，是线程不安全的。里面存放的数据是可以重复的，是有序的，允许有空值，且允许多个null值。
     * 执行效率相较于vector快。
     *
     * Vector是一个线程安全的，一次只允许一个线程访问他，只有访问的当前进程结束后才允许其他线程访问。
     *
     * 泛型：定义当前集合里面元素的数据类型，一旦定义，该集合里面的元素必须遵循该限制，只用该类型进行操作（存入，取出）。
     *
     * hashset是实现了set接口，存储元素是散列形式的，是无序的，元素也是唯一的，不重复的，允许存在null值，但是不允许多个null值
     *
     *
     *
     * hsahmap里面的key值是String类型，value是Object类型的。
     *
     * hashmap主要是以键值对的形式存放元素的，这就要求我们的key必须唯一，
     * 允许为null,但是null也是一种key的标识，也只能有一个null。
     * value可以为null，value值可以重复，value可以有多个null值。
     * hashmap实现不同步的，允许有多个线程同时访问他，是线程非安全的。
     * hahsmap的遍历可以使用迭代器
     *
     *
     *
     * hashtable也是以键值对的形式存放数据的，key也必须唯一，key和value值都不允许为null值，
     * hashtable是实现同步的，是线程安全的，他的遍历既可以使用迭代器，也可以使用枚举。
     */

    public static void main(String[] args) {
        Hashtable<String, Object> table = new Hashtable<>();

        table.put("as", "123");
        table.put("as2", "aaa");
        table.put("as3", "111");
        table.put("as4", "12");
        table.put("as5", "aa1a");
        table.put("as6", "1121");
//		Object o= table.get("as");
//		System.out.println(o);

//		Enumeration<Object> em=table.elements();
//
//		while (em.hasMoreElements()) {
//			Object object = (Object) em.nextElement();
//			System.out.println(object);
//		}

//		Enumeration<String> keys=table.keys();
//
//		while (keys.hasMoreElements()) {
//			String key = (String) keys.nextElement();
//			Object value=table.get(key);
//
//			System.out.println(key+"="+value);
//		}

//		Iterator<Entry<String, Object>>  it=table.entrySet().iterator();
//
//		while (it.hasNext()) {
//			Entry<String, Object> entey = it.next();
////			Object value=table.get(key);
//			System.out.println(entey);
//		}

        Iterator<String> it = table.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            Object value = table.get(key);
            System.out.println(key + "=" + value);
        }

//
//		Map<String, Object> map=new HashMap<String, Object>();
//
//		map.put(null, "asd");
//		map.put("1", null);
//		map.put(null, "123");
//
//		String str=(String)map.get(null);
//
//		System.out.println(str+"........");
//
//
//		Iterator it=map.keySet().iterator();
//
//		while (it.hasNext()) {
//			String key = (String) it.next();
//			String value=(String) map.get(key);
//
//			System.out.println(key+"/"+value);
//
//		}

//		Iterator it2=map.values().iterator();
//
//		while (it2.hasNext()) {
//			String value = (String) it2.next();
//			System.out.println(value);
//		}
//

//		List list=new ArrayList();
//		List vec=new Vector();
//		list.add("");
//		list.add("");
//		vec.add("xiaoqiang");
//		vec.add("zhangsan");
//		vec.add("lisi");
//
//		for (int i = 0; i < vec.size(); i++) {
//			System.out.println(vec.get(i));
//		}
//
//
//
//		for (int i = 0; i < list.size(); i++) {
//
//			System.out.println(list.get(i)+"/");
//		}

//		Set<String> set=new HashSet<String>();
//
//		set.add("lisi");
//		set.add("lisi");
//
//		//迭代器遍历set集合
//		Iterator<String> it=set.iterator();
//		while (it.hasNext()) {
//			String str =it.next();
//			System.out.println(str+"\\\\");
//		}
    }
}

