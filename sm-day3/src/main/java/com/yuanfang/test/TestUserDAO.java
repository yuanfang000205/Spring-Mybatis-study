package com.yuanfang.test;

import com.yuanfang.dao.UserDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName TestUserDAO
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/8/29
 **/
public class TestUserDAO {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserDAO  userDAO = (UserDAO) context.getBean("userDAO");
        userDAO.queryAll().forEach(System.out::println);
    }
}
