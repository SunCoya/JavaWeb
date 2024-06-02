package org.example.springbootdemo2.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//lombok通过注解自动生成实体类方法
@Data//生成getter/setter+toString+EqualsAndHashCode方法
@NoArgsConstructor//生成无参构造方法
@AllArgsConstructor//生成全参构造
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private Integer gender;
    private String phone;
}
