package org.example.web.request;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.StringJoiner;

//有哪些方式处理请求信息传递的参数？
@WebServlet("/req2")
public class Demo2  extends HttpServlet {
    @Override
    //req2?username=coya&password=123456&hobby=1&hobby=2
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        System.out.print("1.根据name获取单个参数:");
        System.out.println(req.getParameter("username"));
        System.out.print("2.根据name获取多个参数:");
        String[] hobbies = req.getParameterValues("hobby");
        //在这里使用Arrays的方法转换成Stream流的话会出现空指针错误
        for (String hobby : hobbies) {System.out.print(hobby+" ");}
        System.out.println();
        System.out.println("3.获取所有参数的Map<String,String[]>集合");
        req.getParameterMap().forEach((s, strings) -> {
            System.out.print(s+":");
            StringJoiner sj = new StringJoiner(",");
            for (String string : strings) {sj.add(string);}
            System.out.println(sj);
        });
    }
    //html/req2.html
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.doGet(req, resp);
    }
}
