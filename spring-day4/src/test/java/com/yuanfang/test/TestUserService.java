package com.yuanfang.test;

import com.yuanfang.entity.User;
import com.yuanfang.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @ClassName Test
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/8/30
 **/
public class TestUserService {
    private ClassPathXmlApplicationContext context;

    @Before
    public void before(){
        this.context = new ClassPathXmlApplicationContext("spring.xml");
    }

    @Test
    public void testSave() {
        UserService userService = (UserService) context.getBean("userService");
        User user = new User();
        user.setBir(new Date());
        user.setName("元芳");
        user.setAge(22);
        userService.save(user);
    }
}
