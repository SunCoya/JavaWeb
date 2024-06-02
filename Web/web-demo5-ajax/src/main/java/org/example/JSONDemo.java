package org.example;
import com.alibaba.fastjson.JSON;
import org.example.pojo.User;
//本案例将使用fastJSON转换JAVA对象与JSON
public class JSONDemo {
    public static void main(String[] args) {
        User user = new User(1,"zhangsan","123");
        //对象变字符串
        String jsonString = JSON.toJSONString(user);
        //字符串变对象
        User u = JSON.parseObject(jsonString, User.class);
    }
}
