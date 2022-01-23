package com.gt.cloud.oauth2.server.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GTsung
 * @date 2022/1/24
 */
@RestController
@RequestMapping("/user")
public class FuckLiuXiaoMotherController {

    @GetMapping("/getCurrentUser")
    public Object getCurrentUser(Authentication authentication) {
        return authentication.getPrincipal();
    }

}
