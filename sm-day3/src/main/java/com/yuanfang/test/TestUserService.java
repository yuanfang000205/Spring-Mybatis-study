package com.yuanfang.test;

import com.yuanfang.entity.User;
import com.yuanfang.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @ClassName TestUserService
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/8/30
 **/
public class TestUserService {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = (UserService) context.getBean("userService");
        //System.out.println(userService.getClass());
        userService.queryAll().forEach(System.out::println);

        userService.save(new User(null, "老王", 20, new Date()));

    }
}
