package com.example.springbootdemo5;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
//返回数组为需要加入IOC容器的类
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.example.springbootdemo5.HeaderConfig"};
    }
}
