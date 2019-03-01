package com.sky.dubbo.nacos.demo.provider;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.io.IOException;

@SpringBootApplication
public class ProviderApplication {

    public static void main(String[] args) throws IOException {

        new SpringApplicationBuilder(ProviderApplication.class)
                .web(WebApplicationType.NONE).run(args);
    }
}
