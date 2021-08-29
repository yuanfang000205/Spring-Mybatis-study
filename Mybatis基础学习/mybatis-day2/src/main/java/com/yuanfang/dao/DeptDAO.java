package com.yuanfang.dao;

import com.yuanfang.entity.Dept;
import com.yuanfang.entity.Emp;

import java.util.List;

/**
 * @ClassName Dept
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/8/29
 **/
public interface DeptDAO {
    /**
     * 查询所有部门中的员工信息
     */
    List<Dept> queryAll();
}
