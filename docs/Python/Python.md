# Python
##### Download
```
wget https://www.python.org/ftp/python/2.7.16/Python-2.7.16.tgz
```

##### 切换系统默认python到python3
```
echo alias python=python3 >> ~/.bashrc
echo alias pip=pip3 >> ~/.bashrc
source ~/.bashrc
```

##### pip 默认源
```
https://pypi.org
```

##### 查找某个包
```
pip search airflow
```

##### 查看当前安装的所有包和版本
```
pip freeze
```

##### 查看所有包
```
pip list # 没成功
```

##### 安装 最新 版本的包
```
pip install 包名
```

##### 安装特定版本的包
```
pip install 包==2.0.0
```

##### 升级包的版本
```
pip install --upgrade 包
```

##### 显示特定包的信息
```
pip show 包
```

##### 发送邮件
```
  SMTP ->  简单邮件传输协议， SMTP只能用来发邮件，不能用来接收邮件
  SMTP 协议默认TCP端口是25
```

# Airflow
```
pip install -i https://pypi.douban.com/simple apache-airflow
pip install -i https://pypi.douban.com/simple apache-airflow[mysql]
--mysql database
show variables like '%explicit_defaults_for_timestamp%';
create database airflow;
GRANT all privileges on airflow.* TO 'airflow'@'%' IDENTIFIED BY 'airflow';
FLUSH PRIVILEGES;
------------
vim ~/airflow.cfg
sql_alchemy_conn = mysql://airflow:airflow@localhost/airflow
executor = LocalExecutor
------------
airflow initdb
airflow webserver -p 8080
airflow scheduler

airflow test dag_id task_id 2019-10-28
-------------------------------------------------------------
sudo docker ps -a
sudo docker exec -it container-id bash
DAGs path : /usr/local/lib/python3.7/site-packages/airflow/example_dags/example_bash_operator.py

-------------------------------------------------------------
airflow list_dags
airflow test dag_id sensor 2015-06-01

-------------------------------------------------------------
```
