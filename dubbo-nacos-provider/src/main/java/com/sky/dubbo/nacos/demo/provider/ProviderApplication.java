package com.sky.dubbo.nacos.demo.provider;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.io.IOException;

@SpringBootApplication
@NacosPropertySource(dataId = "provider", autoRefreshed = true)
public class ProviderApplication {

    public static void main(String[] args) throws IOException {

        new SpringApplicationBuilder(ProviderApplication.class)
                .web(WebApplicationType.NONE).run(args);
    }
}
