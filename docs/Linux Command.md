# Linux
##### 显示Linux内核版本号
```
uname -r
```

##### 显示目前所支持的语言
```
echo $LANG
```

##### 带日期格式
```
date +%Y/%m/%d
```

##### 看谁在线
```
who
```

##### 查看cpu统计信息
```
lscpu
```

##### 查看当前所在的目录
```
pwd
```

##### 切换目录 - change directory
```
cd / #切换到根目录
cd . #切换到当前目录
cd .. #退到上一级
cd /XXX/XXX/XXX/XXX #切换到绝对路径
cd ./XXX #切换到相对路径
cd ~ #切换到当前用户目录
```

##### 列出目录 - list
```
ls  #列出当前目录
ls /XXX/XXX/XXX/XXX #列出到绝对路径的文件
ls ./XXX #列出相对路径下的文件
ls -a  #a代表all，表示全部，包括隐藏文件
ls -l  #列出详细信息
```


##### 清空当前终端的内容
```
clear
```

##### 创建一个空文件
```
touch aa
```

##### 查看文件的全部内容
```
cat /XXX/XXX
```


##### 多屏查看文件
```
more /XXX/XXX
# 回车显示下一行
# 可控显示下一页
# q退出分屏显示
# ctrl + c 退出命令
```

##### 查看文件的前多少行
```
head /XXX/XXX ## 默认显示10行
head -number filename # 显示前number行
```

##### 查看文件的后多少航
```
tail /XXX/XXX ## 默认显示10行
tail -number filename # 显示后number行
```


##### 创建文件夹
```
mkdir XXX
mkdir -p xxx/xxxx 
```

##### 复制文件 & 文件夹
```
cp  原文件 目标文件
cp -r 原文件夹 新地址
```


##### 删除文件 & 文件夹
```
rm -f 文件 #-f 表示不需要交互
rm -rf 文件夹
```

##### 移动文件/文件夹 & 重命名文件&文件夹
```
mv xxx /
mv xxx www
```

##### 查看网络
```
ipconfig
```



##### 查看网络的联机状态
```
netstat -a
```

##### 查看后台运行的程序
```
ps -aux
a/e #显示所有进程
f     #完整输出
```

##### 文本处理工具grep
```
-v ## 打印没有匹配的
```

##### 立即关机 --> -h 将系统的服务停掉后立即关机
```
shutdown -h now
```

##### 在20:25关机 如果已经过了，则是下一天
```
shutdown -h 20:25
```

##### 在10分钟之后关机
```
shutdown -h +10
```

##### 系统立即重启
```
shutdown -r now
```

##### 30分钟后重启  并发送消息给其他在线用户
```
shutdown -r +30 'The system will be reboot'
```

##### 仅仅发出警告信息，并不进行关机
```
shutdown -k now 'The system will be reboot'
```

##### 改变用户组的Command-->把install.log改到users的用户组下
```
chgrp users install.log
```

##### 改变文件所属用户和用户组，也可以只改用户
```
chown root:root install.log
```

##### 设置文件权限为777 r=4 w=2 x=1
```
chmod 777 .bashrc
```

##### 压缩
```
tar -jcv -f filename.tar.gz 被压缩的文件或目录
# tar.gz是一种压缩格式
# -c 创建压缩操作
# -v 显示过程
# -f 指定文件名
```

##### 查询
```
tar -jtv -f filename.tar.bz2
```

##### 解压缩
```
tar -jxv -f filename.tar.bz2 -C 要解压缩的文件或目录
# tar.gz是一种压缩格式
# -x 解压缩操作
# -v 显示过程
# -f 指定文件名
# -C 指定解压缩到哪去
```

##### 查看CPU信息
```
cat /proc/cpuinfo
```

##### 下载命令
```
1.下载到当前目录
wget url
2.下载到指定目前并且重命名
wget -O path/name url
```
##### 上次和下载数据
```
curl -s or curl --silence //程序不输出任何信息和错误信息，但是会输出结果
curl -S or --show-error // 程序有错误的时候会输出错误信息
```
##### 根据IP地址找域名
```
nslookup -qt=ptr ip地址 --》 ptr反向查找
```

##### 查看端口占用情况
```
lsof -i:8080
```

##### 查看服务器某个端口是否可用


##### SSH 生产key
```
ssh-keygen -t rsa
```

##### 设置定时任务
```
1.准备shell脚本
2.用crontab创建定时任务

查看用户下的定时任务
crontab -l

重新加载配置
/sbin sudo service cron reload
```

##### vim 快捷键
```
dd — delete an entire line
$ — move to end of line
G — move to end of file
gg — move to the beginning of the file
u — undo
dw — delete an entire word
ctrl+r undo your undo
d0 — delete the content which before cursor
d$ — delete the content which after cursor
```

##### setup linux environment
```
vim /etc/profile
JAVA_HOME=/usr/local/jdk1.8
M2_HOME=/usr/maven
PATH=$PATH:$JAVA_HOME/bin:$M2_HOME/bin
export JAVA_HOME M2_HOME PATH
source /etc/profile
```
###### install jdk
    1. download jdk
        wget --no-check-certificate --no-cookies --header "Cookie:oraclelicense=accept-securebackup-cookie" 'http://download.oracle.com/otn-pub/java/jdk/8u191-b12/2787e4a523244c269598db4e85c51e0c/jdk-8u191-linux-x64.tar.gz'
    2 unpackage
        tar -zxvf jdk-8u191-linux-x64.tar.gz
        z : 用gzip压缩
        x : 解压
        v : 显示所有过程，可以理解为打印log
        f : 文件名
    3 move to /usr/local/folder
        mv jdk1.8.0_191 /usr/local/jdk1.8
    4 setup development environment

###### install maven
    1 download maven
        wget --no-check-certificate --no-cookies 'http://mirrors.tuna.tsinghua.edu.cn/apache/maven/maven-3/3.5.4/binaries/apache-maven-3.5.4-bin.tar.gz'
    2 unpackage
        tar -zxvf apache-maven-3.5.4-bin.tar.gz
    3 setup environment

###### install git
    apt-get install git







