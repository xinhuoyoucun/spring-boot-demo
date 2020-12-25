package com.xkcoding.log.aop.service;

import org.springframework.stereotype.Component;

/**
 * @author laiyuan
 * @date 2020/12/25
 */
@Component
public class BusinessService {
    public void executeBuss() {
        System.out.println("执行业务处理...");
    }
}
