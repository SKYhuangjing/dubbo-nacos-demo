package com.sky.dubbo.nacos.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

@EnableAutoConfiguration
public class DubboNacosDemoApplication {

    public static void main(String[] args) throws IOException {

        Properties prop = new Properties();
        URL url = ApplicationRunner.class.getClassLoader().getResource("provider.properties");
        prop.load(url.openStream());

        new SpringApplicationBuilder(DubboNacosDemoApplication.class)
                .web(WebApplicationType.NONE).properties(prop).run(args);
    }
}
