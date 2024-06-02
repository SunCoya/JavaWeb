package com.example.springbootdemo5;
import io.jsonwebtoken.Jwts;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeaderConfig {

    /*
    @Conditional是父注解，可用于类（对于类声明的bean有效），方法（针对于方法声明的bean有效）
    @ConditionalOnClass//环境有字节码文件则注册
    @ConditionalOnMissingBean//环境中没有bean对象则注册
    @ConditionalOnProperty//配置文件有对应的属性和值才注册
    */
    @Bean
    public HeaderParser headerParser(){
        return new HeaderParser();
    }

    @Bean
    //@ConditionalOnClass(name="io.jsonwebtoken.Jwts")//当前环境是否有该类，一般引jar包就有
    //@ConditionalOnMissingBean(value = HeaderGenerator.class)
    //@ConditionalOnMissingBean(name = "headerGenerator")
    //@ConditionalOnMissingBean主要应用于：用户自己定义了该类型的bean则使用用户的bean
    @ConditionalOnProperty(name = "name",havingValue = "coya")//判断配置文件中是否存在属性与属性值才加入
    public HeaderGenerator headerGenerator(){
        return new HeaderGenerator();
    }
}
