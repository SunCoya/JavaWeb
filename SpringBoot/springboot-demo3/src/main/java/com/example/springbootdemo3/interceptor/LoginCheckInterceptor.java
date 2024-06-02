package com.example.springbootdemo3.interceptor;

import com.alibaba.fastjson2.JSONObject;
import com.example.springbootdemo3.pojo.Result;
import com.example.springbootdemo3.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
//拦截器的拦截范围比过滤器Filter小
@Slf4j
@Component
//指定接口
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    //目标资源方法前运行，返回代表放行与否
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        String jwt = req.getHeader("token");
        if (!StringUtils.hasLength(jwt)){
            log.info("token为空");
            resp.getWriter().write(JSONObject.toJSONString(Result.error("NOT_LOGIN")));
            return false;
        }
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            log.info("解析令牌失败");
            resp.getWriter().write(JSONObject.toJSONString(Result.error("NOT_LOGIN")));
            return false;
        }
        log.info("登陆成功");
        return true;
    }

    //调用目标资源后运行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }
}
