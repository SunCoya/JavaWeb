package com.example.springbootdemo3.service.impl;
import com.example.springbootdemo3.mapper.EmpMapper;
import com.example.springbootdemo3.pojo.Emp;
import com.example.springbootdemo3.pojo.PageBean;
import com.example.springbootdemo3.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empMapper;
    @Override
    public PageBean<Emp> selectByPage(Integer page, Integer size, String name, Integer gender, LocalDate begin, LocalDate end) {
        //return new PageBean<>(empMapper.selectCount(),empMapper.selectedByPage((page-1)*size,size));

        //pageHelper，简化Dao层的操作
        PageHelper.startPage(page,size);
        List<Emp> empList = empMapper.selectByCondition(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>)empList;
        return new PageBean<>(p.getTotal(),p.getResult());
    }

    @Override
    public void deleteByIDs(Integer[] ids){
        empMapper.deleteByIDs(ids);
    }

    @Override
    public void insert(Emp emp){
        empMapper.insert(emp);
    }

    @Override
    public Emp selectById(Integer id) {
        return empMapper.selectById(id);
    }

    @Override
    public void update(Emp emp){
        empMapper.update(emp);
    }

    @Override
    public Emp login(Emp emp) {
        return empMapper.login(emp);
    }

}
