package demo;

import java.sql.*;
import java.util.ArrayList;

/*
查询数据库
1.想要得到查询数据库应该使用什么方法？使用什么对象接收结果？
2.如何取出ResultSet中的数据？
*/
public class Demo4_ExecuteQuery {
    public static void main(String[] args) throws SQLException {
        Connection conn= DriverManager.getConnection("jdbc:mysql:///db1?useSSL=false","root","123456");
        Statement stmt = conn.createStatement();
        System.out.println("使用executeQuery方法查询数据库，用ResultSet接收");
        ResultSet rs=stmt.executeQuery("select * from account");
        System.out.println("2.while循环中，使用结果集的next方法向下一行查找，同时判断是否有数据");
        System.out.println("使用结果集的get***方法获取对应类型的数据，参数可以写列名字符串，也能写数字123代表第几列");
        ArrayList<Account> arrayList = new ArrayList<>();
        while(rs.next()){
            arrayList.add(new Account(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("money")));
        }
        System.out.println(arrayList);
        //多释放ResultSet资源
        rs.close();
        stmt.close();
        conn.close();
    }
}
