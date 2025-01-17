
##### Maven 集成 Jacoco 测量代码覆盖率
执行命令 ： mvn test
```
<build>
        <plugins>
            <plugin>
                <groupId>org.jacoco</groupId>
                <artifactId>jacoco-maven-plugin</artifactId>
                <version>0.8.6</version>
                <executions>
                    <execution>
                        <id>default-prepare-agent</id>
                        <goals>
                            <goal>prepare-agent</goal>
                        </goals>
                    </execution>
                    <execution>
                        <id>default-report</id>
                        <goals>
                            <goal>report</goal>
                        </goals>
                    </execution>
                    <!--                    <execution>-->
                    <!--                        <id>default-check</id>-->
                    <!--                        <goals>-->
                    <!--                            <goal>check</goal>-->
                    <!--                        </goals>-->
                    <!--                        <configuration>-->
                    <!--                            <rules>-->
                    <!--                                <rule>-->
                    <!--                                    <element>BUNDLE</element>-->
                    <!--                                    <limits>-->
                    <!--                                        <limit>-->
                    <!--                                            <counter>COMPLEXITY</counter>-->
                    <!--                                            <value>COVEREDRATIO</value>-->
                    <!--                                            <minimum>0.60</minimum>-->
                    <!--                                        </limit>-->
                    <!--                                    </limits>-->
                    <!--                                </rule>-->
                    <!--                            </rules>-->
                    <!--                        </configuration>-->
                    <!--                    </execution>-->
                </executions>
            </plugin>
        </plugins>
    </build>
```
##### Code coverage exclude list
- 带有常量的interface 或者所有interface

##### Tips
- 对于 interface 来说，如果只有抽象方法，Jacoco会忽略这个interface, 在 SonarQube上也不会体现，但是如果interface里面定义了常量的情况下，这个interface就会被Jacoco检测到，并且要求常量被测试(好像没办法被cover)，抽象方法不用
- 对于 final class 来说，如果只定义了变量，Jacoco会忽略变量，但是默认的无参构造器需要被覆盖