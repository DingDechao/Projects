package com.ddc.projects.java11.basic;

/*static关键字可以修饰属性，方法，还有内部类，但是他不能修饰我们的构造器。
 *
 * 被static修饰的属性或者方法再不属于某一个特定的对象实例，是与我们的类相关了。
 * 我们可以直接类名加“.”调用,如果只在当前类中调用，可以直接通过“方法名（）”调用。
 * 这个时候我们仍然能够使用对象加“.”的方式去调用它。
 *
 * 当我们对一个类中的static属性值进行改变，是改变与我们当前类相关的其他所有引用该属性的实例的属性的值。
 * （多个对象共享同一个静态属性，当其中的一个对象把静态属性的值改变了，那么其他对象看到的属性也就被改变了）
 */
public class StaticDemo {
    public StaticDemo() {
    }

    /*
     * { }初始化快、游离块， static还可以修饰我们的游离块，被static修饰的游离块我们叫做静态块。
     * 他会在我们初始化对象的时候自动调用执行一次
     *
     */

    /*
     * 如果该类存在父类：
     * 加载父类（执行父类中的static{}）
     * 加载本类（执行本类中的static{}）
     * 执行父类中的匿名块（如果由多个匿名块，多个匿名块按顺序执行）
     * 执行父类中的构造器（如果构造器相互调用，按调用顺序执行）
     * 执行本类中的匿名块（如果由多个匿名块，多个匿名块按顺序执行）
     * 执行本类中的构造器（如果构造器相互调用，按调用顺序执行）
     * 父类、超类、基类
     */

    static {
    }

    {
    }

    public static String name;

    public static void aMethed() {
    }

    public void methed2() {
    }

    public static void main(String[] args) {
        StaticDemo sd = new StaticDemo();
        sd.methed2();
        sd.aMethed();
        aMethed();
        StaticDemo.aMethed();
    }
}

