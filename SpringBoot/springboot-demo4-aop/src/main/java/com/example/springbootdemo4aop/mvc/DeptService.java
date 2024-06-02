package com.example.springbootdemo4aop.mvc;

import com.example.springbootdemo4aop.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> selectAll();
    void deleteById(Integer id);
    void insert(Dept dept);
    Dept selectById(Integer id);
    void update(Dept dept);
}
