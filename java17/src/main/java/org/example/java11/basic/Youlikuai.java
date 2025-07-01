package org.example.java11.basic;

public class Youlikuai {
    /*在我们类中出了方法、属性、构造器之外还有另外一种存在方式，只有{ }组成，我们把这种结构叫做游离块 （初始化块）
     * 特征：
     * 他的执行优先级高于我们的构造器（会在我们的构造器执行之前先执行初始化块）
     *
     * 如果一个构造器中this()或者super();
     * this是指代我们当前类中被重载的构造器，super是指子类继承父类，调用父类的构造器
     */

    {
        System.out.println("转备好了，可以创建实例化对象了！");
    }

    public Youlikuai() {
        System.out.println("我是无参构造器");
    }

    public void aMethed() {
        System.out.println("我是一个public类型的方法");
    }

    /*
     * 对象的初始化：
     * 如果该类中存在游离块（初始化块），则先执行游离块，再去调用构造器构建该对象
     */
    public static void main(String[] args) {
        Youlikuai ylk = new Youlikuai();
        ylk.aMethed();
    }
}
