package com.yuanfang.test;

import com.yuanfang.dao.UserDAO;
import com.yuanfang.entity.User;
import com.yuanfang.utils.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * @ClassName TestCRUD
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/8/28
 **/
public class TestCRUD  {
    SqlSession sqlSession = MybatisUtil.getSqlSession();
    UserDAO userDAO = sqlSession.getMapper(UserDAO.class);

    @Test
    public void testQueryTotalCounts() {
        Long counts = userDAO.queryTotalCounts();
        System.out.println(counts);
        MybatisUtil.close(sqlSession);
    }
    @Test
    public void testQueryByPage() {
        /**
         * mysql中默认从0开始，start：当前页1 起始位置0 当前页2 起始位置2 当前页3 起始位置4
         * 起始位置规律：(当前页-1) * 每页显示的记录数量
         */
        List<User> users = userDAO.queryByPage(1,2);
        users.forEach(System.out::println);
        MybatisUtil.close(sqlSession);
    }
    @Test
    public void testQueryLikeByName() {
        List<User> users = userDAO.queryLikeByName("李");
        users.forEach(System.out::println);
        MybatisUtil.close(sqlSession);
    }
    @Test
    public void testQueryById() {
        User user = userDAO.queryById(4);
        System.out.println(user);
        MybatisUtil.close(sqlSession);
    }
    @Test
    public void testQueryAll() {
        List<User> users = userDAO.queryAll();
        users.forEach(System.out::println);
        MybatisUtil.close(sqlSession);

    }
    @Test
    public void delete() {
        try{
            userDAO.delete(3);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            MybatisUtil.close(sqlSession);
        }
    }
    @Test
    public void update() {

        try{
            User user = new User();
            user.setId(2);
            user.setAge(88);
            userDAO.update(user);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            MybatisUtil.close(sqlSession);

        }
    }

    @Test
    public void save() {
        try{
            User user = new User();
            //user.setId(2331);
            user.setName("aa");
            user.setAge(15);
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
            MybatisUtil.close(sqlSession);

        }
    }
}
