package demo;
import org.junit.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/*
sql执行对象的executeUpdate方法
1.executeUpdate方法能够进行什么操作？
execute方法能够进行数据库与表的增删操作与表内数据的增删改操作得到的数据表示修改状态
2.该方法在创建数据库成功时与删除数据库失败时返回什么？
*/
public class Demo3_ExecuteUpdate {
    public static void main(String[] args) throws SQLException {
        Connection conn= DriverManager.getConnection("jdbc:mysql:///db1?useSSL=false","root","123456");
        Statement stmt = conn.createStatement();
        System.out.println("创建数据库成功返回1，删除数据库成功返回0");
        System.out.println(stmt.executeUpdate("create database db2"));
        System.out.println(stmt.executeUpdate("drop database db2"));
        stmt.close();
        conn.close();
    }
}
