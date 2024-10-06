package com.ddc.projects.java11.enumdemo;

/*
*   实例有限且固定的类就是枚举类
*   使用enum定义的枚举类默认都继承了java.lang.Enum类，而不是默认继承了Object类
*   所有实例必须在枚举类的第一行显示列出，系统会自动添加public static final, 无需显示添加
 */
public enum Gender {
    MALE("male") {
        public void run () {
            System.out.println("run fast");
        }
    },
    FEMALE("female") {
        public void run () {
            System.out.println("run slow");
        }
    };

    private String name;

    /*
    *  构造器可以有多个，但是没有意义，因为枚举类初始化时其实就是调用构造器初始化的，
    *   所以永远只会有一种类型的构造器被调用
    **/
    Gender(String name) {
        this.name = name;
    }

    //枚举类的构造器是私有的，又因为子类初始化时要调用父类的构造器，所以枚举类是不能有子类的，
    //在这里定义抽象方法是为了让不同实例之间有不同的行为，否则不用定义抽象方法，普通方法就可以了
    public abstract void run();

    public static void main(String[] args) {
        Gender.MALE.run();
        Gender.FEMALE.run();
    }
}
