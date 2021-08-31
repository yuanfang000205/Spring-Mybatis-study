package com.yuanfang.test;

import com.yuanfang.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName Test
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/8/31
 **/
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.findAll().forEach(System.out::println);
    }
}
