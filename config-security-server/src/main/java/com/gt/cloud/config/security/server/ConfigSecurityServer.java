package com.gt.cloud.config.security.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author GTsung
 * @date 2022/1/23
 */
@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigSecurityServer {

    /**
     * security-config-server 帶有認證的config配置中心
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ConfigSecurityServer.class, args);
    }

}
