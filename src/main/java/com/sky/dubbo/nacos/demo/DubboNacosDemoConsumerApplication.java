package com.sky.dubbo.nacos.demo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sky.dubbo.nacos.demo.service.DemoService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

@EnableAutoConfiguration
public class DubboNacosDemoConsumerApplication {
    @Reference(version = "${demo.service.version}")
    private DemoService demoService;


    @PostConstruct
    public void init() {
        for (int i = 0; i < 10; i++) {
            System.out.println(demoService.sayName("Mercy"));
        }
    }

    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        URL url = ApplicationRunner.class.getClassLoader().getResource("consumer.properties");
        prop.load(url.openStream());
        SpringApplication app = new SpringApplication(DubboNacosDemoConsumerApplication.class);
        app.setDefaultProperties(prop);
        app.run(args);
    }
}
