package com.yuanfang.test;

import com.yuanfang.dao.StuDAO;
import com.yuanfang.entity.Student;
import com.yuanfang.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @ClassName TestStuDAO
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/8/29
 **/
public class TestStuDAO {
    SqlSession sqlSession = MybatisUtil.getSqlSession();
    StuDAO stuDAO = sqlSession.getMapper(StuDAO.class);

    @Test
    public void testQueryAllStu(){
        stuDAO.queryAll().forEach(student -> {
            System.out.println("学生：" + student);
            student.getCourses().forEach(course -> {
                System.out.println("所选课程为：" +course);
            });
        });
    }
}
