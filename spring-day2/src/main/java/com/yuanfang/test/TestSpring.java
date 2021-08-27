package com.yuanfang.test;

import com.yuanfang.service.DeptService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("com/yuanfang/spring.xml");
        DeptService deptService = (DeptService) context.getBean("deptService");
        System.out.println(deptService.getClass());
        deptService.find("xxx");



    }
}
