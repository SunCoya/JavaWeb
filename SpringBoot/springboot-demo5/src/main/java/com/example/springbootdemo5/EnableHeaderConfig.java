package com.example.springbootdemo5;
import org.springframework.context.annotation.Import;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)//只能声明在类前
//这个注解指定要导入哪些配置类和Bean，能够开启第三方依赖的自动功能
@Import(MyImportSelector.class)
public @interface EnableHeaderConfig {
}
