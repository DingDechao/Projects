package org.example.java11.basic;

public class Dogs //extends Animals
{

    public String name;
    public String maose;
    /**
     * 当子类重写父类中的方法之后，会对我们父类的中的方法进行覆盖（这里的覆盖只是针对于子类来说的，
     * 并没有真正去改写我们父类中的方法）
     * 如果在子类中调用重写后的方法调用的只是我们的子类中的方法,父类中的方法仍然存在，并没有发生改变
     * <p>
     * 方法重写的注意事项：
     * 1.方法名称必须和父类中的方法一致
     * 2.方法的返回类型一致
     * 3.输入参数也必须保持一致（输入参数类型一致，输入参数个数也要一致）
     * 4.子类中的覆盖方法不能使用比父类中被覆盖方法更严格的访问权限。
     * 父类					子类
     * default			default,pretected,public
     * pretected        pretected,public
     * public 			public
     */
    public void jiaosheng() {
        System.out.println("汪汪..");
    }

    public String toString() {
        return super.toString();
    }

    public String toString(int a) {
        return maose;
    }

    public static void main(String[] args) {
        Dogs dog = new Dogs();
        dog.jiaosheng();
        //Animals a = new Animals();
        //a.jiaosheng();
    }
}
