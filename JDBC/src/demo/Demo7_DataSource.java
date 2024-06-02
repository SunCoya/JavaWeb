package demo;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;
/*
数据库连接池
和线程池相似，能把驱逐长时间占用资源的用户
Druid数据库连接池获取Connection对象步骤？(SpringBoot默认使用Hikari)
    1.导入jar包，定义properties配置文件
    2.加载配置文件
    3.获取数据源对象
    4.从数据源对象获取数据库连接
1.如何获取数据源对象？
2.如何从数据源对象获取数据库连接？
*/
public class Demo7_DataSource {
    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream("JDBC/src/druid.properties"));
        System.out.println("1.使用DruidDataSourceFactory的createDataSource方法，传入配置信息创建数据源对象");
        DataSource dataSource= DruidDataSourceFactory.createDataSource(prop);
        System.out.println("2.使用数据源的getConnection获取一个连接");
        Connection connection=dataSource.getConnection();
        connection.close();
    }
}
