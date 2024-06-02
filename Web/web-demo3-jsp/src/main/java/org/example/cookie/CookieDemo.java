package org.example.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
会话跟踪：HTTP协议每次向浏览器请求数据时，会将该请求视为新请求
服务器需要识别多次请求是否来自同一浏览器以便在多次请求间共享数据
1.查看cookies：谷歌控制台Application
2.Cookies的实现基于HTTP协议（响应头，请求头），Session基于cookie实现（发送sessionId）
3.发送cookie：以键值对的形式创建cookie，使用响应对象添加cookie
4.设置cookie对象的在浏览器中的存活时间：单位为秒，cookie默认为浏览器关闭cookie消失
5.接收cookie：通过请求对象接收所有cookie数组并遍历
*/
@WebServlet("/cookie")
public class CookieDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("username", "zhangsan");
        cookie.setMaxAge(60);
        response.addCookie(cookie);

        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {System.out.println(c.getName() + ":" + c.getValue());}
    }
}
