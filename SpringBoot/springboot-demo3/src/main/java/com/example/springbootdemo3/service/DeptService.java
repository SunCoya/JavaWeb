package com.example.springbootdemo3.service;

import com.example.springbootdemo3.pojo.Dept;
import com.example.springbootdemo3.pojo.DeptLog;

import java.util.List;

public interface DeptService {
    List<Dept> selectAll();
    void deleteById(Integer id);
    void insert(Dept dept);
    Dept selectById(Integer id);
    void update(Dept dept);
}
