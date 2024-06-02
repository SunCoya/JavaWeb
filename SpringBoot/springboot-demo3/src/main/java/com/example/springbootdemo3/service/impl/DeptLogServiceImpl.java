package com.example.springbootdemo3.service.impl;

import com.example.springbootdemo3.mapper.DeptLogMapper;
import com.example.springbootdemo3.pojo.DeptLog;
import com.example.springbootdemo3.service.DeptLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeptLogServiceImpl implements DeptLogService {
    @Autowired
    DeptLogMapper deptLogMapper;

     /*
        而在同一个class中，方法B调用方法A，不通过代理对象。无法通过注解保证事务性，故设置一个新的类存放服务
        配置为开启新事务，不受调用方法回滚的影响
    */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insertLog(DeptLog deptLog) {
        deptLogMapper.insertLog(deptLog);
    }
}
