package com.yuanfang.dao;

import com.yuanfang.entity.Info;

/**
 * @ClassName InfoDAO
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/8/28
 **/
public interface InfoDAO {
    /**
     * 保存信息
     */
    int save(Info info);
}
