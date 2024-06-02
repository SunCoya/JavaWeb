package com.example.springbootdemo3.interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//代表当前类是一个配置类，在这里配置拦截器
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*
            添加拦截器，过滤所有资源，指定不需要拦截的资源
            如果路径只有/*，则只能匹配一级路径/**代表任意级路径
            如果路径是/depts/*，则匹配depts的下一级路径（不包括/depts）
            /depts/** 匹配depts下的任意级路径（包括/depts）
        */
         registry.addInterceptor(loginCheckInterceptor).addPathPatterns("/**").excludePathPatterns("/login");
    }
}
