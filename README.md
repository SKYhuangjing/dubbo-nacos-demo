# dubbo-nacos-demo


## Introduction
- dubbo-nacos-demo
    - dubbo-nacos-api (API,Model 定义)
    - dubbo-nacos-provider (API实现)
    - dubbo-nacos-consumer (API调用)
    - dubbo-nacos-pom (项目依赖管理)
    - dubbo-zookeeper-dependencies (zk依赖管理)
    - dubbo-nacos-dependencies (nacos依赖管理)

## 服务启动
本项目编译依赖 maven , 运行依赖 jre
### dubbo-nacos-api
无需启动, 只提供依赖定义
### dubbo-nacos-provider
进入 dubbo-nacos-provider 项目根目录, 编译
```bash
mvn clean install
```
启动服务
```bash
java -jar target/dubbo-nacos-provider-0.0.1-SNAPSHOT.jar
```
docker images 编译 并运行
```bash
mvn dockerfile:build
docker run -t -p 12345:12345 sky/dubbo-nacos-provider
```
> 服务可以启动多个, 端口会自动分配
### dubbo-nacos-consumer
进入 dubbo-nacos-consumer 项目根目录, 编译
```bash
mvn clean install
```
```bash
java -jar target/dubbo-nacos-consumer-0.0.1-SNAPSHOT.jar
```
docker images 编译 并运行
```bash
mvn dockerfile:build
docker run sky/dubbo-nacos-consumer

```

原型例子可参考 [dubbo-registry-nacos](
https://github.com/mercyblitz/dubbo-registry-nacos)