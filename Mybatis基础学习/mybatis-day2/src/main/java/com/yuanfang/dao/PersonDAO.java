package com.yuanfang.dao;

import com.yuanfang.entity.Person;

import java.util.List;

/**
 * @ClassName PersonDAO
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/8/28
 **/
public interface PersonDAO {
    /**
     * 保存个人信息
     */
    int save(Person person);

    /**
     * 查询所有用户信息
     */
    List<Person> queryAll();
}
