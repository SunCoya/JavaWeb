package com.example.springbootdemo3.service;
import com.example.springbootdemo3.pojo.Emp;
import com.example.springbootdemo3.pojo.PageBean;
import java.time.LocalDate;

public interface EmpService {
    PageBean<Emp> selectByPage(Integer page,Integer size, String gender,Integer age,LocalDate begin,LocalDate end);
    void deleteByIDs(Integer[] ids);
    void insert(Emp emp);
    Emp selectById(Integer id);
    void update(Emp emp);
    Emp login(Emp emp);
}
