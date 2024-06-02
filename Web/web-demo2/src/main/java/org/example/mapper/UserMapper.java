package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.User;

public interface UserMapper {
    @Select("select * from user where username=#{username} and password=#{password} ;")
    User select(User user);
    @Select("select * from user where username=#{username}")
    User selectByUsername(String username);
    @Insert("insert into user values(null,#{username},#{password})")
    void add(User user);
}
