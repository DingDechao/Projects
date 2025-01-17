package com.ddc.projects.java11.basic;

//子类
import com.ddc.projects.java11.entity.PersonDemo;

//所有的类都已经默认继承了我们的Object类，也叫我们的基类，超类
//类 Object 是类层次结构的根类。每个类都使用 Object 作为超类。所有对象（包括数组）都实现这个类的方法。
public class Students extends PersonDemo {
    //当子类集成一个父类后继承的元素有哪些，有什么要求：
    /*
     * 1.当子类继承父类后具有父类里的部分属性和方法；
     * 具体是哪一部分：
     * public修饰的属性和方法能够全部被继承下来
     * private修饰的属性和方法不能够被子类继承的；
     * default修饰的属性和方法不能被不在同一个包下面的子类继承，
     * 如果他们都在同一个包是可以被继承的
     * protected修饰的属性和方法可以被子类继承
     *
     * 2.继承只能单继承，就是说一个子类只能有一个父类，但是反过来一个父类可以被多个子类继承
     *
     * 3.子类是无法继承父类的构造器的
     *
     * 4.当子类实例化（即创建该类的对象的时候）时会先去调用我们父类的无参构造器，
     *   然后再调用自己的构造器创建一个子类对象（如果父类没有无参构造器:则需要在子类的构造器中
     *   使用super关键字构建父类与子类的关系;如果父类使用的有参构造器，则子类中我们也需要同样使用
     *   一个带参的构造器，且构造器内必须有super关键字）
     *
     * 5.我们要求在子类构造器中要调用父类的构造器（避免程序编译出错--父类中没有与之对应的构造器供系统自动调用）
     *
     */

    public Students() {
        super();
    }


    public Students(int number) {
        super(number);
        System.out.println("我是studends类中的构造器");
    }

    public String stunum = "2091212121";
    public int grade;
    public String qq;

    public void toClassroom() {
        this.sleep();
        System.out.println("真不想去啊！");
    }

    /*
     * this关键字：
     * 如果我们在某一个类的构造器或者方法里面使用this，它指代的是该类的一个对象就是指代该类；
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        this.name = "wangcai";
        return name;
    }

    /*重写toString()方法
     * 所有的类都继承了我们的Object类，故而每一个类中都有一个我们Object所具有的一个方法：toString()
     * 然后我们如果根据我们的需要来重写我们的toString方法，改变他的返回内容（返回值类型必须是String类型）
    注意事项
    1.必须被声明为public
    2.返回类型为String
    3.方法的名称必须为toString,且无参数
    4.方法体中不要使用输出方法System.out.println()
     */
    public static void main(String[] args) {
        Students students = new Students(1);
		students.sleep();
		students.run();
        students.toClassroom();
        System.out.println(students.toString());

        PersonDemo ps = new Students();
        ps.run();

        Students st = (Students) new PersonDemo();
        st.toClassroom();
    }

    /*父类可以隐式的调用子类中的方法和属性（但是注意：这些方法和属性必须是从父类那边继承过来的），
     * 但是子类特有的属性和方法，父类是调用不到的
     *
     * 如果需要把一个父类对象给我们的子类对象，则需要我们对其造型（强制转换）
     *
     * 但是在把父类赋给子类之前需要使用关键字instanceof来判断父类对象是否能够转换成其对应的子类
     * Boolean b=父类  instanceof  子类//如果能够转换，则结果b会返回true
     */
}

