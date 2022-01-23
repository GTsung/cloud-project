package com.gt.cloud.feigner.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "eureka-client", fallback = EurekaClientFallback.class)
public interface FuckService {

    @GetMapping("/fuck")
    Object fuck();

    @GetMapping("fucking")
    Object fucking();
}
