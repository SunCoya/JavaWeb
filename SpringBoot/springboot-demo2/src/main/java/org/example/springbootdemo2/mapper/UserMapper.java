package org.example.springbootdemo2.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.springbootdemo2.pojo.User;

import java.util.List;
@Mapper//在运行时自动生成实现类对象（动态代理对象），并且将该对象文件交给IOC容器处理
public interface UserMapper {
    @Select("select * from user")
    List<User> selectAll();
}
