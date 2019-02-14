package com.sky.dubbo.nacos.demo.provider.service.impl;


import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.sky.dubbo.nacos.demo.service.DemoService;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.beans.factory.annotation.Value;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("demo")
@Service(version = "${demo.service.version}", protocol = {"dubbo", "rest"},
        registry = "${dubbo.registry.id}")
public class DefaultService implements DemoService {

    @Value("${demo.service.name}")
    private String serviceName;

    @NacosValue(value = "${nacosValue:N/A}", autoRefreshed = true)
    private String nacosValue;

    @GET
    @Path("/say-hello")
    @Override
    public String sayName(@QueryParam("message") String message) {

        RpcContext rpcContext = RpcContext.getContext();
        return String.format("Service [name :%s , port : %d] %s(\"%s\") : Hello,%s",
                serviceName,
                rpcContext.getLocalPort(),
                rpcContext.getMethodName(),
                nacosValue,
                message);
    }
}
