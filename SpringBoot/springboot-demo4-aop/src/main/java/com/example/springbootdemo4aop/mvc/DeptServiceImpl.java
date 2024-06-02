package com.example.springbootdemo4aop.mvc;
import com.example.springbootdemo4aop.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
//延迟初始化注解（默认为spring启动的时候初始化构造对象）
@Lazy
//设置作用域：每次使用该对象都会创建新的实例（默认为同一个bean对象）
@Scope("prototype")
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    DeptMapper deptMapper;
    @Override
    public List<Dept> selectAll(){
        return deptMapper.selectAll();
    }
    public void deleteById(Integer id) {
         deptMapper.deleteById(id);
    }
    @Override
    public void insert(Dept dept) {
        deptMapper.insert(dept);
    }
    @Override
    public Dept selectById(Integer id) {
        //int i = 1/0;
        return deptMapper.selectById(id);
    }
    @Override
    public void update(Dept dept) {
        deptMapper.update(dept);
    }
}
