package org.example.servlet.login;
import org.example.pojo.User;
import org.example.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        if(!((String)request.getSession().getAttribute("checkCodeGen")).equalsIgnoreCase(request.getParameter("checkCode"))){
            System.out.println("[DEBUG]验证码错误,携带提示信息返回注册界面...");
            request.setAttribute("register_msg","验证码错误");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
            return;
        }
        boolean flag=new UserService().register(new User(request.getParameter("username"),request.getParameter("password")));
        if(flag){
            System.out.println("[DEBUG]用户注册成功,携带提示消息返回登录界面...");
            request.setAttribute("register_msg","注册成功，请登录");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else {
            System.out.println("[DEBUG]用户登录失败,携带提示消息返回注册界面...");
            request.setAttribute("register_msg","用户名已存在,注册失败");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
