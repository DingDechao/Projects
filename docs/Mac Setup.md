# Software list for Mac
- Youdao Dict
- Virtual Box
- iTerm 2
- Docker
- JetBrians Toolbox
- IntelliJ IDEA CE
- XMind ZEN
- Visual Studio Code
- Momentum (Chrome plugin)
- SwitchyOmega (Chrome plugin)
- JSON Formatter (Chrome plugin)
- MySQL
- DBeaver
- MySQLWorkbench
- homebrew
- Google Chrome
- Google Chrome Canary
- Sublime Text
- Netease Music
- WeChat
- Youdao Note
- Postman
- Kindle
- xcode-select --install
- MongoDB + Compass
- StarUML
- Sonar

# U3419W

##### How to install homebrew on Mac
```
Offical website : https://brew.sh/index_zh-cn
Open command line tool and run below command
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install.sh)"
/usr/bin/ruby -e "$(curl -fsSL https://hellogithub.cn-bj.ufileos.com/file/brew_install.sh)"

If above url not work, use below
/bin/zsh -c "$(curl -fsSL https://gitee.com/cunkai/HomebrewCN/raw/master/Homebrew.sh)"

```

##### How to use homebrew
```
向homebrew添加额外的仓库用tap
brew tap pivotal/tap //添加spring 和spring boot的仓库
安装spring boot cli
brew install springboot 会安装到/usr/local/bin

查看已安装的列表
brew list

查看可用的包
brew search package name

更新homebrew
brew update

安装包
brew install package name

卸载包
brew uninstall package name
```

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

##### Jenkins
```
Download Jenkins from below website : https://www.jenkins.io/download/lts/macos/
Start the Jenkins service : brew services start jenkins-lts
Restart the Jenkins service : brew services restart jenkins-lts
Update the Jenkins version : brew upgrade jenkins-lts
```