package com.yuanfang.service;

import com.yuanfang.dao.UserDAO;
import com.yuanfang.entity.User;

import java.util.List;
import java.util.UUID;

public class UserServiceImpl implements UserService {

    //依赖DAO
    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void save(User user) {
        //处理业务
        user.setId(UUID.randomUUID().toString());
        userDAO.save(user);
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }
}
