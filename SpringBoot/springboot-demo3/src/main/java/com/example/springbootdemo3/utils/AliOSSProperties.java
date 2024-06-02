package com.example.springbootdemo3.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Data
@Component
//第二种注入外部属性的方式：自动注入配置文件的属性，要求配置文件中的属性与类中属性一致，适用于属性多且需要复用的情况
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliOSSProperties {
    private String endpoint;
    private String bucketName;
}
