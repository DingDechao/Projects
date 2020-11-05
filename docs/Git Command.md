# Git
## 什么是Git
- 免费的
- 开源的
- 分布式的
- 版本控制系统SCM

## 为什么要用Git
- 分支
- 工作流
- 开源
- 高性能（20万commit，4万文件修改，一分钟之内切换）
- 抗故障和攻击的能力
- 离线开发和多点开发
- 可拓展性

## 关于命令行

## 基本概念
- 集中式版本控制系统
- 分布式版本控制系统

##### 查看版本信息
```
git --version
```

##### 查看用户名和邮箱
```
git config user.name
git config user.email
```

##### 配置用户名和邮箱
```
git config --global user.email "dingdechao_0486@163.com"
git config --global user.name "ddc"
git config --global alias.xx commit -->给 commit设置别名
```

##### 查看用户名和邮箱配置
```
git config --list
```

##### 将工作区（本地目录）文件提交到暂存区（介于本地仓库和工作区之间的一层）
```
git add filename1 filename2
git add -A | git add --all (添加所有文件)  -A 是--all的简写形式
```

##### 将暂存区提交到本地仓库中
```
git commit -m "备注信息" | git commit --message "备注信息" --> --m 是--message 的简写形式
```

##### 查看当前工作区相对于上次提交（commit）之后所有的修改，包括有没有add到暂存区，暂存区有哪些没有commit
```
git status
git status --short (显示精简信息)
```

##### 查看所有的不同|查看某个文件的不同
```
git diff  | git diff filename
git diff HEAD^! 比较HEAD和上一次提交^!）的不同
git diff 某一次提交 某一次提交  -限定目标（没试过）
git diff --staged (比较暂存区和版本库的区别）

默认的diff显示当前分支和要合并的分支
git config merge.conflictstyle diff3 （把父节点的信息也给出）
```

##### 对要删除的文件执行的命令
```
git rm filename
```

##### 查看项目提交历史(按时间降序排列)
```
git log
git log --oneline （在一行的简单形式）
git log --graph  (log的图形化版本)
git log --stat  (详细提交统计信息)
git log -n 3 （显示最后3次提交的信息）
git log --format=fuller （显示更多细节）
git log --dirstat  (显示修改文件的目录)
git log --shortstat (显示有多少修改，新增和删除的文件)
git log a..b (属于b而不属于a的提交)
```

##### 创建一个带有项目原始信息和整个项目历史的克隆版本
```
git clone 源目录 目标目录

创建一个不带工作区的共享版本库
git clone --bare  源目录 目标目录
```

##### 取回A的提交 B是从A clone得到的 所以B有A的路径，执行git pull B知道是从A那里获得最新的提交
```
git pull

取回B的提交  B是从A clone得到的 所以B有A的路径，但是A没有B的路径，所以需要显式写出来
git pull 目标路径 目标分支 --> 把目标路径的目标分支上的修改取回到当前分支
```

##### 把当前版本库的修改推送到目标版本库的目标分支上
```
git push 目标版本库 目标分支
```

##### 检查散列值和文件内容是否匹配确认版本库的完整性
```
git fsck
```

##### 重置当前的暂存区,把版本库中的文件恢复到暂存区，HEAD代表在版本库中最新的记录
```
git reset HEAD blah.txt
git reset —hard commit (把暂存区和工作区一起重置为commit的那个点上)
```

##### 把当前工作区和暂存区的内容存到stash stack中
```
git stash

恢复stash stack中的数据到工作区中
git stash pop (恢复最上面的数据)
git stash pop stash@{1}

检查stash stack中的数据
git stash list

清除stash stack里面的内容
git stash clear
```

##### 显示当前本地所有分支，带星号的是当前的分支
```
git branch

显示所有远程分支
git branch -r

显示所有本地和远程分支
git branch -a
```

##### 改变当前的分支
```
git checkout branchname
```

##### 为当前提交创建新的分支
```
git branch branchname

从现有分支创建新的分支
git branch new old

删除分支
git branch -d branch name
git branch -D branchname (强制删除分区)

恢复被删除的分支
1 git reflog （查看所有指针移动记录）
2 git branch branchname HEAD@{1} 恢复某个分支

创建并切换到新的分支上的快捷命令
git checkout -b newbranch
git checkout -b newbranch commitid --> 以commitid为起点创建newbranch并切换到这个新分支上
git checkout —force branchname （强制切换分区，当前分支的改动会丢失）

合并分支
切换到主分支
git merge branchname —> 把branchname分支合并到主分支

合并失败 应该用 git reset --merge取消合并
git merge —no-ff branchname （强制产生一次commit）
```

##### 使用二分法查找错误
```
git bisect 坏的提交 好的提交
。。。
```

##### git增加远程仓库关联
```
git remote add -t master 远程仓库名 远程仓库地址 --> 指定分支
git remote add  远程仓库名 远程仓库地址 --> 默认指向所有分支
git remote --verbose 显示可提交或推送的路径
git remote rm 远程仓库名 --> 删除某个远程仓库的关联
```

##### 获取操作
```
git fetch  --> 获取远程版本库上所有的不在本地的提交
```

##### 删除untracked file
```
git clean -n  路径  —> 查看哪些文件将被删除
git clean -f 路径 —> 删除untracked file
```

##### 从另外一个branch获取某个commit
```
git cherry-pick commitID
```

##### 列出已有的tag
```
git tag

创建一个带注解的tag
git tag -a v1.0 -m ""

把tag推送到远程仓库
git push origin tagName
```