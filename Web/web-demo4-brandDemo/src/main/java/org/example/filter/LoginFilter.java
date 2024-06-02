package org.example.filter;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
/*
设置放行资源:通过获取的路径来判断是否包含目标字符串
检测用户是否登录:判断session里面是否有user
*/
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        String[] urls = {"/css/", "/img/", "/login.jsp", "/register.jsp", "/loginServlet", "registerServlet", "/checkCodeServlet","/selectUserServlet"};
        String uri=req.getRequestURI();
        for (String u : urls) {
            if (uri.contains(u)||"/web_demo4_brandDemo_war/".equals(uri)) {
                System.out.println("[DEBUG]请求服务器资源..."+uri);
                chain.doFilter(request, response);
                return;
            }
        }
        if (req.getSession().getAttribute("user") == null) {
            System.out.println("[DEBUG]用户未登录访问数据资源,携带提示信息返回登录界面...");
            req.setAttribute("login_msg", "您尚未登陆");
            req.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        System.out.println("[DEBUG]用户合法访问服务器资源..."+uri);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
}
