package com.example.springbootdemo3.mapper;

import com.example.springbootdemo3.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    @Select("select count(*) from emp")
    Long selectCount();
    @Select("select * from emp limit #{start},#{size}")
    List<Emp> selectByPage(Integer start,Integer size);

    //使用分页插件PageHelper，只需要写这一条sql，上面两条就可以不需要了
    List<Emp> selectByCondition(String name, Integer gender, LocalDate begin, LocalDate end);
    void deleteByIDs(Integer[] ids);

    //对于自动增长或者是有default属性的列，可以不用写在添加的列中
    //获取属性之际写属性就可以了，不需要emp.name
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            "values(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},now(),now())")
    void insert(Emp emp);
    @Select("select * from emp where id = #{id}")
    Emp selectById(Integer id);
    public void update(Emp emp);
    @Select("select * from emp where username = #{username} and password=#{password}")
    public Emp login(Emp emp);
    @Delete("delete from emp where dept_id=#{deptId}")
    public void deleteByDeptId(Integer deptId);
}
