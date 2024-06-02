package org.example.cookie;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//拦截资源目录，和@WebServlet一样的写法
@WebFilter("/session")
public class FilterDemo implements Filter {
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截资源后放行......");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("放行后输出......");
    }
    public void init(FilterConfig filterConfig) {}
    public void destroy() {}
}
