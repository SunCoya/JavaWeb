package com.aliyun.oss;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//声明为配置类
@Configuration
//把这个类直接导入IOC容器，底层就是Import注解，效果和EnableAuto...一样，只不过后者是自动配置
@EnableConfigurationProperties(AliOSSProperties.class)
public class AliOssAutoConfiguration{//把全类名放到自动配置文件中
    @Bean
    public AliOSSUtils aliOSSUtils(AliOSSProperties aliOSSProperties){
        AliOSSUtils aliOSSUtils = new AliOSSUtils();
        aliOSSUtils.setAliOSSProperties(aliOSSProperties);
        return aliOSSUtils;
    }
}
