package demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
/*
JDBC快速入门

创建新项目，导入mysql-connector-java-5.1.48的jar包

1.使用JDBC更新一条数据有哪一些步骤？
    1.加载是哪一个牌子的数据库驱动（mysql连接jar包5版本后可不写）
    2.获取数据库连接
    3.获取执行sql语句的对象，然后执行sql，获取执行sql结果的返回
    4.关闭连接与执行对象

2.使用.class获取类与class.forName有什么区别？
xxx.class需要被用到的时候才会被加载，使用Class.forName(xxx)能够调用静态方法

3.如何注册数据库驱动？这种方法在底层如何运行？
4.如何进行数据库连接？url应该如何表示？不写域名端口号默认为？如何去除输出警告？
5.如何获取sql执行对象？
6.如果要更新数据，应该要是用什么方法执行sql呢？方法执行返回值是？
*/
public class Demo1_FirstJDBC {
    public static void main(String[] args) throws Exception {

        System.out.println("3.使用Class.forName加载mysql.jdbc包中的Driver类");
        System.out.println("在该类的静态代码块里面有如下代码：DriverManager.registerDriver(new Driver());");
        System.out.println("也就是说创建了自己这个类的对象（驱动），把驱动传给驱动管理器的注册驱动方法了");
        Class.forName("com.mysql.jdbc.Driver");

        System.out.println("4.通过DriverManager的getConnection方法获取获取Connection对象");
        System.out.println("URL需要表名地址、端口、数据库名，可省略域名与端口号,去除输出的警告可以加上?useSSL=false");
        String url1="jdbc:mysql://localhost:3306/db1";
        String url2="jdbc:mysql:///db1?useSSL=false";
        Connection conn= DriverManager.getConnection(url2,"root","123456");

        System.out.println("5.通过数据库连接对象的createStatement方法获取Statement对象");
        Statement stmt = conn.createStatement();

        System.out.print("6.通过sql执行对象的executeUpdate方法执行修改数据的一条sql，返回值为受影响的行数:");
        System.out.print(stmt.executeUpdate("update account set money=1000"));

        stmt.close();
        conn.close();
    }
}
