package org.example.web.response;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
    重定向相比于请求转发的不同点
        1.可定向到外部资源（百度），
        2.浏览器地址栏变化
        3.不能在多个资源共享请求数据
        4.对于重定向到Servlet的路径需要加项目名称（虚拟目录）在请求转发中不需要加项目名称
 */
@WebServlet("/resp1")
public class Demo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("重定向，可先设置状态码302，再设置响应头Header为新地址，这里使用简化写法");
        resp.sendRedirect(req.getContextPath()+"/demo1");
    }
}
