<!-- Java→SRE 6 个月冲刺路线图 -->
<!-- 保存为 Java2SRE-Roadmap.md 即可离线使用 -->

# Java 程序员转 SRE 学习路线（6 个月·28 周）

> 最后更新：2025-10-16

## 总览（4 大里程碑）
| 里程碑 | 周 | 关键词 | 交付物（DoD） |
| --- | --- | --- | --- |
| M1 基础通关 | 1-4 | Linux／Python／云主机 | 订单服务在阿里云 ECS 跑通；Python 脚本采集指标并画图 |
| M2 自动化 | 5-10 | Docker／K8s／CI/CD／Terraform | 服务容器化；GitLab CI 灰度；Terraform 一键开环境 |
| M3 可观测 | 11-16 | Prometheus／ELK／Jaeger |  dashboards 看 P99；ELK 搜 traceId；1 min 内飞书告警 |
| M4 高可用+面试 | 17-24 | 压测／限流／多 AZ／故障演练 | 单实例→3 AZ；Chaos 注入 30 s 业务无损；面试题清单 |

---

## 月度/周计划 & 打卡复选框

### M1 基础通关（第 1 个月）
- [ ] **Week01 Linux 基础**
    - [ ] 开 1 台 Ubuntu 22.04 ECS
    - [ ] systemd 守护订单服务
    - [ ] 博客：Systemd Unit 模板

- [ ] **Week02 Python 脚本**
    - [ ] `pip install psutil matplotlib`
    - [ ] `metrics.py` 每 10 s 写 CSV 并画图
    - [ ] 截图折线图贴博客

- [ ] **Week03 网络 & Nginx**
    - [ ] 画 HTTP 流程图
    - [ ] Nginx 反向代理到 8080
    - [ ] `curl -H "Host: api.demo.com"` 返回订单 JSON

- [ ] **Week04 云 CLI**
    - [ ] 阿里云 CLI 创建 ECS+安全组
    - [ ] 一键脚本 `create_ecs.sh` ≤30 s 输出公网 IP
    - [ ] 记录费用截图

---

### M2 自动化（第 2 个月）
- [ ] **Week05 Docker**
    - [ ] Dockerfile 多阶段构建 <100 MB
    - [ ] `docker run -p 8080:8080` 注册订单成功
    - [ ] `dive` 镜像层分析截图

- [ ] **Week06 Docker Compose**
    - [ ] 编排 `order + mysql`
    - [ ] 数据卷持久化
    - [ ] `docker-compose down && up` 数据仍在

- [ ] **Week07 K8s 基础**
    - [ ] minikube 启动
    - [ ] Deployment 3 副本 + Service NodePort
    - [ ] `kubectl get po` 全 READY 截图

- [ ] **Week08 GitLab CI**
    - [ ] `.gitlab-ci.yml` 三阶段
    - [ ] 镜像推 ACR
    - [ ] CI 耗时 <5 min 截图

- [ ] **Week09 Terraform**
    - [ ] 写 `main.tf` 创建 VPC/ECS/RDS
    - [ ] 远端 OSS 状态锁
    - [ ] `terraform apply` 0 人工确认

- [ ] **Week10 K8s 灰度**
    - [ ] 滚动更新策略
    - [ ] `kubectl set image` 灰度发布
    - [ ] `rollout status` 完成截图

---

### M3 可观测（第 3 个月）
- [ ] **Week11 Prometheus**
    - [ ] Helm 安装 kube-prometheus-stack
    - [ ] Spring Boot 暴露 `/actuator/prometheus`
    - [ ] Grafana 默认 JVM 面板截图

- [ ] **Week12 自定义指标**
    - [ ] Micrometer 埋点 `order_created_total`
    - [ ] Prometheus 能查到指标
    - [ ] 告警规则 YAML Git 提交

- [ ] **Week13 ELK**
    - [ ] Filebeat→Logstash→Kibana
    - [ ] 容器 stdout JSON 解析
    - [ ] Kibana 搜 `traceId` 截图

- [ ] **Week14 分布式追踪**
    - [ ] Jaeger agent DaemonSet
    - [ ] Spring Cloud 依赖
    - [ ] Jaeger UI 10 个 span 截图

- [ ] **Week15 告警通道**
    - [ ] Alertmanager → 飞书机器人
    - [ ] 手动飙高 CPU 触发告警
    - [ ] 1 min 内飞书卡片截图

- [ ] **Week16 复盘文档**
    - [ ] 写《可观测性落地手册》
    - [ ] 画架构图（Prom/ELK/Jaeger）
    - [ ] 发布博客/ GitBook

---

### M4 高可用 & 面试（第 4-6 个月）
- [ ] **Week17 压测**
    - [ ] JMeter 阶梯线程组
    - [ ] 找出 95% RT 拐点
    - [ ] 上传 `.jmx` & 报告

- [ ] **Week18 调优**
    - [ ] HikariCP 连接池调优
    - [ ] MySQL 联合索引
    - [ ] 同压测 QPS +30% 截图

- [ ] **Week19 限流熔断**
    - [ ] Sentinel 接入
    - [ ] 100 QPS 限流规则
    - [ ] 压测返回 429 截图

- [ ] **Week20 多可用区**
    - [ ] SLB + 3 ECS 跨 AZ
    - [ ] RDS 主备
    - [ ] 关一台 ECS 0 中断截图

- [ ] **Week21 Chaos Mesh**
    - [ ] 网络延迟 100 ms 注入
    - [ ] Grafana RT 曲线上升/恢复截图

- [ ] **Week22 灾备演练**
    - [ ] 模拟 AZ 故障
    - [ ] 数据零丢
    - [ ] RTO/RPO 报告

- [ ] **Week23 On-Call 手册**
    - [ ] P0-P3 定义
    - [ ] 升级策略/轮值表
    - [ ] GitBook 公开链接

- [ ] **Week24 复盘分享**
    - [ ] 内部 Tech Talk
    - [ ] B 站录屏
    - [ ] 反馈表 ≥4.5/5

- [ ] **Week25 简历重构**
    - [ ] 3 条 STAR 项目
    - [ ] 量化数据
    - [ ] 一页 PDF + GitHub README

- [ ] **Week26 面试题**
    - [ ] 50 道高频题 Anki 化
    - [ ] 博客 Top 20 解析
    - [ ] 录音自答 5 min

- [ ] **Week27 模拟面试**
    - [ ] 3 轮视频模拟
    - [ ] 问题清单 30 条
    - [ ] 改进思维导图

- [ ] **Week28 投递 & 复盘**
    - [ ] 日均 10 份
    - [ ] Offer 对比表
    - [ ] 最终选择理由博客

---

## 配套资源（全部开源）
| 名称 | 地址 | 说明 |
| --- | --- | --- |
| 订单服务模板 | https://github.com/yourname/order-demo | Spring-Boot 3.x + MySQL 8 |
| 脚本/配置 | 同仓库 `/ops` 目录 | Dockerfile, docker-compose.yml, gitlab-ci.yml, Terraform 模块 |
| 直播答疑 | B 站房间号 123456 | 每周三 21:00 演示本周 DoD |
| 打卡群 | 飞书群“Java→SRE 6 个月冲刺营” | 上传截图即打卡，机器人统计连续天数 |

---

## 使用小贴士
1. 把本文件用 Typora / VS Code 打开，左侧大纲可快速跳转。
2. 每完成一条 `- [ ]` 单击复选框变成 `- [x]`，自动保存进度。
3. 文件顶部“最后更新”时间戳供日后对比新版，直接覆盖旧文件即可。

> 祝 6 个月后拿到心仪 SRE Offer！
