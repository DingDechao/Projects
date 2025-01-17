# Spring Boot

## Spring history
- Spring Framework 1.0
    - 2004 
    - 依赖注入
    - 声明式事务
    - 抛弃EJB
- Spring Framework 2.0
    - 自定义XML命名空间作为配置
- Spring Framework 2.5
    - 注解
    - @Component
    - @Autowired
    - Spring MVC
    - 控制器不用继承基类
- Spring Framework 3.0
    - 取代XML的基于JAVA的全新配置
- Spring Framework 3.1
    - @Enable开头的注解
- Spring Framework 4.0
    - 支持条件化的配置

## Spring Boot
- 基于历代Spring Framework
- 自动配置
    - 自定义配置(覆盖自动配置/属性文件外置配置微调配置)
- 起步依赖（starter dependency）
- Actuator

### Spring Initializr的4种用法
- 通过Web界面使用
- 通过Spring Tool Suite使用
- 通过IntelliJ IDEA使用
- 使用Spring Boot CLI使用

### 起步依赖
- Spring Boot起步依赖都以spring-boot-starter打头
### Actuator
- Spring应用程序上下文里配置的bean
- Spring Boot的自动配置做的决策
- 应用程序取到的环境变量、系统变量、配置属性和命令行参数
- 应用程序里线程的当前状态
- 应用程序最近处理过的HTTP请求的追踪情况
- 各种和内存用量、垃圾回收、Web请求以及数据源用量相关的指标


## 安装 Spring Boot CLI(Command Line Interface)
- Windows 和 Mac 通用版
    1. 下载分发包 -> https://repo.spring.io/release/org/springframework/boot/spring-boot-cli/2.3.8.RELEASE/spring-boot-cli-2.3.8.RELEASE-bin.zip
    2. 解压缩第一步的zip包
    3. 把bin路径加入到系统变量中 -> spring-1.3.0.RELEASE\bin
    4. (可选)建立符号链接以方便后期更换版本
    5. 测试是否安装成功 -> spring --version
    
- For Mac
    1. brew tap pivotal/tap
    2. brew install springboot

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

##### Spring Boot 默认日志
Spring Boot 会用Logback作为默认日志
日志级别为INFO
要想完全掌控日志配置，需要在src/main/resources里面创建logback.xml
默认情况下，日志到达10MB会切分一次
```
<configuration>
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>
                %d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n
            </pattern>
        </encoder>
    </appender>
    <logger name="root" level="INFO"/>
    <root level="INFO">
        <appender-ref ref="STDOUT"/>
    </root>
</configuration>
```
