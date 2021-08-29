package com.yuanfang.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName MybatisUtil
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/8/28
 **/
public class MybatisUtil {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        /* 读取配置文件*/
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /** 提供sqlSession */
    public static SqlSession getSqlSession(){
        return  sqlSessionFactory.openSession();
    }
    /** 关闭sqlSession */
    public static void close(SqlSession sqlSession){
        sqlSession.close();
    }
}
