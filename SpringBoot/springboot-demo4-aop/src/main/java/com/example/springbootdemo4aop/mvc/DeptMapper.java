package com.example.springbootdemo4aop.mvc;
import com.example.springbootdemo4aop.aop.MyLog;
import com.example.springbootdemo4aop.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface DeptMapper {
    @MyLog
    @Select("SELECT * from dept")
    List<Dept> selectAll();
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);
    @Insert("insert into dept values (null,#{name},now(),now())")
    void insert(Dept dept);
    @Select("select * from dept where id = #{id}")
    Dept selectById(Integer id);
    @Update("update dept set name = #{name},update_time = now() where id = #{id}")
    void update(Dept dept);
}
