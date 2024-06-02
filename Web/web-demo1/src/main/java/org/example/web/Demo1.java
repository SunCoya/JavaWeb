package org.example.web;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
    HTTPServlet的使用
    1.要如何做才能让浏览器访问到这个HttpServlet资源？
        在类上注解设置访问路径（也可以在web.xml配置）
        启动项目后访问http://localhost/web_demo1_war/demo1即可访问到此资源
    2.访问该路径后，用不同的方式（post与get）发送请求分别用到什么方法？）
*/
@WebServlet("/demo1")
public class Demo1 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("直接访问资源会使用get方法");
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("建立表单（在index.jsp中）发送请求会用post方法");
    }
}
