package org.example;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.UserMapper;

import java.io.IOException;

public class App
{
    public static void main( String[] args ) throws IOException {
        //1.加载mybatis核心配置文件
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        //2.获取sqlsession对象
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //3.获取接口,调用其方法执行sql
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        userMapper.selectAll().forEach(System.out::println);
        //4.释放资源
        sqlSession.close();
    }
}
