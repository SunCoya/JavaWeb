package com.example.springbootdemo3.service.impl;

import com.example.springbootdemo3.mapper.DeptMapper;
import com.example.springbootdemo3.mapper.EmpMapper;
import com.example.springbootdemo3.pojo.Dept;
import com.example.springbootdemo3.pojo.DeptLog;
import com.example.springbootdemo3.service.DeptLogService;
import com.example.springbootdemo3.service.DeptService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    DeptMapper deptMapper;
    @Autowired
    EmpMapper empMapper;
    @Autowired
    DeptLogService deptLogService;
    @Override
    public List<Dept> selectAll(){
        return deptMapper.selectAll();
    }

    /*
    事务一般会加在业务层进行多次增删改的方法上，在删除部门的同时删除员工，在此处需要开启事务（打开spring的事务管理的开关）

    只有在出现运行时异常才会正常回滚，若需要所有异常回滚，则需要声明rollbackFor

    事务传递行为：一个带有transactional注解的方法调用另外一个带有相同注解的方法
    被调用的那个方法需不需要开启事务呢？（默认为不开启新事务，多个方法合并为一个事务）
    如：解散部门，无论成功失败，都需要记录操作日志
    */

    @Transactional(rollbackFor = Exception.class)//表示所有异常都回滚
    @Override
    public void deleteById(Integer id) {
        try {
            deptMapper.deleteById(id);
            //int i = 1/0;
            empMapper.deleteByDeptId(id);
        } finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setDescription("删除部门"+id);
            deptLogService.insertLog(deptLog);
        }
    }

    @Override
    public void insert(Dept dept) {
        deptMapper.insert(dept);
    }

    @Override
    public Dept selectById(Integer id) {
        return deptMapper.selectById(id);
    }

    @Override
    public void update(Dept dept) {
        deptMapper.update(dept);
    }
}
