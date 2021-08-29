package com.yuanfang.dao;

import com.yuanfang.entity.Course;
import com.yuanfang.entity.Student;

import java.util.List;

/**
 * @ClassName StuDAO
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/8/29
 **/
public interface StuDAO {
    /**
     * 查询所有学生及其所选课程信息
     */
    List<Student> queryAll();
}
