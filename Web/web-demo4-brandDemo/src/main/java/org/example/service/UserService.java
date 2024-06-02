package org.example.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.example.util.SqlSessionFactoryUtil;

public class UserService {
    SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtil.getssf();
    public User login(String username, String password){//登录需要设置cookie给浏览器，需要返回用户对象
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        User user=mapper.select(username,password);
        sqlSession.close();
        return user;
    }
    public boolean register(User user){
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        User u=mapper.selectByUsername(user.getUsername());
        if(u==null){mapper.add(user);}
        sqlSession.close();
        return u==null;
    }
    public boolean selectByName(String name){
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectByUsername(name);
        sqlSession.close();
        return user!=null;
    }
}
