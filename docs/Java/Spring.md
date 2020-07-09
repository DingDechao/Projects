# Spring Boot

## 安装 Spring Boot CLI(Command Line Interface)
- Windows 和 Mac 通用版
    1. 下载分发包 -> http://repo.spring.io/release/org/springframework/boot/spring-boot-cli/1.3.0.RELEASE/spring-boot-cli-1.3.0.RELEASE-bin.zip
    2. 解压缩第一步的zip包
    3. 把bin路径加入到系统变量中 -> spring-1.3.0.RELEASE\bin
    4. (可选)建立符号链接以方便后期更换版本
    5. 测试是否安装成功 -> spring --version

##### 如果需要spring boot内嵌tomcat，让项目可以启动起来，需要加入下面依赖
```
<dependency>
    <groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
	<version>2.1.0</version>
</dependency>
```

##### 如果想改了Java文件之后不用重启，加入下面依赖
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-devtools</artifactId>
	<version>2.1.6.RELEASE</version>
	<scope>runtime</scope>
	<optional>true</optional>
</dependency>
```

##### Spring boot加载配置文件的顺序
1. 项目目录下config/application.properties
2. 项目目录下application.properties
3. classpath下config/application.properties
4. classpath下application.properties

##### Spring Boot 启动可以配置的参数
```
spring.config.location=classpath:/test/resources/config.perperties
```
```
spring.profiles.active=dev
```
##### Example code:
```
ConfigurableApplicationContext context = new SpringApplicationBuilder(Main.class).
                                         properties("spring.config.location=classpath:/test/resources/config.perperties").
                                         properties("spring.config.location=classpath:/test/resources/config.perperties").
                                         run(args);
```

