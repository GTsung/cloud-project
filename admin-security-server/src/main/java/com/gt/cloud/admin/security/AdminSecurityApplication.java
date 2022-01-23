package com.gt.cloud.admin.security;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author GTsung
 * @date 2022/1/24
 */
@EnableAdminServer
@EnableDiscoveryClient
@SpringBootApplication
public class AdminSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminSecurityApplication.class, args);
    }

}
