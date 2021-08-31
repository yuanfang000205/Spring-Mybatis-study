package com.yuanfang.service;

import com.yuanfang.entity.User;

import java.util.List;

public interface UserService {

    void save(User user);

    List<User> findAll();

}
