package com.yuanfang.dao;

import com.yuanfang.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName UserDAO
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/8/28
 **/
public interface UserDAO {
    /**
     * 保存用户信息
     */
    int save(User user);

    /**
     * 修改用户信息
     */
    int update(User user);

    /**
     * 删除信息
     */
    int delete(Integer id);

    /**
     * 查询所有用户信息
     */
    List<User> queryAll();

    /**
     * 查询单个用户信息
     */
    User queryById(Integer id);

    /**
     * 模糊查询用户信息：根据名字中的某个汉字
     */
    List<User> queryLikeByName(String name);

    /**
     * 分页查询
     * 参数一：起始位置 参数二：每页显示的记录数量
     */
    List<User> queryByPage(@Param("start") Integer start,@Param("rows") Integer rows);

    /**
     * 查询总条数
     */
    Long queryTotalCounts();
}
