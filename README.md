# dubbo-nacos-demo


## Introduction
- dubbo-nacos-demo
    - demo-api (API,Model 定义)
    - demo-provider (API实现)
    - demo-consumer (API调用)
    - demo-pom (项目依赖管理)
    - dependencies (依赖管理)
        - dependencies-zookeeper (zk 依赖管理)
        - dependencies-nacos (nacos 依赖管理)
        - dependencies-seata (seata 依赖管理)

## 服务启动
本项目编译依赖 maven , 运行依赖 jre
### demo-api
无需启动, 只提供依赖定义
### dependencies-zookeeper
zookeeper 注册中心依赖管理
### dependencies-nacos
nacos 注册中心依赖管理
### dependencies-seata
seata 分布式事务依赖管理
### demo-provider
进入 demo-provider 项目根目录, 编译
```bash
mvn clean install
```
注: 配置文件中 加入了 nacos/zk 两种配置, 默认选用的是 nacos, 如需修改, 可修改 spring.profiles.include 的引用
                                                        

启动服务
```bash
java -jar target/demo-provider-0.0.1-SNAPSHOT.jar
```
docker images 编译 并运行
```bash
mvn dockerfile:build
docker run -t -p 12345:12345 sky/demo-provider
```
> 服务可以启动多个, 端口会自动分配
### demo-consumer
进入 demo-consumer 项目根目录, 编译
```bash
mvn clean install
```
注: 配置文件中 加入了 nacos/zk 两种配置, 默认选用的是 nacos, 如需修改, 可修改 spring.profiles.include 的引用

启动服务
```bash
java -jar target/demo-consumer-0.0.1-SNAPSHOT.jar
```
docker images 编译 并运行
```bash
mvn dockerfile:build
docker run sky/demo-consumer

```

注: 

本例子使用的 [SKYhuangjing/dubbo-registry-nacos](https://github.com/SKYhuangjing/dubbo-registry-nacos) 是作者自己改造适配的

本例子使用的 [SKYhuangjing/dubbo-metadata-report-nacos](https://github.com/SKYhuangjing/dubbo-metadata-report-nacos) 是作者自己改造适配的

本例子使用的 [SKYhuangjing/dubbo-configcenter-nacos](https://github.com/SKYhuangjing/dubbo-configcenter-nacos) 是作者自己改造适配的

原型例子可参考小马哥提供的 [mercyblitz/dubbo-registry-nacos](
https://github.com/mercyblitz/dubbo-registry-nacos)