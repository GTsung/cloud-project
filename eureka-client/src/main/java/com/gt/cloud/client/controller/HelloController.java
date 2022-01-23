package com.gt.cloud.client.controller;

import com.gt.cloud.client.domain.Fuck;
import com.gt.cloud.client.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GTsung
 * @date 2022/1/22
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public Object sayHi() {
        return helloService.sayHello();
    }

    @GetMapping("/fuck")
    public Object fuck() {
        return new Fuck("LiuXiao", "his mother");
    }

    @GetMapping("fucking")
    public Object fucking(){
        return new Fuck("fuck", "LiuXiao's mother");
    }
}
