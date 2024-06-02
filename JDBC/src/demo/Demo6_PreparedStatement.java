package demo;

import org.junit.Test;

import java.sql.*;

/*
使用PreparedStatement防止Sql注入
原理：把单引号转义，使注入失效

1.如何预使用预编译功能？
2.如何获取preparedStatement对象？
3.在上述情况下如何写sql语句？
4.在执行pstmt的查询方法之前，需要做什么？
5.执行查询方法与stmt有什么不同？
*/
public class Demo6_PreparedStatement {
    public static void main(String[] args) throws Exception{
        System.out.println("1.获取Connection对象时url中加入&useServerPrepStmts=true可预编译加快执行速度，&是连接的意思");
        Connection conn= DriverManager.getConnection("jdbc:mysql:///db1?useSSL=false&useServerPrepStmts=true","root","123456");
        System.out.println("2.用PreparedStatement代替Statement来获取执行sql语句的对象，注意要把sql传进去");
        System.out.println("3.sql语句中把参数改为？");
        PreparedStatement pstmt = conn.prepareStatement("select * from user where username= ? and password = ?");
        System.out.println("4.使用pstmt的setxxx的方法设置？的值,从1开始，代表sql语句中的第几个？");
        pstmt.setString(1,"zhangsan");
        pstmt.setString(2,"123");//注入语句：'or'1'='1
        System.out.println("5.执行查询方法由于已经传入sql，直接执行即可，无需传入sql");
        ResultSet rs=pstmt.executeQuery();
        if(rs.next()){ System.out.println("登陆成功"); }
        else{ System.out.println("登陆失败"); }
        rs.close();
        pstmt.close();
        conn.close();
    }
}
