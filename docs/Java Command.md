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
