# Software list for Mac
- Youdao Dict
- Virtual Box
- iTerm 2
- Docker
- IntelliJ IDEA CE
- XMind ZEN
- Visual Studio Code
- Momentum (Chrome plugin)
- MySQLWorkbench
- homebrew
- Google Chrome
- Google Chrome Canary
- Sublime Text
- NeteaseMusic
- WeChat
- Youdao Note
- Postman
- Kindle

# U3419W

##### jdk
```
download and install
setup environment
/Library/Java/JavaVirtualMachines/jdk1.8.0/Contents/Home
cd ~
vim .bash_profile
JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0/Contents/Home
PATH=$PATH:$JAVA_JOME:.
export JAVA_HOME
export PATH
java -version
```

##### maven
```
cd ~
vim .bash_profile
M2_HOME=maven path
PATH=$PATH:$JAVA_JOME:$M2_HOME:.
export M2_HOME
export PATH
mvn -v
```

##### generate ssh key
```
cd ~
ssh-keygen -t rsa
cd .ssh
```