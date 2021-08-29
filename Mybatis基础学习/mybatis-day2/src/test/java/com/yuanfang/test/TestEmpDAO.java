package com.yuanfang.test;

import com.yuanfang.dao.EmpDAO;
import com.yuanfang.entity.Emp;
import com.yuanfang.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @ClassName TestEmpDAO
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/8/29
 **/
public class TestEmpDAO {
    SqlSession sqlSession = MybatisUtil.getSqlSession();
    EmpDAO empDAO = sqlSession.getMapper(EmpDAO.class);

    @Test
    public void testQueryEmp(){
        Emp emp = empDAO.queryDeptById(2);
        System.out.println("员工信息：" + emp + "\n部门信息：" + emp.getDept());
        MybatisUtil.close(sqlSession);
    }
}
