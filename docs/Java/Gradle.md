# Gradle
## How to install gradle
### Mac
1. Install Xcode from App Store
2. Install development command line tool wihtin Xcode
3. Run brew install gradle within command line tool
3. gradle -v
```
------------------------------------------------------------
Gradle 8.7
------------------------------------------------------------

Build time:   2024-03-22 15:52:46 UTC
Revision:     650af14d7653aa949fce5e886e685efc9cf97c10

Kotlin:       1.9.22
Groovy:       3.0.17
Ant:          Apache Ant(TM) version 1.10.13 compiled on January 4 2023
JVM:          21.0.2 (Homebrew 21.0.2)
OS:           Mac OS X 14.0 aarch64
```

### Winodws
1. Download the latest zip file(gradle-6.7.1-all) from official website
2. Make sure JDK is installed
3. Unzip gradle-6.7.1-all.zip
4. setup environment path 
    - GRADLE_HOME=XXX\gradle-6.7.1-all
    - PATH = + %GRADLE_HOME%\bin
5. gradle -v

## Build Script
### Project
- group, name, version
- apply, dependencies, repositories, task
- ext, gradle.properties
- task org.gradle.api.Task
    1. dependsOn
    2. doFirst, doLast = <<
    
    
## Resolve dependencies conflict
1.  Look into dependencies tree
2.  排除传递依赖/强制指定版本


## task
Create one gradle java project from IDEA
add new task within build.gradle
```
task helloworld{
    doLast {
        println 'Hello World!'
    }
}
```
Display all tasks
```
gradle task
gradle -q task
gradle -q tasks --all
gradle tasks --all

```
Display all properties
```
gradle properties
```

Run the task via command line tool
```
gradle helloworld -- gradle [task name]

gradle -q helloworld -- -q display task related information only

gradle hw -- 使用驼峰缩写

gradle groupTherapy -x yayCradle0 -- exclude task yayCradle0

gradlee groupTherapy -is -- i log as info s error stack trace
```

```
gradle -h
gradle --help
```

```
gradle --offline build -- no need internet
```

log
```
gradle -i build
gradle --info build

gradle -s build
gradle --stacktrace build

gradle -q build
gradle --quiet build
```

build
```
gradle build

```

plugin
```
apply plugin: 'java'

or 

plugins {
    id 'java'
}
```
    