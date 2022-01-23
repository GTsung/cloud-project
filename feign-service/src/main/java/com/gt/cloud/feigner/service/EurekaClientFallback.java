package com.gt.cloud.feigner.service;

import org.springframework.stereotype.Component;

/**
 * @author GTsung
 * @date 2022/1/22
 */
@Component
public class EurekaClientFallback implements FuckService {

    @Override
    public Object fuck() {
        return "fuck Liuxiao's mother";
    }

    @Override
    public Object fucking() {
        return "fuck LiuXiao's wife";
    }
}
