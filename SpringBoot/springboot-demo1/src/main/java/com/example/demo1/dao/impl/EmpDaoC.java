package com.example.demo1.dao.impl;

import com.example.demo1.dao.EmpDao;
import com.example.demo1.pojo.Emp;
import com.example.demo1.utils.XmlParserUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

//指定老大实现类
@Primary
@Repository
public class EmpDaoC implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        System.out.println("EmpDaoC");
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        return XmlParserUtils.parse(file, Emp.class);
    }
}
