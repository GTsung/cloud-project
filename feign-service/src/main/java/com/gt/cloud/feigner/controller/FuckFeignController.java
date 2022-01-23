package com.gt.cloud.feigner.controller;

import com.gt.cloud.feigner.service.FuckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GTsung
 * @date 2022/1/22
 */
@RestController
public class FuckFeignController {

    @Autowired
    private FuckService eurekaClientService;

    @GetMapping("/fuck")
    public Object fuck() {
        return eurekaClientService.fuck();
    }

    @GetMapping("/fucking")
    public Object fucking() {
        return eurekaClientService.fucking();
    }

}
