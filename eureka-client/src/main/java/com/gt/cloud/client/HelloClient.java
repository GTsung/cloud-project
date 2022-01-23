package com.gt.cloud.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author GTsung
 * @date 2022/1/22
 */
@EnableDiscoveryClient
@SpringBootApplication
public class HelloClient {

    public static void main(String[] args) {
        SpringApplication.run(HelloClient.class, args);
    }

}
