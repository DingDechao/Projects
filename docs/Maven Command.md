# Maven
compile|provided|runtime|test|system
:------:| :------:|:-----:|:---:|:----:
compile|✔|✔|✔|✔|✔|️
provided|✔| |✔| 
runtime| |✔| |✔
test| | |✔| 
system| | | |✔

##### -U参数
强制更新SNAPSHOT

```
maven-help-plugin-->查看当前激活的profile
mvn help:active-profiles
```

```
maven-help-plugin-->列出当前所有的profile
mvn help:all-profiles
```

##### 清理安装到本地仓库  and  跳过测试
```
mvn clean install -DskipTests
```

##### 查看项目架包依赖
```
mvn dependency:tree
```

##### Maven 插件开发
```
-DarchetypeCatalog=internal解决一直卡在从远程服务器获取catalog的问题
mvn archetype:generate  -DarchetypeCatalog=internal
选择maven-archetype-plugin(An archetype which contains a sample Maven plugin.)
```

##### 生成code coverage report
```
mvn cobertura:cobertura
```

##### maven 5个阶段
```
mvn clean compile
    package
    install --> install -U
    test
    deploy

install 本地jar 到本地maven 仓库
mvn install:install-file -Dfile=lib/UCXJPS84.jar -DgroupId=uc4 -DartifactId=UCXJPS84 -Dversion=1.0 -Dpackaging=jar
```

##### 国内的网络下载dependencies比较慢，可以在setting.xml里面配置一个ali的mirror
```
<mirror>
    <id>alimaven</id>
    <name>aliyun maven</name>
    <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
    <mirrorOf>central</mirrorOf>
</mirror>
```

