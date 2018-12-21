package com.sky.dubbo.nacos.demo.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.sky.dubbo.nacos.demo.service.DemoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.IOException;

@SpringBootApplication
@NacosPropertySource(dataId = "example", autoRefreshed = true)
public class ConsumerApplication {

    @NacosValue(value = "${useLocalCache:Mercy}", autoRefreshed = true)
    private String useLocalCache;

    @Reference(version = "${demo.service.version}")
    private DemoService demoService;


    @PostConstruct
    public void init() {
        for (int i = 0; i < 10; i++) {
            System.out.println(demoService.sayName(useLocalCache));
        }
    }

    public static void main(String[] args) throws IOException {
        new SpringApplication(ConsumerApplication.class).run(args);
    }
}
