package com.sky.dubbo.nacos.demo.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sky.dubbo.nacos.demo.service.DemoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.IOException;

@SpringBootApplication
public class ConsumerApplication {
    @Reference(version = "${demo.service.version}")
    private DemoService demoService;


    @PostConstruct
    public void init() {
        for (int i = 0; i < 10; i++) {
            System.out.println(demoService.sayName("Mercy"));
        }
    }

    public static void main(String[] args) throws IOException {
        new SpringApplication(ConsumerApplication.class).run(args);
    }
}
