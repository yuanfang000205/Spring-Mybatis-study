package com.yuanfang.action;

import com.opensymphony.xwork2.Action;

/**
 * @ClassName UserAction
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/8/31
 **/
public class UserAction {
    public String hello(){
        System.out.println("hello spring struts");
        return Action.SUCCESS;
    }
}
