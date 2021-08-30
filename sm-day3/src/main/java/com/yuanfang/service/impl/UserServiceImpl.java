package com.yuanfang.service.impl;

import com.yuanfang.dao.UserDAO;
import com.yuanfang.entity.User;
import com.yuanfang.service.UserService;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/8/30
 **/
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;
    /** 生成事务管理器:用来保证同一个线程在调用同一个service方法和DAO方法和使用连接对象一致*/
    //private PlatformTransactionManager platformTransactionManager;
    //
    //public void setPlatformTransactionManager(PlatformTransactionManager platformTransactionManager) {
    //    this.platformTransactionManager = platformTransactionManager;
    //}

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    @Override
    public List<User> queryAll() {
        return userDAO.queryAll();
    }

    @Override
    public void save(User user) {
        //处理业务
        user.setId(UUID.randomUUID().toString());
        //调用业务          方法中小事务 方便测试DAO 当外部存在事务时，小事务自动消失
        userDAO.save(user);

        ////创建事务配置对象
        //TransactionDefinition definition = new DefaultTransactionDefinition();
        ////获取事务状态
        //TransactionStatus status = platformTransactionManager.getTransaction(definition);
        //
        //try{
        //    //处理业务
        //    user.setId(UUID.randomUUID().toString());
        //    //调用业务          方法中小事务 方便测试DAO 当外部存在事务时，小事务自动消失
        //    userDAO.save(user);
        //    platformTransactionManager.commit(status);
        //}catch (Exception e){
        //    platformTransactionManager.rollback(status);
        //}

    }

}
