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
