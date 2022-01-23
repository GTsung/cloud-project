package com.gt.cloud.hystrix.controller;

import com.gt.cloud.hystrix.service.HystrixHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GTsung
 * @date 2022/1/22
 */
@RestController
public class HelloHystrixController {

    @Autowired
    private HystrixHelloService helloService;

    /**
     * 調本地的helloService，本地的再通過restTemplate調用遠程服務，
     * 遠程不可用則返回默認
     * @return
     */
    @GetMapping("/hello")
    public Object hello() {
        return helloService.sayHello();
    }

    @GetMapping("fuck")
    public Object fuck() {
        return helloService.fuck();
    }
}
