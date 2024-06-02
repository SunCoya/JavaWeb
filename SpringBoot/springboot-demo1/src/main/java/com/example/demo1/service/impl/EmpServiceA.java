package com.example.demo1.service.impl;

import com.example.demo1.dao.EmpDao;
import com.example.demo1.dao.impl.EmpDaoA;
import com.example.demo1.pojo.Emp;
import com.example.demo1.service.EmpService;

import java.util.List;

public class EmpServiceA implements EmpService {
    //面向接口编程，写在类最前方便多次调用
    private EmpDao empDao = new EmpDaoA();
    @Override
    public List<Emp> listEmp() {
        List<Emp> empList = empDao.listEmp();
        empList.forEach(emp -> {
                    if ("1".equals(emp.getGender()))emp.setGender("男");
                    else emp.setGender("女");
                }
        );
        return  empList;
    }
}
