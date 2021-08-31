package com.yuanfang.dao;

import com.yuanfang.entity.User;

import java.util.List;

public interface UserDAO {

    void save(User user);

    List<User> findAll();
}
