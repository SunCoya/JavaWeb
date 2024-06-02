package com.example.demo1.dao.impl;

import com.example.demo1.dao.EmpDao;
import com.example.demo1.pojo.Emp;
import com.example.demo1.utils.XmlParserUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

//使用IOC第一步：给需要的方案加上@Component或者其衍生注解
@Repository
public class EmpDaoB implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        return XmlParserUtils.parse(file, Emp.class);
    }
}
