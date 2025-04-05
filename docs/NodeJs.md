# NodeJs
##### How to install nodeJs?
   - For Windows:
        1. Download NodeJs from https://nodejs.org/en/
        2. Install NodeJs with version 12.16.2

##### pm2
    install pm2
    npm install pm2 -g
    --install the latest version
    npm install pm2@latest -g

    --start app
    pm2 start app.js
    pm2 start app.js --name my-api

    --查看进程状态
    pm2 list

    --monitor all processes
    pm2 monit

    --停止所有应用
    pm2 stop all

##### ======node js======
```
sudo apt-get install build-essential
```

##### Linux下部署nodejs程序
    1 安装NVM node version management
    curl -o- https://raw.githubusercontent.com/creationix/nvm/v0.34.0/install.sh | bash
    检查NVM版本
    nvm --version
    2 安装node js version
    nvm ls-remote
    nvm i v8.12.0
    3 安装Ubuntu的插件
    apt-get install build-essential
    4 cd ui
    5 npm i
    6 cd ..
    7 npm i
    8 npm run build
    9 npm start
    
    npm i --unsafe-perm
    pm2 start npm --name appname -- start
