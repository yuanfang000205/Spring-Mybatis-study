package com.yuanfang.dao;

import com.yuanfang.entity.User;

import java.util.List;

/**
 * @ClassName UserDAO
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/8/29
 **/
public interface UserDAO {
    /**
     * 查询所有用户信息
     */
    List<User> queryAll();
    /**
     * 保存信息
     */
    void save(User user);
}
