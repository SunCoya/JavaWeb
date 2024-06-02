package com.example.demo1.dao.impl;

import com.example.demo1.dao.EmpDao;
import com.example.demo1.pojo.Emp;
import com.example.demo1.utils.XmlParserUtils;
import org.springframework.stereotype.Component;

import java.util.List;


public class EmpDaoA implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        return XmlParserUtils.parse(file, Emp.class);
    }
}
