package com.sky.dubbo.nacos.demo.consumer;

import com.sky.dubbo.nacos.demo.service.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    @Reference(version = "${demo.service.version}", lazy = false)
    private DemoService demoService;

    @RequestMapping(value = "/say/{name}", method = RequestMethod.GET)
    public String say(@PathVariable("name") String name) {
        return "Hello Nacos!" + demoService.sayName(name);
    }
}
