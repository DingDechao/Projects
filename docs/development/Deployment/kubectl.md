```
kubectl cluster-info

NAME          STATUS   ROLES           AGE   VERSION
k8s-master1   Ready    control-plane   27h   v1.35.3
k8s-worker1   Ready    <none>          26h   v1.35.3
k8s-master1@k8s-master1:~$ kubectl cluster-info
Kubernetes control plane is running at https://192.168.10.134:6443
CoreDNS is running at https://192.168.10.134:6443/api/v1/namespaces/kube-system/services/kube-dns:dns/proxy

To further debug and diagnose cluster problems, use 'kubectl cluster-info dump'.
```

```
kubectl get nodes
NAME          STATUS   ROLES           AGE   VERSION
k8s-master1   Ready    control-plane   27h   v1.35.3
k8s-worker1   Ready    <none>          26h   v1.35.3
```

```
kubectl get node
NAME          STATUS   ROLES           AGE   VERSION
k8s-master1   Ready    control-plane   27h   v1.35.3
k8s-worker1   Ready    <none>          26h   v1.35.3
```

```
kubectl get nodes -o wide
NAME          STATUS   ROLES           AGE   VERSION   INTERNAL-IP      EXTERNAL-IP   OS-IMAGE             KERNEL-VERSION      CONTAINER-RUNTIME
k8s-master1   Ready    control-plane   27h   v1.35.3   192.168.10.134   <none>        Ubuntu 24.04.4 LTS   6.17.0-20-generic   containerd://2.2.1
k8s-worker1   Ready    <none>          26h   v1.35.3   192.168.10.135   <none>        Ubuntu 24.04.4 LTS   6.17.0-20-generic   containerd://2.2.1
```

```
kubectl describe nodes k8s-makster1
Error from server (NotFound): nodes "k8s-makster1" not found
k8s-master1@k8s-master1:~$ kubectl describe nodes k8s-master1
Name:               k8s-master1
Roles:              control-plane
Labels:             beta.kubernetes.io/arch=amd64
beta.kubernetes.io/os=linux
kubernetes.io/arch=amd64
kubernetes.io/hostname=k8s-master1
kubernetes.io/os=linux
node-role.kubernetes.io/control-plane=
node.kubernetes.io/exclude-from-external-load-balancers=
Annotations:        node.alpha.kubernetes.io/ttl: 0
volumes.kubernetes.io/controller-managed-attach-detach: true
CreationTimestamp:  Sat, 11 Apr 2026 18:41:40 +0800
Taints:             node-role.kubernetes.io/control-plane:NoSchedule
Unschedulable:      false
Lease:
HolderIdentity:  k8s-master1
AcquireTime:     <unset>
RenewTime:       Sun, 12 Apr 2026 22:14:13 +0800
Conditions:
Type             Status  LastHeartbeatTime                 LastTransitionTime                Reason                       Message
  ----             ------  -----------------                 ------------------                ------                       -------
MemoryPressure   False   Sun, 12 Apr 2026 22:14:04 +0800   Sat, 11 Apr 2026 18:41:39 +0800   KubeletHasSufficientMemory   kubelet has sufficient memory available
DiskPressure     False   Sun, 12 Apr 2026 22:14:04 +0800   Sat, 11 Apr 2026 18:41:39 +0800   KubeletHasNoDiskPressure     kubelet has no disk pressure
PIDPressure      False   Sun, 12 Apr 2026 22:14:04 +0800   Sat, 11 Apr 2026 18:41:39 +0800   KubeletHasSufficientPID      kubelet has sufficient PID available
Ready            True    Sun, 12 Apr 2026 22:14:04 +0800   Sat, 11 Apr 2026 18:50:13 +0800   KubeletReady                 kubelet is posting ready status
Addresses:
InternalIP:  192.168.10.134
Hostname:    k8s-master1
Capacity:
cpu:                4
ephemeral-storage:  51287520Ki
hugepages-1Gi:      0
hugepages-2Mi:      0
memory:             8083264Ki
pods:               110
Allocatable:
cpu:                4
ephemeral-storage:  47266578354
hugepages-1Gi:      0
hugepages-2Mi:      0
memory:             7980864Ki
pods:               110
System Info:
Machine ID:                 a795f3fe17b44d5a9618bac6ea84565a
System UUID:                e4784d56-fbfc-026f-2887-11ce69ec3107
Boot ID:                    fdaa51c0-1a4a-4a2c-bd8e-8291e74815c2
Kernel Version:             6.17.0-20-generic
OS Image:                   Ubuntu 24.04.4 LTS
Operating System:           linux
Architecture:               amd64
Container Runtime Version:  containerd://2.2.1
Kubelet Version:            v1.35.3
Kube-Proxy Version:
PodCIDR:                      10.244.0.0/24
PodCIDRs:                     10.244.0.0/24
Non-terminated Pods:          (6 in total)
Namespace                   Name                                   CPU Requests  CPU Limits  Memory Requests  Memory Limits  Age
  ---------                   ----                                   ------------  ----------  ---------------  -------------  ---
kube-system                 coredns-84f5bb5bf8-p9xtj               100m (2%)     0 (0%)      70Mi (0%)        170Mi (2%)     25h
kube-system                 etcd-k8s-master1                       100m (2%)     0 (0%)      100Mi (1%)       0 (0%)         25h
kube-system                 kube-apiserver-k8s-master1             250m (6%)     0 (0%)      0 (0%)           0 (0%)         25h
kube-system                 kube-controller-manager-k8s-master1    200m (5%)     0 (0%)      0 (0%)           0 (0%)         25h
kube-system                 kube-proxy-8ws2g                       0 (0%)        0 (0%)      0 (0%)           0 (0%)         25h
kube-system                 kube-scheduler-k8s-master1             100m (2%)     0 (0%)      0 (0%)           0 (0%)         25h
Allocated resources:
(Total limits may be over 100 percent, i.e., overcommitted.)
Resource           Requests    Limits
  --------           --------    ------
cpu                750m (18%)  0 (0%)
memory             170Mi (2%)  170Mi (2%)
ephemeral-storage  0 (0%)      0 (0%)
hugepages-1Gi      0 (0%)      0 (0%)
hugepages-2Mi      0 (0%)      0 (0%)
Events:
Type    Reason          Age   From             Message
  ----    ------          ----  ----             -------
Normal  RegisteredNode  36m   node-controller  Node k8s-master1 event: Registered Node k8s-master1 in Controller
```
```
kubectl describe nodes k8s-worker1
Name:               k8s-worker1
Roles:              <none>
Labels:             beta.kubernetes.io/arch=amd64
beta.kubernetes.io/os=linux
kubernetes.io/arch=amd64
kubernetes.io/hostname=k8s-worker1
kubernetes.io/os=linux
Annotations:        flannel.alpha.coreos.com/backend-data: {"VNI":1,"VtepMAC":"fa:7a:d7:a1:38:30"}
flannel.alpha.coreos.com/backend-type: vxlan
flannel.alpha.coreos.com/kube-subnet-manager: true
flannel.alpha.coreos.com/public-ip: 192.168.10.135
node.alpha.kubernetes.io/ttl: 0
volumes.kubernetes.io/controller-managed-attach-detach: true
CreationTimestamp:  Sat, 11 Apr 2026 19:02:48 +0800
Taints:             <none>
Unschedulable:      false
Lease:
HolderIdentity:  k8s-worker1
AcquireTime:     <unset>
RenewTime:       Sun, 12 Apr 2026 22:17:24 +0800
Conditions:
Type                 Status  LastHeartbeatTime                 LastTransitionTime                Reason                       Message
  ----                 ------  -----------------                 ------------------                ------                       -------
NetworkUnavailable   False   Sat, 11 Apr 2026 19:04:09 +0800   Sat, 11 Apr 2026 19:04:09 +0800   FlannelIsUp                  Flannel is running on this node
MemoryPressure       False   Sun, 12 Apr 2026 22:16:52 +0800   Sat, 11 Apr 2026 19:02:47 +0800   KubeletHasSufficientMemory   kubelet has sufficient memory available
DiskPressure         False   Sun, 12 Apr 2026 22:16:52 +0800   Sat, 11 Apr 2026 19:02:47 +0800   KubeletHasNoDiskPressure     kubelet has no disk pressure
PIDPressure          False   Sun, 12 Apr 2026 22:16:52 +0800   Sat, 11 Apr 2026 19:02:47 +0800   KubeletHasSufficientPID      kubelet has sufficient PID available
Ready                True    Sun, 12 Apr 2026 22:16:52 +0800   Sat, 11 Apr 2026 19:04:07 +0800   KubeletReady                 kubelet is posting ready status
Addresses:
InternalIP:  192.168.10.135
Hostname:    k8s-worker1
Capacity:
cpu:                4
ephemeral-storage:  51287520Ki
hugepages-1Gi:      0
hugepages-2Mi:      0
memory:             8083272Ki
pods:               110
Allocatable:
cpu:                4
ephemeral-storage:  47266578354
hugepages-1Gi:      0
hugepages-2Mi:      0
memory:             7980872Ki
pods:               110
System Info:
Machine ID:                 73b79d599ebb43fb90463289916b865c
System UUID:                20644d56-fdfe-bcf6-2e7e-258d6b9f1290
Boot ID:                    d7e058f3-3e7e-4342-be26-c3d96c575d4e
Kernel Version:             6.17.0-20-generic
OS Image:                   Ubuntu 24.04.4 LTS
Operating System:           linux
Architecture:               amd64
Container Runtime Version:  containerd://2.2.1
Kubelet Version:            v1.35.3
Kube-Proxy Version:
PodCIDR:                      10.244.1.0/24
PodCIDRs:                     10.244.1.0/24
Non-terminated Pods:          (2 in total)
Namespace                   Name                        CPU Requests  CPU Limits  Memory Requests  Memory Limits  Age
  ---------                   ----                        ------------  ----------  ---------------  -------------  ---
kube-system                 coredns-84f5bb5bf8-wgzvr    100m (2%)     0 (0%)      70Mi (0%)        170Mi (2%)     25h
kube-system                 kube-proxy-g25j8            0 (0%)        0 (0%)      0 (0%)           0 (0%)         25h
Allocated resources:
(Total limits may be over 100 percent, i.e., overcommitted.)
Resource           Requests   Limits
  --------           --------   ------
cpu                100m (2%)  0 (0%)
memory             70Mi (0%)  170Mi (2%)
ephemeral-storage  0 (0%)     0 (0%)
hugepages-1Gi      0 (0%)     0 (0%)
hugepages-2Mi      0 (0%)     0 (0%)
Events:
Type    Reason          Age   From             Message
  ----    ------          ----  ----             -------
Normal  RegisteredNode  39m   node-controller  Node k8s-worker1 event: Registered Node k8s-worker1 in Controller

kubectl get nodes --show-labels
NAME          STATUS   ROLES           AGE   VERSION   LABELS
k8s-master1   Ready    control-plane   27h   v1.35.3   beta.kubernetes.io/arch=amd64,beta.kubernetes.io/os=linux,kubernetes.io/arch=amd64,kubernetes.io/hostname=k8s-master1,kubernetes.io/os=linux,node-role.kubernetes.io/control-plane=,node.kubernetes.io/exclude-from-external-load-balancers=
k8s-worker1   Ready    <none>          27h   v1.35.3   beta.kubernetes.io/arch=amd64,beta.kubernetes.io/os=linux,kubernetes.io/arch=amd64,kubernetes.io/hostname=k8s-worker1,kubernetes.io/os=linux
```
```
kubectl label node k8s-master1 region=guangzhou
node/k8s-master1 labeled
kubectl get nodes --show-labels
NAME          STATUS   ROLES           AGE   VERSION   LABELS
k8s-master1   Ready    control-plane   27h   v1.35.3   beta.kubernetes.io/arch=amd64,beta.kubernetes.io/os=linux,kubernetes.io/arch=amd64,kubernetes.io/hostname=k8s-master1,kubernetes.io/os=linux,node-role.kubernetes.io/control-plane=,node.kubernetes.io/exclude-from-external-load-balancers=,region=guangzhou
k8s-worker1   Ready    <none>          27h   v1.35.3   beta.kubernetes.io/arch=amd64,beta.kubernetes.io/os=linux,kubernetes.io/arch=amd64,kubernetes.io/hostname=k8s-worker1,kubernetes.io/os=linux
```
```
kubectl get nodes -L region
NAME          STATUS   ROLES           AGE   VERSION   REGION
k8s-master1   Ready    control-plane   27h   v1.35.3   guangzhou
k8s-worker1   Ready    <none>          27h   v1.35.3
```
```
kubectl get nodes -l region=guangzhou
NAME          STATUS   ROLES           AGE   VERSION
k8s-master1   Ready    control-plane   27h   v1.35.3
```

# Kubernetes Pod YAML 字段说明表
| 字段 | 类型 | 说明 |
| :--- | :--- | :--- |
| `kind` | String | 这里指的是yaml文件定义的资源类型和角色，比如:Pod |
| `metadata` | Object | 元数据对象，固定值就写 `metadata` |
| `metadata.name` | String | 元数据对象的名字，这里由我们编写，比如命名Pod的名字 |
| `metadata.namespace` | String | 元数据对象的命名空间，由我们自身定义 |
| `Spec` | Object | 详细定义对象，固定值就写 `Spec` |
| `spec.containers[]` | list | 这里是Spec对象的容器列表定义，是个列表 |
| `spec.containers[].name` | String | 这里定义容器的名字 |
| `spec.containers[].image` | String | 这里定义要用到的镜像名称 |
| `spec.containers[].imagePullPolicy` | String | 定义镜像拉取策略，有 `Always`、`Never`、`IfNotPresent` 三个值可选：<br>(1) `Always`：意思是每次都尝试重新拉取镜像<br>(2) `Never`：表示仅使用本地镜像<br>(3) `IfNotPresent`：如果本地有镜像就使用本地镜像，没有就拉取在线镜像<br>上面三个值都没设置的话，默认是 `Always` |
| `spec.containers[].command[]` | List | 指定容器启动命令，因为是数组可以指定多个，不指定则使用镜像打包时使用的启动命令 |
| `spec.containers[].args[]` | List | 指定容器启动命令参数，因为是数组可以指定多个 |
| `spec.containers[].workDir` | String | 指定容器的工作目录 |
| `spec.containers[].volumeMounts[]` | List | 指定容器内部的存储卷配置 |
| `spec.containers[].volumeMounts[].name` | String | 指定可以被容器挂载的存储卷的名称 |
| `spec.containers[].volumeMounts[].mountPath` | String | 指定可以被容器挂载的存储卷的路径 |
| `spec.containers[].volumeMounts[].readOnly` | String | 设置存储卷路径的读写模式，`ture` 或者 `false`，默认为读写模式 |
| `spec.containers[].ports[]` | String | 指容器需要用到的端口列表 |
| `spec.containers[].ports[].name` | String | 指定端口名称 |
| `spec.containers[].ports[].containerPort` | String | 指定容器需要监听的端口号 |
| `spec.containers[].ports[].hostPort` | String | 指定容器所在主机需要监听的端口号，默认跟上面 `containerPort` 相同，注意设置了 `hostPort` 同一台主机无法启动该容器的相同副本(因为主机的端口号不能相同，这样会冲突) |
| `spec.containers[].ports[].protocol` | String | 指定端口协议，支持TCP和UDP，默认值为TCP |
| `spec.containers[].env[]` | List | 指定容器运行前需设的环境变量列表 |
| `spec.containers[].env[].name` | String | 指定环境变量名称 |
| `spec.containers[].env[].value` | String | 指定环境变量值 |
| `spec.containers[].resources` | Object | 指定资源限制和资源请求的值（这里开始就是设置容器的资源上限） |
| `spec.containers[].resources.limits` | Object | 指定设置容器运行时资源的运行上限 |
| `spec.containers[].resources.limits.cpu` | String | 指定CPU限制，单位为core数，将用于docker run --cpu-shares参数 |
| `spec.containers[].resources.limits.memory` | String | 指定MEM内存的限制，单位为MiB、GiB |
| `spec.containers[].resources.requests` | Object | 指定容器启动和调度时的限制设置 |
| `spec.containers[].resources.requests.cpu` | String | CPU请求，单位为core数，容器启动时初始化可用数量 |
| `spec.containers[].resources.requests.memory` | String | 内存请求，单位为MiB、GiB，容器启动时初始化可用数量 |
| `spec.restartPolicy` | String | 定义Pod的重启策略，可选值为Always、OnFailure，默认值为Always。<br>1. **Always**：Pod一旦终止运行，则无论容器时如何终止的，kubelet服务都将重启它。<br>2. **OnFailure**：只有Pod以非零退出码终止时，kubelet才会重启该容器。如果容器正常结束（退出码为0），则kubelet将不会重启它。<br>3. **Never**：Pod终止后，kubelet将退出码报告给Master，不会重启该Pod。 |
| `spec.nodeSelector` | Object | 定义Node的Label过滤标签，以`key:value`格式指定 |
| `spec.imagePullSecrets` | Object | 定义pull镜像时使用secret名称，以`name:secretkey`格式指定 |
| `spec.hostNetwork` | Boolean | 定义是否使用主机网络模式，默认值为false。设置true表示使用宿主机网络，不使用docker网桥，同时设置了true将无法在同一台宿主机上启动第二个副本。 |
