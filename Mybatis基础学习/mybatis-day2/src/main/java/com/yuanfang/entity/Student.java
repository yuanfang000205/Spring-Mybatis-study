package com.yuanfang.entity;

import java.util.List;

/**
 * @ClassName Student
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/8/29
 **/
public class Student {
    private Integer id;
    private String name;

    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
