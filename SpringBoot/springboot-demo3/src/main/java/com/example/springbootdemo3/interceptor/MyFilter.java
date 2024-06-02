package com.example.springbootdemo3.interceptor;
import com.alibaba.fastjson2.JSONObject;
import com.example.springbootdemo3.pojo.Result;
import com.example.springbootdemo3.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import java.io.IOException;
@Slf4j
//@WebFilter
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest hsr = ((HttpServletRequest)req);
        String url = hsr.getRequestURL().toString();
        if (url.contains("login")){
            log.info("用户进入登录界面");
            filterChain.doFilter(req,resp);
            return;
        }
        String jwt = hsr.getHeader("token");
        if (!StringUtils.hasLength(jwt)){
            log.info("token为空");
            Result result = Result.error("NOT_LOGIN");
            resp.getWriter().write(JSONObject.toJSONString(result));
            return;
        }
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            log.info("解析令牌失败");
            Result result = Result.error("NOT_LOGIN");
            resp.getWriter().write(JSONObject.toJSONString(result));
            return;
        }
        log.info("登陆成功");
        filterChain.doFilter(req,resp);
    }
}
