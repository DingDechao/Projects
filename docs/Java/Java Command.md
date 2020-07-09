# Java
- 位
    - 0 或者 1 是一位

- 字节
    - 1 byte(字节) = 8 bit(位)
    - 1024 byte = 1 KB
    - 1024 KB = 1 MB
    - 1024 MB = 1 GB
    - 1024 GB = 1 TB
- 字符
    - a A b B 都表示一个字符 = 1个字节
    - utf-8 一个汉字是一个字符 = 3 字节
    - gbk   一个汉字是一个字符 = 2个字节

- 一些工具
    - Launch4J
    - LzPack

- 将file1 file2 file3 打包成jar文件
    - jar cvf jarfilename file1 file2 file3...

- 使用jar e选项指定程序的入口点
    - jar cvfe MyProgram.jar com.mycompany.mypkg.MainAppClass files to add

- 启动jar应用程序
    - java -jar MyProgram.jar

- System properties
    - System.getProperty("");
    - java.version --1.8.0_171
    - os.name --Mac OS X
    - os.arch --x86_64
    - file.separator -- /

- setup JAVA project process
    1. design doc
    2. choose proper tech stack
    3. db desgin
    4. repo setup(github/bitbucket)
    5. setup dev environment
    6. init first commit
    7. CI(PR/Build)
    8. release

- JDBC - Java Database Connectivity

## Annotation
### 5个基本注解
- @Override : 限定重写父类方法,且只能修饰方法
```
public class Fruit {
    public void info() {
        System.out.println("This is Fruit's info method");
    }
}

public class Apple extends Fruit {

    @Override
    public void info() {
        System.out.println("This is Apple's info method");
    }
}

public class AppleWithCompileError extends Fruit{
    @Override
    // Method does not override method from its superclass
    public void inf() {
        System.out.println("This is AppleWithCompileError's info method");
    }
}

```
- @Deprecated ：表示某个类或者方法已过时
```
@Deprecated
public void getPlaceOfOrigin() {
   System.out.println("This is Apple's getPlaceOfOrigin() method");
}
``` 
- @SuppressWarnings ： 抑制编译器的警告
```
    @SuppressWarnings(value = "unchecked")
    public void getAllColor() {
        //Unchecked assignment: 'java.util.ArrayList' to 'java.util.List<java.lang.String>' 
        List<String> colors = new ArrayList(); 
    }
```
- @SafeVarargs(Added in Java 7)
    - 堆污染
    ```
     import java.util.ArrayList;
     import java.util.List;
     
     public class HeapPollution {
     
         public void heapPollutionDemo() {
             List list = new ArrayList<Integer>();
             //Unchecked call to 'add(E)' as a member of raw type 'java.util.List' 
             list.add(20);
     
             List<String> stringList = list;
     
     /*      Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
             at com.ddc.projects.java8.annotationdemo.HeapPollution.heapPollutionDemo(HeapPollution.java:15)
             at com.ddc.projects.java8.annotationdemo.HeapPollution.main(HeapPollution.java:20)*/
             System.out.println(stringList.get(0));
         }
         
         public static void main(String[] args) {
             new HeapPollution().heapPollutionDemo();
         }
     }   
    ```
    ```
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.List;
    import java.util.Random;
    
    public class HeapPollution {
    
        public void heapPollutionDemo1() {
            List list = new ArrayList<Integer>();
            //Unchecked call to 'add(E)' as a member of raw type 'java.util.List'
            list.add(20);
    
            List<String> stringList = list;
    
    /*      Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
            at com.ddc.projects.java8.annotationdemo.HeapPollution.heapPollutionDemo(HeapPollution.java:15)
            at com.ddc.projects.java8.annotationdemo.HeapPollution.main(HeapPollution.java:20)*/
            System.out.println(stringList.get(0));
        }
    
        @SafeVarargs
        //Possible heap pollution from parameterized vararg type
        public final void heapPollutionDemo2(List<String>... listStringArray) {
            List[] listArray = listStringArray;
            List<Integer> integerList = new ArrayList<>();
            integerList.add(new Random().nextInt(100));
    
            listArray[0] = integerList;
    /*
            Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
            at com.ddc.projects.java8.annotationdemo.HeapPollution.heapPollutionDemo2(HeapPollution.java:29)
            at com.ddc.projects.java8.annotationdemo.HeapPollution.main(HeapPollution.java:34)
    */
            String str = listStringArray[0].get(0);
        }
    
        public static void main(String[] args) {
            //new HeapPollution().heapPollutionDemo1();
            //Unchecked generics array creation for varargs parameter
            new HeapPollution().heapPollutionDemo2(Arrays.asList("Hello"), Arrays.asList("World"));
        }
    }

    ```
- @FunctionalInterface(Added in Java 8) : Lambda表达式可以创建函数式接口的实例
    ```
    @FunctionalInterface
    public interface FunctionalInterfaceDemo {
        
        static void staticMethod() {
            System.out.println("Static method");
        }
        
        default void defaultMethod() {
            System.out.println("Default Method");
        }
        
        void test();
        
        //void test1();
    }
    
    ```

### JDK的元注解
- @Retention : 只能用来修饰注解，表示该注解的保留时间
    1. RetentionPolicy.CLASS ：编译器把注解保留在class文件里，但是JVM拿不到
    2. RetentionPolicy.RUNTIME ： 编译器把注解保留在class文件里，JVM可以拿到，程序通过反射拿注解信息
    3. RetentionPolicy.SOURCE : 仅仅保留在源码中，编译器直接忽略
    ```
    import java.lang.annotation.Retention;
    import java.lang.annotation.RetentionPolicy;
    
    @Retention(value = RetentionPolicy.RUNTIME)
    public @interface Testable {
    }
    ```
    ```
    import java.lang.annotation.Retention;
    import java.lang.annotation.RetentionPolicy;
    
    @Retention(RetentionPolicy.SOURCE)
    public @interface Testable {
    }
    ```
- @Target : 只能修饰注解，表示该直接可以修饰哪些类型
    1. ElementType.ANNOTATION_TYPE ：只能修饰注解
    2. ElementType.CONSTRUCTOR ： 只能修饰构造器
    3. ElementType.FIELD ： 只能修饰成员变量
    4. ElementType.LOCAL_VARIABLE ：只能修饰局部变量
    5. ElementType.METHOD ： 只能修饰方法
    6. ElementType.PACKAGE ： 只能修饰包
    7. ElementType.PARAMETER ： 可以用在参数上
    8. ElementType.TYPE : 可以修饰类、接口（包括注解类型）或枚举
    9. ElementType.TYPE_PARAMETER :
    10. ElementType.TYPE_USE : 类型注解 - 可以用来修饰任何类型
    ```
    import java.lang.annotation.ElementType;
    import java.lang.annotation.Retention;
    import java.lang.annotation.RetentionPolicy;
    import java.lang.annotation.Target;
       
    @Retention(value = RetentionPolicy.RUNTIME)
    @Target(value = ElementType.METHOD)
    public @interface Testable {
    }
  ```
- @Documented : 只能修饰注解，表示该注解会被javadoc工具提取
    ```
    import java.lang.annotation.*;
    
    @Retention(value = RetentionPolicy.RUNTIME)
    @Target(value = ElementType.METHOD)
    @Documented
    public @interface Testable {
    }
    ```
![hasdocumentedannotation](../images/Annotation document.PNG)
---
![withoutdocumentedannotation](../images/withoutDocumentedAnnotation.PNG)
- @Inherited : 只能修饰直接，表示该注解具有继承性
```
    import java.lang.annotation.*;
    
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    public @interface InheritedDemo {
    }
```
---
```
  @InheritedDemo
  class A {
  
  }
  
  public class TestInheritable extends A{
      public static void main(String[] args) {
          // true
          System.out.println(TestInheritable.class.isAnnotationPresent(InheritedDemo.class));
      }
  }
```
  
### 自定义注解 : 用关键字@interface
    

```
public @interface CustomAnnotation {
    
    String name() default "abc";
    int age() default 12;
}
```
---
```
public class TestCustomAnnotation {
    
    @CustomAnnotation(name = "ddc", age = 10)
    public void test() {
    }
}
```
#### Example
```
import java.lang.annotation.*;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
@Documented
public @interface Testable {
}

public class TestAnnotationTestable {

    public static void method1() {
        System.out.println("This is method 1");
    }

    @Testable
    public static void method2() {
        System.out.println("This is method 2");
    }

    public static void method3() {
        System.out.println("This is method 3");
    }

    @Testable
    public static void method4() {
        System.out.println("This is method 4");
    }
}


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestableProcessor {

    public static void process(String clazz) throws ClassNotFoundException{
        for (Method method : Class.forName(clazz).getMethods()) {
            if (method.isAnnotationPresent(Testable.class)) {
                try {
                    method.invoke(null);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        TestableProcessor.process("com.ddc.projects.java8.annotationdemo.TestAnnotationTestable");
        //This is method 4
        //This is method 2
    }
}
```
