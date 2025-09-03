# Software list for Mac
- Xnip
- OBS
- 解忧专业版
- WPS office
- V2RayX
- Wireshark
- ClashX
- 迅雷
- Gmail
- Google Chrome
- Momentum (Chrome plugin)
- SwitchyOmega (Chrome plugin)
- JSON Formatter (Chrome plugin)
- Google 云端硬盘
- Google 文档
- Google 幻灯片
- Google 表格
- Sublime Text
- Typora
- 网易有道词典
- 印象笔记
- 有道云笔记
- 网易云音乐
- 网易邮箱大师
- 百度网盘
- 阿里云盘
- 夸克
- MarginNote 3
- Kindle Classic
- XMind
- 微信
- QQ
- iTerm
- draw.io
- IDLE
- Python Language
- Postman
- GitHub Desktop
- Xcode
- Docker
- JetBrians Toolbox
- IntelliJ IDEA CE
- PyCharm CE
- Eclipse Installer
- Eclipse
- Visual Studio Code
- DBeaver
- MySQL version?
- MySQLWorkbench
- Final Cut Pro
- 爱剪辑
- 暴风影音
- 优酷
- 爱奇艺
- YouTube
- zoom.us
- 腾讯会议

---
# Development environment setup on Mac
# To be updated by Dechao
- homebrew
- jdk 1.8
- maven
- ssh key
- jenkins
- xcode-select --install
- MongoDB + Compass
- Sonar


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