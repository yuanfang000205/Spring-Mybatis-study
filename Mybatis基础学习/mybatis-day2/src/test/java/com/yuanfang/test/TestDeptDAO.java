package com.yuanfang.test;

import com.yuanfang.dao.DeptDAO;
import com.yuanfang.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @ClassName TestDeptDAO
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/8/29
 **/
public class TestDeptDAO {
    SqlSession sqlSession = MybatisUtil.getSqlSession();
    DeptDAO deptDAO = sqlSession.getMapper(DeptDAO.class);

    @Test
    public void testQueryAll() {
        deptDAO.queryAll().forEach(dept -> {
            System.out.println("部门信息======>" + dept);
            dept.getEmps().forEach(emp -> {
                System.out.println("=========员工信息=======>" + emp);
            });
            System.out.println("-----------------------");
        });
        MybatisUtil.close(sqlSession);
    }
}
