# MongoDB

##### Install MongoDB in Mac via homebrew
    1. install homebrew
    2. install Xcode
    3. brew tap mongodb/brew
    4. brew install mongodb-community@4.2
    5. brew services start mongodb-community@4.2


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