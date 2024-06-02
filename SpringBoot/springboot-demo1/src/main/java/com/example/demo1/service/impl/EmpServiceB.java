package com.example.demo1.service.impl;

import com.example.demo1.dao.EmpDao;
import com.example.demo1.dao.impl.EmpDaoA;
import com.example.demo1.pojo.Emp;
import com.example.demo1.service.EmpService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceB implements EmpService {
    /*
        步骤二：在需要创建的变量上加上@autowired注解自动装配
        如果有多个该类型的对象，会报错
        解决方法一：在EmpDao的实现类加Primary注解来声明需要优先使用哪一个实现类
        解决方法二：在自动装配注解前加Qualifier注解指定需要使用的实现类,注意类名要小写（没有指定Bean的名字的话）
        解决方法三：使用Resource注解：相当于qualifier+autowired，需要直接指定名称
    */
    //@Resource(name = "empDaoC")
    //@Qualifier("empDaoC")
    @Autowired
    private EmpDao empDao;
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
