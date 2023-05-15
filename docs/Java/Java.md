# Java
## UML
1. 用例图
2. 类图
3. 组建图
4. 部署图
5. 顺序图
6. 活动图
7. 状态机图

## Java History
- 1996年 JDK1.0 Sun
- 1997年 JDK1.1 Sun JIT
- 1998年 JDK1.2 Sun, JSP/Servlet一起发布，
- 2002年 JDK1.4 Sun
- 2004年 JDK1.5 Sun 改名成Java SE 5.0, 范性，增强的for语句，可变数量的形参，注释，自动拆箱和装箱
- 2006年 JDK1.6 Sun
- 2009年4月20日 Oracle收购Sun
- 2011年 Java SE 7 Oracle 二进制整数，支持字符串的switch语句，菱形语法，多异常捕获和自动关闭资源的try语句
- 2014年 Java SE 8 Oracle Lambda表达式，流式编程
- 2017年 Java SE 9 Oracle 模块化系统，G1垃圾回收器
- 2018年 Java SE 10 Oracle 
- 2018年 Java SE 11 Oracle
---

## Java application
```
//compile java class file
javac -d destDir srcFile
```
```
//run java application
java java类名
java -clallpath/-cp dir1;dir2;dir3;...;dirN java类名
java -classpath %CLASSPATH%;.;dir1;dir2;dir3;...;dirN java类名
```
```
//generate javadoc API
java java类名
javadoc option javafile|package
javadoc -d . -windowtitle TestJavadoc -doctitle Javadoc -header JavaApplication  *.java
常用的javadoc标记
@author
@version
@deprecated
@param
@return
@see
@exception
@throws
```

## 面向对象
### 面向对象的3个基本特征
1.继承
2.封装
3.多态

## Java 11 new feature
1. GC |GC is CMS before jdk1.7, start using G1 in jdk1.7, delete CMS in Java SE 9, start using ZGC from Java SE 11(Disable by default)
```
//Enable ZGC, add parameters when start java application
-XX: +UnlockExperimentalVMOptions
-XX: +UseZGC
```
2. 使用var定义变量

## Coding Tips
1.  定义long，用L而不是l，因为l和1太像了
2. 