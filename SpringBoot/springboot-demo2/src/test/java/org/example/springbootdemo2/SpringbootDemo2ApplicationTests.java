package org.example.springbootdemo2;

import org.example.springbootdemo2.mapper.EmpMapper;
import org.example.springbootdemo2.mapper.UserMapper;
import org.example.springbootdemo2.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest//SpringBoot整合单元测试的注解
class SpringbootDemo2ApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private EmpMapper empMapper;
    @Test
    void test() {
        System.out.println(userMapper.selectAll());
    }
    @Test
    void delete(){
        System.out.println(empMapper.deleteById(19));
    }
    @Test
    void insert(){
        Emp emp = new Emp("zhangsan1","张三1", (short) 1,"1.jpg", (short) 1,
                LocalDate.of(2024,3,10),1,
                LocalDateTime.now(), LocalDateTime.now());
        empMapper.insert(emp);
        System.out.println(emp.getId());
    }
    //更新数据，在java代码中存储当前时间
    @Test
    void update(){
        Emp emp = new Emp(21,"zhangsan2","123456","张三2", (short) 1,"1.jpg", (short) 1,
                LocalDate.of(2024,3,10),1,
                LocalDateTime.now(), LocalDateTime.now());
        empMapper.update(emp);
    }
    @Test
    void selectById(){
        Emp emp = empMapper.selectById(1);
        System.out.println(emp);
    }
    @Test
    void selectByMany(){
        List<Emp> emps = empMapper.selectByMany
                ("张", (short) 1,
                        LocalDate.of(2010, 1, 1),
                        LocalDate.of(2030, 1, 1));
        System.out.println(emps);
    }
    @Test
    void selectByCondition(){
        List<Emp> emps = empMapper.selectByCondition("张", (short) 1,
                        LocalDate.of(2010, 1, 1),
                        LocalDate.of(2030, 1, 1));
        System.out.println(emps);
    }
}
