package org.example.cookie;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
1.存Session：通过请求对象存储数据到Session中
2.获取session对象中对应键的值,后移除键值对
3.在web.xml中设置session存活时间
*/
@WebServlet("/session")
public class SessionDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        HttpSession session=request.getSession();
        session.setAttribute("username","zhangsan");
        System.out.println(session.getAttribute("username"));
        session.removeAttribute("username");
    }
}