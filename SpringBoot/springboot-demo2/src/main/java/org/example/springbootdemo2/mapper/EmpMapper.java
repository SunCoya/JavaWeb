package org.example.springbootdemo2.mapper;

import org.apache.ibatis.annotations.*;
import org.example.springbootdemo2.pojo.Emp;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    //预编译sql，使用$则是应对动态修改表名或列名
    @Delete("delete from emp where id = #{id} ")
    public int deleteById(Integer id);

    //需要拿到生成的主键值，并且将生成的主键值复制到Emp对象的id属性中
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("INSERT into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) VALUES " +
            "(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    public void insert(Emp emp);

    @Update("Update emp set username=#{username},name=#{name},gender=#{gender},image=#{image},job=#{job},entrydate=#{entrydate},dept_id=#{deptId},update_time=#{updateTime} where id =#{id};")
    public void update(Emp emp);

    //不需要起别名了，在配置文件中配置即可，在foreach里面也能直接使用变量名
    @Select("Select * from emp where id = #{id}")
    public Emp selectById(Integer id);

    //多个参数不需要注解(使用2.x的springboot且继承mybatis)，不能把#{}放在引号，故此处使用concat函数
    @Select("select * from emp where name like concat('%',#{name},'%') and gender = #{gender} and " +
            "entrydate between #{begin} and #{end} order by update_time desc")
    public List<Emp> selectByMany(String name, Short gender, LocalDate begin, LocalDate end);

    //在xml文件中需要了解sql标签和include标签：可用与长sql的复用
    public List<Emp> selectByCondition(String name, Short gender, LocalDate begin, LocalDate end);
}
