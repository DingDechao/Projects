# Aerospike
##### How to know i have already installed Aerospike
```
pkgutil --pkgs | grep 'aerospike.tools'
```

##### Install Aerospike on Mac OS
```
1. install vagrant
2.mkdir ~/aerospike-vm
3.vagrant init aerospike/aerospike-ce
4.vagrant up
```


##### Verify Aerospike is running
```
vagrant ssh -c "sudo service aerospike status"
vagrant ssh -c "sudo service amc status"

vagrant ssh -c "sudo grep -i cake /var/log/aerospike/aerospike.log"
```

##### Log path
```
/var/log/aerospike/aerospike.log
```

##### determine ip address
```
vagrant ssh -c "ip addr" |grep "global eth1"
```