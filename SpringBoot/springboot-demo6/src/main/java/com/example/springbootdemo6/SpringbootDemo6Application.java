package com.example.springbootdemo6;

import com.example.springbootdemo5.EnableHeaderConfig;
import com.example.springbootdemo5.HeaderConfig;
import com.example.springbootdemo5.HeaderParser;
import com.example.springbootdemo5.MyImportSelector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/*

导入demo5的pom文件之后再到此处引入Bean到IOC容器
方案一：设置包扫描范围
@ComponentScan({"com.example.springbootdemo5","com.example.springbootdemo6",})

方案二，直接导入类，可以导入常规类，配置类，importselector的实现类

导入常规类
@Import(HeaderParser.class)

导入配置类，配置类里面声明了Bean，可以把配置类里面声明的Bean加入到容器中
@Import(HeaderConfig.class)

导入importselector的实现类
@Import(MyImportSelector.class)
*/

//自动自动装配第三方的Bean，在EnableHeaderConfig这个接口中指定需要导入的类（接口自己写import就行）
@EnableHeaderConfig
@SpringBootApplication
/*
	点开注解-springbootconfiguration可以看到里面声明了configuration注解
	即表示，当前类，其实也是一个配置类，所以也能在这个类中声明bean
	@Inherited：允许子类继承父类中的注解，可以通过反射获取到父类的注解
	@Documented:用于标记在生成javadoc时是否将注解包含进去
	-componentScan是用于组件扫描的注解，默认当前包与子包扫描

	-enableAutoconfiguration （最核心） 底层封装import注解来导入bean
	看一看自动配置jar包中的META-INF下的springfactory文件与spring目录下的配置文件
	可以看到spring的配置自动注入的相关信息
	在mybatis或者是springboot的依赖包下都可以找到自动配置相关的依赖

	看看mybatis-springboot-starter，里面就把mybatis所需要的依赖配置在配置文件当中
	在springboot-autoconfigurejar包里面配置好自动配置所需要信息，然后在stater里面引入auto-configure就行
*/
public class SpringbootDemo6Application {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemo6Application.class, args);
	}
}
