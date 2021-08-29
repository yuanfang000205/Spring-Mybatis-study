package com.yuanfang.test;

import com.yuanfang.dao.InfoDAO;
import com.yuanfang.dao.PersonDAO;
import com.yuanfang.entity.Info;
import com.yuanfang.entity.Person;
import com.yuanfang.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.time.Period;

/**
 * @ClassName TestPersonDAO
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/8/28
 **/
public class TestPersonDAO {
    SqlSession sqlSession = MybatisUtil.getSqlSession();
    PersonDAO personDAO = sqlSession.getMapper(PersonDAO.class);

    @Test
    public void testQueryAll() {
        personDAO.queryAll().forEach(
                person -> System.out.println("当前个人信息：" + person +
                        "\n身份信息：" + person.getInfo()));
        MybatisUtil.close(sqlSession);
    }
    @Test
    public void testPersonDAO() {
        try {
            Person person = new Person();
            person.setName("元芳");
            person.setAge(18);
            // 外键信息
            person.setCardno("123456789101234567");
            personDAO.save(person);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            MybatisUtil.close(sqlSession);
        }
    }

}
