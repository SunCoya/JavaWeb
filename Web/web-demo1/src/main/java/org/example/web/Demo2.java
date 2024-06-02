package org.example.web;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
    如何让多个访问路径都能够访问到同一个Servlet？
    可在注解上设置多个路径（url），也可以设置特殊路径
*/
@WebServlet(urlPatterns = {"/demo2/*","*.demo2"})
public class Demo2 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("访问demo2目录下 或者 后缀名为demo2的所有资源");
    }
}
