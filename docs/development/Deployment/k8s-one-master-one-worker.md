```
sudo apt install curl
[sudo] password for k8s-worknode1:
Reading package lists... Done
Building dependency tree... Done
Reading state information... Done
The following NEW packages will be installed:
curl
0 upgraded, 1 newly installed, 0 to remove and 82 not upgraded.
Need to get 227 kB of archives.
After this operation, 534 kB of additional disk space will be used.
Get:1 http://mirrors.tuna.tsinghua.edu.cn/ubuntu noble-updates/main amd64 curl amd64 8.5.0-2ubuntu10.8 [227 kB]
Fetched 227 kB in 1s (368 kB/s)
Selecting previously unselected package curl.
(Reading database ... 173276 files and directories currently installed.)
Preparing to unpack .../curl_8.5.0-2ubuntu10.8_amd64.deb ...
Unpacking curl (8.5.0-2ubuntu10.8) ...
Setting up curl (8.5.0-2ubuntu10.8) ...
Processing triggers for man-db (2.12.0-4build2) ...
```
```
sudo   curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
% Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
Dload  Upload   Total   Spent    Left  Speed
100 55.8M  100 55.8M    0     0  26.1M      0  0:00:02  0:00:02 --:--:-- 26.1M
```

```
sudo  curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl.sha256"
% Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
Dload  Upload   Total   Spent    Left  Speed
100    64  100    64    0     0    166      0 --:--:-- --:--:-- --:--:--   166
```

```
echo "$(cat kubectl.sha256)  kubectl" | sha256sum --check
kubectl: OK
```

```
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

```
kubectl version --client
Client Version: v1.35.3
Kustomize Version: v5.7.1
```

```
kubectl version --client --output=yaml
clientVersion:
buildDate: "2026-03-18T18:32:54Z"
compiler: gc
gitCommit: 6c1cd99aef09161ddb07b8ade6c9564e9b9bfe27
gitTreeState: clean
gitVersion: v1.35.3
goVersion: go1.25.7
major: "1"
minor: "35"
platform: linux/amd64
kustomizeVersion: v5.7.1
```

```
sudo vi /etc/fstab
# /etc/fstab: static file system information.
#
# Use 'blkid' to print the universally unique identifier for a
# device; this may be used with UUID= as a more robust way to name devices
# that works even if disks are added and removed. See fstab(5).
#
# <file system> <mount point>   <type>  <options>       <dump>  <pass>
# / was on /dev/sda2 during curtin installation
/dev/disk/by-uuid/9f763e54-a481-4818-b5c0-9cbe529ca37a / ext4 defaults 0 1
#/swap.img      none    swap    sw      0       0
```

```
sudo reboot
```

```
free -h
total        used        free      shared  buff/cache   available
Mem:           7.7Gi       1.5Gi       5.4Gi        42Mi       1.2Gi       6.2Gi
Swap:             0B          0B          0B
```

```
sudo ufw status
Status: inactive
```

```
sudo apt-get update
Hit:1 http://mirrors.tuna.tsinghua.edu.cn/ubuntu noble InRelease                                                                         
Hit:2 http://mirrors.tuna.tsinghua.edu.cn/ubuntu noble-updates InRelease                                           
Hit:3 http://mirrors.tuna.tsinghua.edu.cn/ubuntu noble-backports InRelease
Hit:4 http://security.ubuntu.com/ubuntu noble-security InRelease
Reading package lists... Done
```

```
sudo apt-get install -y apt-transport-https ca-certificates curl gpg
Reading package lists... Done
Building dependency tree... Done
Reading state information... Done
ca-certificates is already the newest version (20240203).
ca-certificates set to manually installed.
curl is already the newest version (8.5.0-2ubuntu10.8).
gpg is already the newest version (2.4.4-2ubuntu17.4).
gpg set to manually installed.
The following NEW packages will be installed:
apt-transport-https
0 upgraded, 1 newly installed, 0 to remove and 82 not upgraded.
Need to get 3,970 B of archives.
After this operation, 36.9 kB of additional disk space will be used.
Get:1 http://mirrors.tuna.tsinghua.edu.cn/ubuntu noble-updates/universe amd64 apt-transport-https all 2.8.3 [3,970 B]
Fetched 3,970 B in 0s (16.1 kB/s)               
Selecting previously unselected package apt-transport-https.
(Reading database ... 173283 files and directories currently installed.)
Preparing to unpack .../apt-transport-https_2.8.3_all.deb ...
Unpacking apt-transport-https (2.8.3) ...
Setting up apt-transport-https (2.8.3) ...
```

```
sudo curl -fsSL https://pkgs.k8s.io/core:/stable:/v1.35/deb/Release.key | sudo gpg --dearmor -o /etc/apt/keyrings/kubernetes-apt-keyring.gpg
```

```
echo 'deb [signed-by=/etc/apt/keyrings/kubernetes-apt-keyring.gpg] https://pkgs.k8s.io/core:/stable:/v1.35/deb/ /' | sudo tee /etc/apt/sources.list.d/kubernetes.list
deb [signed-by=/etc/apt/keyrings/kubernetes-apt-keyring.gpg] https://pkgs.k8s.io/core:/stable:/v1.35/deb/ /
```

```
sudo apt-get update
Hit:1 http://mirrors.tuna.tsinghua.edu.cn/ubuntu noble InRelease                                                                                             
Hit:2 http://mirrors.tuna.tsinghua.edu.cn/ubuntu noble-updates InRelease                                                                                     
Hit:3 http://mirrors.tuna.tsinghua.edu.cn/ubuntu noble-backports InRelease
Hit:5 http://security.ubuntu.com/ubuntu noble-security InRelease    
Get:4 https://prod-cdn.packages.k8s.io/repositories/isv:/kubernetes:/core:/stable:/v1.35/deb  InRelease [1,227 B]
Get:6 https://prod-cdn.packages.k8s.io/repositories/isv:/kubernetes:/core:/stable:/v1.35/deb  Packages [6,371 B]
Fetched 7,598 B in 1s (10.7 kB/s)     
Reading package lists... Done
```

```
sudo apt-get install -y kubelet kubeadm
Reading package lists... Done
Building dependency tree... Done
Reading state information... Done
The following additional packages will be installed:
cri-tools kubernetes-cni
The following NEW packages will be installed:
cri-tools kubeadm kubelet kubernetes-cni
0 upgraded, 4 newly installed, 0 to remove and 82 not upgraded.
Need to get 80.5 MB of archives.
After this operation, 269 MB of additional disk space will be used.
Get:1 https://prod-cdn.packages.k8s.io/repositories/isv:/kubernetes:/core:/stable:/v1.35/deb  cri-tools 1.35.0-1.1 [16.2 MB]
Get:2 https://prod-cdn.packages.k8s.io/repositories/isv:/kubernetes:/core:/stable:/v1.35/deb  kubeadm 1.35.3-1.1 [12.4 MB]
Get:3 https://prod-cdn.packages.k8s.io/repositories/isv:/kubernetes:/core:/stable:/v1.35/deb  kubernetes-cni 1.8.0-1.1 [38.9 MB]
Get:4 https://prod-cdn.packages.k8s.io/repositories/isv:/kubernetes:/core:/stable:/v1.35/deb  kubelet 1.35.3-1.1 [12.9 MB]
Fetched 80.5 MB in 2s (41.4 MB/s)
Selecting previously unselected package cri-tools.
(Reading database ... 173287 files and directories currently installed.)
Preparing to unpack .../cri-tools_1.35.0-1.1_amd64.deb ...
Unpacking cri-tools (1.35.0-1.1) ...
Selecting previously unselected package kubeadm.
Preparing to unpack .../kubeadm_1.35.3-1.1_amd64.deb ...
Unpacking kubeadm (1.35.3-1.1) ...
Selecting previously unselected package kubernetes-cni.
Preparing to unpack .../kubernetes-cni_1.8.0-1.1_amd64.deb ...
Unpacking kubernetes-cni (1.8.0-1.1) ...
Selecting previously unselected package kubelet.
Preparing to unpack .../kubelet_1.35.3-1.1_amd64.deb ...
Unpacking kubelet (1.35.3-1.1) ...
Setting up cri-tools (1.35.0-1.1) ...
Setting up kubernetes-cni (1.8.0-1.1) ...
Setting up kubeadm (1.35.3-1.1) ...
Setting up kubelet (1.35.3-1.1) ...
```

```
sudo apt-mark hold kubelet kubeadm kubectl
kubelet set on hold.
kubeadm set on hold.
kubectl set on hold.
```

```
sudo modprobe overlay
sudo modprobe br_netfilter
```

```
cat <<EOF | sudo tee /etc/sysctl.d/k8s.conf
net.bridge.bridge-nf-call-iptables  = 1
net.bridge.bridge-nf-call-ip6tables = 1
net.ipv4.ip_forward                 = 1
EOF
net.bridge.bridge-nf-call-iptables  = 1
net.bridge.bridge-nf-call-ip6tables = 1
net.ipv4.ip_forward                 = 1
```


```
sudo sysctl --system
* Applying /usr/lib/sysctl.d/10-apparmor.conf ...
* Applying /etc/sysctl.d/10-bufferbloat.conf ...
* Applying /etc/sysctl.d/10-console-messages.conf ...
* Applying /etc/sysctl.d/10-ipv6-privacy.conf ...
* Applying /etc/sysctl.d/10-kernel-hardening.conf ...
* Applying /etc/sysctl.d/10-magic-sysrq.conf ...
* Applying /etc/sysctl.d/10-map-count.conf ...
* Applying /etc/sysctl.d/10-network-security.conf ...
* Applying /etc/sysctl.d/10-ptrace.conf ...
* Applying /etc/sysctl.d/10-zeropage.conf ...
* Applying /usr/lib/sysctl.d/30-tracker.conf ...
* Applying /usr/lib/sysctl.d/50-bubblewrap.conf ...
* Applying /usr/lib/sysctl.d/50-pid-max.conf ...
* Applying /usr/lib/sysctl.d/99-protect-links.conf ...
* Applying /etc/sysctl.d/99-sysctl.conf ...
* Applying /etc/sysctl.d/k8s.conf ...
* Applying /etc/sysctl.conf ...
  kernel.apparmor_restrict_unprivileged_userns = 1
  net.core.default_qdisc = fq_codel
  kernel.printk = 4 4 1 7
  net.ipv6.conf.all.use_tempaddr = 2
  net.ipv6.conf.default.use_tempaddr = 2
  kernel.kptr_restrict = 1
  kernel.sysrq = 176
  vm.max_map_count = 1048576
  net.ipv4.conf.default.rp_filter = 2
  net.ipv4.conf.all.rp_filter = 2
  kernel.yama.ptrace_scope = 1
  vm.mmap_min_addr = 65536
  fs.inotify.max_user_watches = 65536
  kernel.unprivileged_userns_clone = 1
  kernel.pid_max = 4194304
  fs.protected_fifos = 1
  fs.protected_hardlinks = 1
  fs.protected_regular = 2
  fs.protected_symlinks = 1
  net.bridge.bridge-nf-call-iptables = 1
  net.bridge.bridge-nf-call-ip6tables = 1
  net.ipv4.ip_forward = 1
```

```
sudo reboot
```

```
sudo apt update
Hit:1 http://mirrors.tuna.tsinghua.edu.cn/ubuntu noble InRelease                                                   
Hit:2 http://mirrors.tuna.tsinghua.edu.cn/ubuntu noble-updates InRelease                                           
Hit:4 http://security.ubuntu.com/ubuntu noble-security InRelease
Hit:3 http://mirrors.tuna.tsinghua.edu.cn/ubuntu noble-backports InRelease
Hit:5 https://prod-cdn.packages.k8s.io/repositories/isv:/kubernetes:/core:/stable:/v1.35/deb  InRelease
Reading package lists... Done              
Building dependency tree... Done
Reading state information... Done
82 packages can be upgraded. Run 'apt list --upgradable' to see them.
```

```
sudo apt install -y containerd
Reading package lists... Done
Building dependency tree... Done
Reading state information... Done
The following additional packages will be installed:
runc
The following NEW packages will be installed:
containerd runc
0 upgraded, 2 newly installed, 0 to remove and 82 not upgraded.
Need to get 37.7 MB of archives.
After this operation, 140 MB of additional disk space will be used.
Get:1 http://cn.archive.ubuntu.com/ubuntu noble-updates/main amd64 runc amd64 1.3.4-0ubuntu1~24.04.1 [9,574 kB]
Get:2 http://cn.archive.ubuntu.com/ubuntu noble-updates/main amd64 containerd amd64 2.2.1-0ubuntu1~24.04.2 [28.1 MB]
Fetched 37.7 MB in 2s (21.3 MB/s)     
Selecting previously unselected package runc.
(Reading database ... 173337 files and directories currently installed.)
Preparing to unpack .../runc_1.3.4-0ubuntu1~24.04.1_amd64.deb ...
Unpacking runc (1.3.4-0ubuntu1~24.04.1) ...
Selecting previously unselected package containerd.
Preparing to unpack .../containerd_2.2.1-0ubuntu1~24.04.2_amd64.deb ...
Unpacking containerd (2.2.1-0ubuntu1~24.04.2) ...
Setting up runc (1.3.4-0ubuntu1~24.04.1) ...
Setting up containerd (2.2.1-0ubuntu1~24.04.2) ...
Created symlink /etc/systemd/system/multi-user.target.wants/containerd.service → /usr/lib/systemd/system/containerd.service.
Processing triggers for man-db (2.12.0-4build2) ...
```

```
sudo mkdir -p /etc/containerd/
sudo containerd config default | sudo tee /etc/containerd/config.toml
version = 3
root = '/var/lib/containerd'
state = '/run/containerd'
temp = ''
disabled_plugins = []
required_plugins = []
oom_score = 0
imports = ['/etc/containerd/conf.d/*.toml']

[grpc]
address = '/run/containerd/containerd.sock'
tcp_address = ''
tcp_tls_ca = ''
tcp_tls_cert = ''
tcp_tls_key = ''
uid = 0
gid = 0
max_recv_message_size = 16777216
max_send_message_size = 16777216
tcp_tls_common_name = ''

[ttrpc]
address = ''
uid = 0
gid = 0

[debug]
address = ''
uid = 0
gid = 0
level = ''
format = ''

[metrics]
address = ''
grpc_histogram = false

[plugins]
[plugins.'io.containerd.cri.v1.images']
snapshotter = 'overlayfs'
disable_snapshot_annotations = true
discard_unpacked_layers = false
max_concurrent_downloads = 3
concurrent_layer_fetch_buffer = 0
image_pull_progress_timeout = '5m0s'
image_pull_with_sync_fs = false
stats_collect_period = 10
use_local_image_pull = false

    [plugins.'io.containerd.cri.v1.images'.pinned_images]
      sandbox = 'registry.aliyuncs.com/google_containers/pause::3.10.1'

    [plugins.'io.containerd.cri.v1.images'.registry]
      config_path = '/etc/containerd/certs.d:/etc/docker/certs.d'

    [plugins.'io.containerd.cri.v1.images'.image_decryption]
      key_model = 'node'

[plugins.'io.containerd.cri.v1.runtime']
enable_selinux = false
selinux_category_range = 1024
max_container_log_line_size = 16384
disable_apparmor = false
restrict_oom_score_adj = false
disable_proc_mount = false
unset_seccomp_profile = ''
tolerate_missing_hugetlb_controller = true
disable_hugetlb_controller = true
device_ownership_from_security_context = false
ignore_image_defined_volumes = false
netns_mounts_under_state_dir = false
enable_unprivileged_ports = true
enable_unprivileged_icmp = true
enable_cdi = true
cdi_spec_dirs = ['/etc/cdi', '/var/run/cdi']
drain_exec_sync_io_timeout = '0s'
ignore_deprecation_warnings = []

    [plugins.'io.containerd.cri.v1.runtime'.containerd]
      default_runtime_name = 'runc'
      ignore_blockio_not_enabled_errors = false
      ignore_rdt_not_enabled_errors = false

      [plugins.'io.containerd.cri.v1.runtime'.containerd.runtimes]
        [plugins.'io.containerd.cri.v1.runtime'.containerd.runtimes.runc]
          runtime_type = 'io.containerd.runc.v2'
          runtime_path = ''
          pod_annotations = []
          container_annotations = []
          privileged_without_host_devices = false
          privileged_without_host_devices_all_devices_allowed = false
          cgroup_writable = false
          base_runtime_spec = ''
          cni_conf_dir = ''
          cni_max_conf_num = 0
          snapshotter = ''
          sandboxer = 'podsandbox'
          io_type = ''

          [plugins.'io.containerd.cri.v1.runtime'.containerd.runtimes.runc.options]
            BinaryName = ''
            CriuImagePath = ''
            CriuWorkPath = ''
            IoGid = 0
            IoUid = 0
            NoNewKeyring = false
            Root = ''
            ShimCgroup = ''
            SystemdCgroup = false

    [plugins.'io.containerd.cri.v1.runtime'.cni]
      bin_dir = ''
      bin_dirs = ['/opt/cni/bin']
      conf_dir = '/etc/cni/net.d'
      max_conf_num = 1
      setup_serially = false
      conf_template = ''
      ip_pref = ''
      use_internal_loopback = false

[plugins.'io.containerd.differ.v1.erofs']
mkfs_options = []
enable_tar_index = false

[plugins.'io.containerd.gc.v1.scheduler']
pause_threshold = 0.02
deletion_threshold = 0
mutation_threshold = 100
schedule_delay = '0s'
startup_delay = '100ms'

[plugins.'io.containerd.grpc.v1.cri']
disable_tcp_service = true
stream_server_address = '127.0.0.1'
stream_server_port = '0'
stream_idle_timeout = '4h0m0s'
enable_tls_streaming = false

    [plugins.'io.containerd.grpc.v1.cri'.x509_key_pair_streaming]
      tls_cert_file = ''
      tls_key_file = ''

[plugins.'io.containerd.image-verifier.v1.bindir']
bin_dir = '/opt/containerd/image-verifier/bin'
max_verifiers = 10
per_verifier_timeout = '10s'

[plugins.'io.containerd.internal.v1.opt']
path = '/opt/containerd'

[plugins.'io.containerd.internal.v1.tracing']

[plugins.'io.containerd.metadata.v1.bolt']
content_sharing_policy = 'shared'
no_sync = false

[plugins.'io.containerd.monitor.container.v1.restart']
interval = '10s'

[plugins.'io.containerd.monitor.task.v1.cgroups']
no_prometheus = false

[plugins.'io.containerd.mount-handler.v1.erofs']

[plugins.'io.containerd.nri.v1.nri']
disable = false
socket_path = '/var/run/nri/nri.sock'
plugin_path = '/opt/nri/plugins'
plugin_config_path = '/etc/nri/conf.d'
plugin_registration_timeout = '5s'
plugin_request_timeout = '2s'
disable_connections = false

    [plugins.'io.containerd.nri.v1.nri'.default_validator]
      enable = false
      reject_oci_hook_adjustment = false
      reject_runtime_default_seccomp_adjustment = false
      reject_unconfined_seccomp_adjustment = false
      reject_custom_seccomp_adjustment = false
      reject_namespace_adjustment = false
      reject_sysctl_adjustment = false
      required_plugins = []
      tolerate_missing_plugins_annotation = ''

[plugins.'io.containerd.runtime.v2.task']
platforms = ['linux/amd64']

[plugins.'io.containerd.service.v1.diff-service']
default = ['walking']
sync_fs = false

[plugins.'io.containerd.service.v1.tasks-service']
blockio_config_file = ''
rdt_config_file = ''

[plugins.'io.containerd.shim.v1.manager']
env = []

[plugins.'io.containerd.snapshotter.v1.blockfile']
root_path = ''
scratch_file = ''
fs_type = ''
mount_options = []
recreate_scratch = false

[plugins.'io.containerd.snapshotter.v1.btrfs']
root_path = ''

[plugins.'io.containerd.snapshotter.v1.devmapper']
root_path = ''
pool_name = ''
base_image_size = ''
async_remove = false
discard_blocks = false
fs_type = ''
fs_options = ''

[plugins.'io.containerd.snapshotter.v1.erofs']
root_path = ''
ovl_mount_options = []
enable_fsverity = false
set_immutable = false
default_size = ''

[plugins.'io.containerd.snapshotter.v1.native']
root_path = ''

[plugins.'io.containerd.snapshotter.v1.overlayfs']
root_path = ''
upperdir_label = false
sync_remove = false
slow_chown = false
mount_options = []

[plugins.'io.containerd.snapshotter.v1.zfs']
root_path = ''

[plugins.'io.containerd.tracing.processor.v1.otlp']

[plugins.'io.containerd.transfer.v1.local']
max_concurrent_downloads = 3
concurrent_layer_fetch_buffer = 0
max_concurrent_uploaded_layers = 3
check_platform_supported = false
config_path = ''
max_concurrent_unpacks = 1

[cgroup]
path = ''

[timeouts]
'io.containerd.timeout.bolt.open' = '0s'
'io.containerd.timeout.cri.defercleanup' = '1m0s'
'io.containerd.timeout.metrics.shimstats' = '2s'
'io.containerd.timeout.shim.cleanup' = '5s'
'io.containerd.timeout.shim.load' = '5s'
'io.containerd.timeout.shim.shutdown' = '3s'
'io.containerd.timeout.task.state' = '2s'

[stream_processors]
[stream_processors.'io.containerd.ocicrypt.decoder.v1.tar']
accepts = ['application/vnd.oci.image.layer.v1.tar+encrypted']
returns = 'application/vnd.oci.image.layer.v1.tar'
path = 'ctd-decoder'
args = ['--decryption-keys-path', '/etc/containerd/ocicrypt/keys']
env = ['OCICRYPT_KEYPROVIDER_CONFIG=/etc/containerd/ocicrypt/ocicrypt_keyprovider.conf']

[stream_processors.'io.containerd.ocicrypt.decoder.v1.tar.gzip']
accepts = ['application/vnd.oci.image.layer.v1.tar+gzip+encrypted']
returns = 'application/vnd.oci.image.layer.v1.tar+gzip'
path = 'ctd-decoder'
args = ['--decryption-keys-path', '/etc/containerd/ocicrypt/keys']
env = ['OCICRYPT_KEYPROVIDER_CONFIG=/etc/containerd/ocicrypt/ocicrypt_keyprovider.conf']
```

```
sudo sed -i 's/SystemdCgroup \= false/SystemdCgroup \= true/g' /etc/containerd/config.toml
sudo cat /etc/containerd/config.toml | grep SystemdCgroup

# 要自己去改，实际不是这个名字
################################sudo sed -i 's|sandbox_image = "registry.k8s.io/pause:.*"|sandbox_image = "registry.aliyuncs.com/google_containers/pause:3.10.1"|' /etc/containerd/config.toml

sudo systemctl restart containerd
sudo systemctl enable containerd
```

```
ip addr
```

```
sudo kubeadm init --apiserver-advertise-address=192.168.10.131 --pod-network-cidr=10.244.0.0/16
```

```
sudo systemctl daemon-reload
sudo systemctl restart containerd
sudo systemctl restart kubelet
sudo kubeadm reset -f
```

```
sudo kubeadm init \
--apiserver-advertise-address=192.168.10.134 \
--image-repository=registry.aliyuncs.com/google_containers \
--pod-network-cidr=10.244.0.0/16

Your Kubernetes control-plane has initialized successfully!

To start using your cluster, you need to run the following as a regular user:
```

```
mkdir -p $HOME/.kube
sudo cp -i /etc/kubernetes/admin.conf $HOME/.kube/config
sudo chown $(id -u):$(id -g) $HOME/.kube/config

Alternatively, if you are the root user, you can run:

export KUBECONFIG=/etc/kubernetes/admin.conf

You should now deploy a pod network to the cluster.
Run "kubectl apply -f [podnetwork].yaml" with one of the options listed at:
https://kubernetes.io/docs/concepts/cluster-administration/addons/

Then you can join any number of worker nodes by running the following on each as root:

kubeadm join 192.168.10.134:6443 --token h6xkmo.jfx36wydllwlyq5g \
--discovery-token-ca-cert-hash sha256:5b95fa48daa5bc90a8c28e3982dd42b7aa37876522416610fbc9d4be7f8df159
```

```
mkdir -p $HOME/.kube
sudo cp -i /etc/kubernetes/admin.conf $HOME/.kube/config
sudo chown $(id -u):$(id -g) $HOME/.kube/config
```

```
sudo modprobe ip_tables
sudo modprobe ip6_tables
sudo modprobe nf_conntrack
sudo modprobe br_netfilter
```

```
cat <<EOF | sudo tee /etc/modules-load.d/k8s.conf
overlay
br_netfilter
nf_conntrack
ip_tables
ip6_tables
EOF
```

```
sudo sysctl --system
sudo systemctl restart containerd
sudo systemctl restart kubelet
```

```
sudo apt install -y containernetworking-plugins
Reading package lists... Done
Building dependency tree... Done
Reading state information... Done
The following NEW packages will be installed:
containernetworking-plugins
0 upgraded, 1 newly installed, 0 to remove and 82 not upgraded.
Need to get 7,203 kB of archives.
After this operation, 49.3 MB of additional disk space will be used.
Get:1 http://cn.archive.ubuntu.com/ubuntu noble-updates/universe amd64 containernetworking-plugins amd64 1.1.1+ds1-3ubuntu0.24.04.3 [7,203 kB]
Fetched 7,203 kB in 1s (7,272 kB/s)                      
Selecting previously unselected package containernetworking-plugins.
(Reading database ... 173401 files and directories currently installed.)
Preparing to unpack .../containernetworking-plugins_1.1.1+ds1-3ubuntu0.24.04.3_amd64.deb ...
Unpacking containernetworking-plugins (1.1.1+ds1-3ubuntu0.24.04.3) ...
Setting up containernetworking-plugins (1.1.1+ds1-3ubuntu0.24.04.3) ...
```

```
sudo mkdir -p /opt/cni/bin
sudo mkdir -p /etc/cni/net.d
sudo tee /etc/cni/net.d/10-bridge.conf <<EOF
{
"cniVersion": "0.3.1",
"name": "bridge-network",
"type": "bridge",
"bridge": "cni0",
"isGateway": true,
"ipMasq": true,
"ipam": {
"type": "host-local",
"subnet": "10.244.0.0/16",
"routes": [{"dst": "0.0.0.0/0"}]
}
}
EOF
```

```
sudo systemctl restart containerd
sudo systemctl restart kubelet
```

```
kubectl delete pods -n kube-system -l k8s-app=kube-dns
```