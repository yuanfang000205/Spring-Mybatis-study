package com.yuanfang.service;

import com.yuanfang.entity.User;

import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/8/30
 **/
public interface UserService {
    /**
     * 查询所有
     */
    List<User> queryAll();

    /**
     * 保存信息
     */
    void save(User user);
}
