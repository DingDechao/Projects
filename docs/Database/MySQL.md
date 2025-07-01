# MySQL
## Related document : https://dev.mysql.com/doc/refman/5.7/en/osx-installation-pkg.html

##### How to install MySQL Server
    1. Download the MySQL Server
    https://dev.mysql.com/downloads/mysql/5.7.html#downloads
    2. Install
    3. Download workbench
    https://dev.mysql.com/downloads/workbench/
    http://localhost:8080/demo/all
    localhost:8080/demo/add?name=First&email=someemail@someemailprovider.com

##### Install mysql 5.2.7 in linux
    https://dev.mysql.com/doc/mysql-apt-repo-quick-guide/en/
    1. wget https://dev.mysql.com/get/mysql-apt-config_0.8.12-1_all.deb
    2. dpkg -i mysql-apt-config_0.8.12-1_all.deb
    3. apt-get update
    4. apt-get install mysql-server
    5. service mysql status
    6. cd /etc/mysql/mysql.conf.d
    vim mysqld.cnf
    bind-address	= 0.0.0.0
    mysql -u -root -p
    GRANT ALL ON *.* to root@'%' IDENTIFIED BY 'pw';
    FLUSH PRIVILEGES;
    exit;

##### Command
```
mysql --help |grep 'my.cnf'
/etc/my.cnf
/etc/mysql/my.cnf
/usr/local/mysql/etc/my.cnf
~/.my.cnf
```

##### 登录mysql
```
mysql -uUSER -pPASSCODE -hHOSTNAME --default-character-set=utf8
mysql -u username -h host --default-character-set=utf-8 -p password
需要把%MYSQL_HOME%\bin 加入path中
```

##### 查看数据库版本
```
SELECT VERSION();
```

##### 查看所有数据库
```
SHOW DATABASES;
```

##### 创建数据库
```
CREATE DATABASE [IF NOT EXISTS] database_name;
```

##### 删除数据库
```
DROP DATABASE database_name;
```

##### 切换到某一个数据库
```
USE database_name;
```

##### 查看当前选择的数据库
```
SELECT DATABASE();
```

##### 查看所有的表
```
SHOW TABLES;
```

##### 查看表结构
```
DESCRIBE table_name;
DESC table_name;
```

##### 创建表的语法
```
create table [schema.]table_name
(
#多个列的定义
column_name1 data_type [default expr],
......
)
```

##### 查看所有的表信息
```
select * from information_schema.tables;
```

##### 查看表结构
```
SHOW CREATE TABLE TABLENAME;
##### 查看某个变量的值
SHOW VARIABLES LIKE '%time_zone%'
```

##### INDEX

##### 不允许更新全表，解除安全模式
```
SET SQL_SAFE_UPDATES = 0;
```

##### 查看explicit_defaults_for_timestamp的值
```
show variables like '%explicit_defaults_for_timestamp%';
```

##### 约束
    1. NOT NULL
        1.1 创建表的时候增加NOT NULL约束
        create table test(
	        test_id int not null,
        	test_name varchar(255) default 'abc' not null,
            如果指定dafult value,那么NOT NULL约束无效
        	test_desc varchar(2) null
        );
        1.2 创建表之后通过alter table增加/删除NOT NULL约束
        alter table test modify test_desc varchar(2) not null;
        alter table test modify test_name varchar(2) null;
        alter table test modify test_name varchar(255) default 'abc' null;
    2.  Primary key
        列级约束语法
        create table primary_test (
            test_id int primary key,
            test_name varchar(255)
        );
        表级约束语法
        create table primary_test2
        (
        test_id int not null,
        test_name varchar(255),
        test_pass varchar(255),
        # primary key name is test2_pk, 对mysql没用，主键名默认为primary
        constraint test2_pk primary key(test_id)
        );
        # 使用多列作为主键
        create table primary_test3
        (
        test_name varchar(255),
        test_pass varchar(255),
        primary key(test_name, test_pass)
        );
        # 删除主键约束
        alter table primary_test3 drop primary key;
        #使用表级约束语法增加主键约束
        alter table primary_test3 add primary key(test_name, test_pass);
        
        #使用modify为列增加主键约束
        alter table primary_test modify test_name varchar(255) primary key;

        # 建立主键，并且设置自动增长
        create table primary_test4
        (
        test_id int auto_increment primary key,
        test_name varchar(255),
        test_pass varchar(255)
        );
        # 创建主表
        create table teacher_table
        (
        teacher_id int auto_increment,
        teacher_name varchar(255),
        primary key(teacher_id)
        );
        
        # 创建从表
        create table student_table
        (
        student_id int auto_increment primary key,
        student_name varchar(255),
        # 对mysql无效
        #java_teacher int references teacher_table(teacher_id)
        java_teacher int,
        # 不指定外键名字
        #foreign key(java_teacher) references teacher_table(teacher_id)
        # 指定外键名字
        constraint student_teacher_fk foreign key(java_teacher) references teacher_table(teacher_id)
        );
        
        # 删除外键
        alter table student_table drop foreign key student_teacher_fk;
        
        # 增加外键约束
        alter table student_table add foreign key(java_teacher) references teacher_table(teacher_id);
        
        # 定义级联删除
        foreign key(java_teacher) references teacher_table(teacher_id) on delete cascade # or on delete set null

# 索引
create index emp_last_name_idx on employees(last_name);

drop index emp_last_name_idx on employees

# 视图
create or replace view view_test
as
select teacher_name, teacher_pass from teacher_table;

drop view view_name;

# mysql function
## char_length
select char_length(teacher_name) from teacher_table;

## DATE_ADD()
select  DATE_ADD(CURDATE() , interval 2 month);

## ADDDATE()
select adddate(curdate(), 3)

## CURDATE()
select CURDATE();

## curtime();
select curtime();
                        