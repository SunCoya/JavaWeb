package org.example.web.request;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
    处理请求：
    1.如何获取请求中信息，能获得哪些信息？
    通过doGet方法中的req对象的方法获取请求信息
    能偶获得请求行，请求头，请求传递的参数，请求的路径等信息
    2.如何同时处理get请求与post请求？
    3.如何获取请求体的完整数据？
*/
@WebServlet("/req1")
public class Demo1 extends HttpServlet {
    @Override
    //访问req1?username=zhang
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        System.out.print("获取请求方式：");
        System.out.println(req.getMethod());
        System.out.print("获取请求头，如浏览器版本信息（请求头不分大小写）：");
        System.out.println(req.getHeader("user-agent"));
        System.out.print("获取请求传递的参数：");
        System.out.println(req.getQueryString());
        System.out.print("获取虚拟目录");
        System.out.println(req.getContextPath());
        System.out.print("获取资源标识符：");
        System.out.println(req.getRequestURI());
        System.out.print("获取统一资源定位符：");
        System.out.println(req.getRequestURL().toString());
    }

    @Override
    //访问html/req1.html填写表单，使用post发送请求
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("2.不同请求方式也能用相同方法处理数据，在doPost方法中也能掉用doGet方法处理相同内容的数据。");
        this.doGet(req,resp);
        System.out.println("3.请求体的信息可以用字节/字符输入流获取，不需要关闭输入流（跟随request消除）");
        System.out.println(req.getReader().readLine());
    }
}
