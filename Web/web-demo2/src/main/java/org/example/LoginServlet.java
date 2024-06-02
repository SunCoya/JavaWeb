package org.example;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
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

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        User reqUser = new User(req.getParameter("username"),req.getParameter("password"));
        System.out.println("输入的用户信息为："+reqUser);

        SqlSession sqlSession=SqlSessionFactoryUtil.getssf().openSession(true);
        User user = sqlSession.getMapper(UserMapper.class).select(reqUser);
        System.out.println("查询到的用户为："+user);

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if (user!=null)writer.write("登录成功");
        else writer.write("登录失败");
        sqlSession.close();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
