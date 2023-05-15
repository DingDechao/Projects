# Oracle
#### Oracle Exception
##### Oracle一共提供了25种预定义异常
```
select * from DBA_SOURCE where name = 'STANDARD' AND text like '%EXCEPTION_INIT%';
exception name EXCEPTION; --声明异常（名称自定义）
PRAGMA EXCEPTION_INIT(exception name, -2291)
-2291 -> 系统内置异常号，但是没有定义异常名称
主动/显示的抛出异常
RAISE exception name; （-20999 ~ -20000可自定义）
```
#### System table
##### 查看已有函数名称
```
select object_name, object_id, object_type from user_procedures order by object_type;
```
##### 查看XXX函数的源脚本
```
select name, line, text from user_source where name = 'XXX';
```

#### SQL * Plus
##### SQL * Plus 调整结果集字段长度
```
COL columnname FORMAT A60/A15/A80
```

##### SQL * Plus 让DBMS_OUTPUT.PUT_LINE输出
1. show serveroutput
2. set serveroutput on -> serveroutout on size unlimited format wcird_wrapped

#### Oracle SQL Developer
##### 如何修改 Oracle SQL Developer 菜单栏的字体大小
- Windows
```
配置文件地址 : C:\Users\XXX\AppData\Roaming\SQL Developer\systemXX.XX.XXX.XXXX\o.sqldeveloper\ide.properties
配置项 : Ide.FontSize = 14 -> default values is 11
```
- Linux
```
```