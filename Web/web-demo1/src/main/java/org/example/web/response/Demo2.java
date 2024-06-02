package org.example.web.response;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//如何响应字符数据到浏览器？如何解决数据响应乱码的问题？
@WebServlet("/resp2")
public class Demo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("解决响应数据乱码可设置文本格式与编码格式");
        resp.setContentType("text/html;charset=UTF-8");
        System.out.println("使用字符流响应字符数据");
        resp.getWriter().write("<h1>字符数据</h1>");
    }
}
