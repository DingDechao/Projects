# Docker

##### 获取镜像
```
docker pull
docker pull registry.hub.docker.com/centos:centos6
```

##### 查看镜像列表
```
docker images
```

##### 创建新的镜像
```
docker build
```

##### 删除镜像
```
docker rmi image-id
```

##### 上传镜像
```
docker push
```

##### 创建容器
```
docker creat image-id
docker create -it --name centos6_container centos:centos6
```

##### 查看容器列表
```
docker ps  --只显示在运行的容器
docker ps -a --显示所有容器
```

##### 启动容器
```
docker start contanier-id
docker start -i b3cd0b47fe3d
```

##### 停止容器
```
docker stop contanier-id
```

##### 删除容器
```
docker rm container-id
```

##### 运行容器
```
docker run image-id
```

##### 进入容器
```
docker exec container-id
docker exec -it centos6_container bash
```