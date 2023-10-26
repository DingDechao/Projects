# MongoDB

### Install MongoDB in Mac via homebrew
    1. install homebrew
    2. install Xcode
    3. brew tap mongodb/brew
    4. brew install mongodb-community@4.2
    5. brew services start mongodb-community@4.2
    6. download Compass from offical website -> https://www.mongodb.com/try/download/compass
    7. setup environment, add mongodb-macos-x86_64-4.2.8/bin to PATH
    8. start the server by sudo mongod
        

    
### Install MongoDB in Winodws via offical website
    1. [go to offical website](https://www.mongodb.com/try/download/community)
    2. download MongoDB with version 4.2.8 platform Windows and package msi(about 264MB)
    3. [go to offical website](https://www.mongodb.com/try/download/compass)
    4. download Compass with version 1.21.2 platform Winodws 64-bit(7+) Zip and package zip
     
   
##### logon
```
mongo
```
##### logout
```
exit
```
##### show databases;
```
show dbs
```
##### use xxx database
```
use xxx
```
##### show current database
```
db
```
##### delete database
```
db.dropDatabase()
```
##### create collection
```
db.createCollection("test")
```
##### show all collections
```
show collections
```
##### delete xxx collection
```
db.drop.xxx()
```
##### insert data
```
db.test.insert({key:"value"})
```
##### query data
```
db.test.find({})
```