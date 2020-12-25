package com.xkcoding.log.aop;

import com.xkcoding.log.aop.service.BusinessService;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author laiyuan
 * @date 2020/12/25
 */
@Component
@SpringBootTest
@RunWith(SpringRunner.class)
public class MyController {

    @Autowired
    private BusinessService businessService;

    @Test
    public void a(){
        businessService.executeBuss();
    }
}
