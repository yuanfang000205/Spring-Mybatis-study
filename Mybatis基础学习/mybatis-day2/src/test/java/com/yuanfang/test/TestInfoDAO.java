package com.yuanfang.test;

import com.yuanfang.dao.InfoDAO;
import com.yuanfang.entity.Info;
import com.yuanfang.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @ClassName test
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/8/28
 **/
public class TestInfoDAO {

    @Test
    public void testInfoDAO() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        InfoDAO infoDAO = sqlSession.getMapper(InfoDAO.class);
        try {
            Info info = new Info();
            info.setCardno("123456789101234567");
            info.setAddress("广东省深圳市");
            infoDAO.save(info);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            MybatisUtil.close(sqlSession);
        }
    }




}
