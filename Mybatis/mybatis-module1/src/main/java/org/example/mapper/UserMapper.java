package org.example.mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.User;
import java.util.List;


public interface UserMapper {
    List<User> selectAll();
}
