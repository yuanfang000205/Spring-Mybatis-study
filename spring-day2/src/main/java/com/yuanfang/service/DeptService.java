package com.yuanfang.service;

public interface DeptService {
    void save(String name);

    void update(String name);

    void delete(Integer id);

    String find(String name);

}
