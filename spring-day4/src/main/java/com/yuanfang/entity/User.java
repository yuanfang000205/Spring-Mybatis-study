package com.yuanfang.entity;

import java.util.Date;

/**
 * @ClassName User
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/8/30
 **/
public class User {
    private String id;
    private String name;
    private Integer age;
    private Date bir;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", bir=" + bir +
                '}';
    }

    public User() {
    }

    public User(String id, String name, Integer age, Date bir) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.bir = bir;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBir() {
        return bir;
    }

    public void setBir(Date bir) {
        this.bir = bir;
    }
}
