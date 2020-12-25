package com.xkcoding.log.aop.controller;

import lombok.experimental.UtilityClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author laiyuan
 * @date 2020/12/25
 */
@Component
public class MyController {
    public static void main(String[] args) {
        // 通过Java配置来实例化Spring容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);

        // 在Spring容器中获取Bean对象
        BusinessService businessService = context.getBean(BusinessService.class);
        businessService.executeBuss();


        // 销毁该容器
        context.destroy();

    }

    public void a(){
        System.out.println("方法主体");
    }
}
