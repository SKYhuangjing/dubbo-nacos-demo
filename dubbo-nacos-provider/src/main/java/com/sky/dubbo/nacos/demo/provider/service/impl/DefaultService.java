package com.sky.dubbo.nacos.demo.provider.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import com.sky.dubbo.nacos.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Value;

@Service(version = "${demo.service.version}")
public class DefaultService implements DemoService {

    @Value("${demo.service.name}")
    private String serviceName;

    @Override
    public String sayName(String message) {

        RpcContext rpcContext = RpcContext.getContext();
        return String.format("Service [name :%s , port : %d] %s(\"%s\") : Hello,%s",
                serviceName,
                rpcContext.getLocalPort(),
                rpcContext.getMethodName(),
                message,
                message);
    }
}
