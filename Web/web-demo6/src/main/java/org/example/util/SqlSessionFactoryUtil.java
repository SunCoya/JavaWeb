package org.example.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtil {
    static SqlSessionFactory sqlSessionFactory;
    static { try {sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));}catch (Exception e){e.printStackTrace();}}
    public static SqlSessionFactory getssf(){
        return sqlSessionFactory;
    }
}
