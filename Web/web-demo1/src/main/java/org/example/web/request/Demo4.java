package org.example.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
    请求转发有哪些特点？
    1.请求转发可携带新数据传递到另一个服务器内部资源
    2.浏览器地址栏不变
    3.可在多个资源中共享请求数据
*/
@WebServlet("/req4")
public class Demo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setAttribute("msg","请求转发的信息");
        req.getRequestDispatcher("/req5").forward(req,resp);
    }
}