# Gradle
## How to install gradle
### Mac
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
    