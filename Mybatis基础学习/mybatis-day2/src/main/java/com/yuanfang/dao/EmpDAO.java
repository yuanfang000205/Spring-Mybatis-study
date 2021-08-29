package com.yuanfang.dao;

import com.yuanfang.entity.Emp;

/**
 * @ClassName EmpDAO
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/8/29
 **/
public interface EmpDAO {
    /**
     * 查询某员工的所在部门
     */
    Emp queryDeptById(Integer id);
}
