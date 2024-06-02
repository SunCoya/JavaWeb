package org.example.servlet.login;
import org.example.pojo.User;
import org.example.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        User user=new UserService().login(username,password);
        if (user==null){
            System.out.println("[DEBUG]登录失败,携带提示消息登陆界面...");
            request.setAttribute("login_msg","用户名密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
        System.out.println("[DEBUG]登录成功,添加session,跳转到查询界面...");
        if("on".equals(request.getParameter("remember"))) {
            System.out.println("[DEBUG]用户点击了记住我,添加cookie...");
            Cookie[] cookies = {new Cookie("username",username),new Cookie("password",username)};
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(60);
                response.addCookie(cookie);
            }
        }
        request.getSession().setAttribute("user",user);
        response.sendRedirect(request.getContextPath()+"/selectAllServlet");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}