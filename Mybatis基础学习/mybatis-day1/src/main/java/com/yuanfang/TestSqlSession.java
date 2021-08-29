package com.yuanfang;

import com.yuanfang.dao.UserDAO;
import com.yuanfang.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * @ClassName TestSqlSession
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/8/28
 **/
public class TestSqlSession {
    public static void main(String[] args) throws IOException {
        //读取mybatis-config.xml
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //创建mybatis核心对象sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取DAO对象
        UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
        try{
            User user = new User();
            //user.setId(2331);
            user.setName("小王");
            user.setAge(22);
            user.setBir(new Date());
            int counts = userDAO.save(user);
            System.out.println("影响的条数：" + counts);
            // 保存自动生成的id
            System.out.println("本次生成的id为：" + user.getId());
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
    }
}
