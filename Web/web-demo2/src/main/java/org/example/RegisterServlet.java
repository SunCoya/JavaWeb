package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.example.utils.SqlSessionFactoryUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        User user = new User(req.getParameter("username"), req.getParameter("password"));
        System.out.println("输入的用户信息为："+user);

        SqlSession sqlSession= SqlSessionFactoryUtil.getssf().openSession(true);
        UserMapper userMapper =sqlSession.getMapper(UserMapper.class);

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if (userMapper.selectByUsername(user.getUsername()) == null) {
            writer.write("注册成功");
            userMapper.add(user);
        }
        else writer.write("注册失败");
        sqlSession.close();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
