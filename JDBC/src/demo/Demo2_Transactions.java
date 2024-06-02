package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/*
JDBC中的事务
1.在JDBC中通过什么对象管理事务？
JDBC中通过Connection对象来管理事务，在Java中使用这种方法描述事务更为方便
2.如何开启事务，如何进行事务回滚与提交？
*/
public class Demo2_Transactions {
    public static void main(String[] args) throws SQLException {
        Connection conn= DriverManager.getConnection("jdbc:mysql:///db1?useSSL=false","root","123456");
        Statement stmt = conn.createStatement();
        try {
            System.out.println("2.使用Connection对象的setAutoCommit方法设置false开启事务," +
                    "使用commit方法与rollback方法处理事务，一般写try-catch形式");
            conn.setAutoCommit(false);
            stmt.executeUpdate("update account set money=3000 where id=1");
            //int i=1/0;
            conn.commit();
        } catch (RuntimeException e) {
            System.out.println("出现错误，事务回滚");
            conn.rollback();
        }
        stmt.close();
        conn.close();
    }
}
