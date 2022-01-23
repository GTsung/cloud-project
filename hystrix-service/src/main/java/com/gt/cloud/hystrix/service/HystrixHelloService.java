package com.gt.cloud.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author GTsung
 * @date 2022/1/22
 */
@Service
public class HystrixHelloService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${url.service}")
    private String helloServiceUrl;

    /**
     * 當服務不可用時，會回調defaultHello,
     * 這裏會有序列化的問題，當服務方返回的是String，這裏需要用String來接
     * 如果返回Object，則使用Object來接
     * @return
     */
    @HystrixCommand(fallbackMethod = "defaultHello")
    public Object sayHello() {
        System.out.println(helloServiceUrl);
        return restTemplate.getForObject(helloServiceUrl + "/hello", String.class);
    }

    public Object defaultHello() {
        return "hystrix.hello";
    }

    @HystrixCommand(fallbackMethod = "fuckLiuXiaoMother")
    public Object fuck() {
        return restTemplate.getForObject(helloServiceUrl + "/fuck", Object.class);
    }

    public Object fuckLiuXiaoMother() {
        return "fuck LiuXiao's mother";
    }
}
