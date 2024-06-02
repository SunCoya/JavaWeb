package com.example.springbootdemo4aop;

import com.example.springbootdemo4aop.mvc.DeptMapper;
import com.example.springbootdemo4aop.mvc.DeptService;
import com.example.springbootdemo4aop.mvc.DeptServiceImpl;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringbootDemo4AopApplicationTests {

	//自动注入IOC容器对象
	@Autowired
	private ApplicationContext applicationContext;

	@Test
	void getBean(){
		//通过名称获取bean，首字母小写，都是同一个对象
		Object deptMapper1 = applicationContext.getBean("deptMapper");
		System.out.println(deptMapper1);
		DeptMapper deptMapper2 = applicationContext.getBean(DeptMapper.class);
		System.out.println(deptMapper2);
		DeptMapper deptMapper3 = applicationContext.getBean("deptMapper", DeptMapper.class);
		System.out.println(deptMapper3);
	}

	//给服务层设置了bean作用域
	@Test
	void getNewBean(){
		for (int i = 0; i < 5; i++) {
			DeptService deptService = applicationContext.getBean("deptServiceImpl", DeptServiceImpl.class);
			System.out.print(deptService + " ");
			DeptMapper deptMapper = applicationContext.getBean("deptMapper", DeptMapper.class);
			System.out.println(deptMapper);
		}
	}


	//给第三方的jar包里面的类声明bean使用@Bean，引入dom4j，在配置类里面声明bean
	@Test
	void getOtherBean(){
		SAXReader saxReader = applicationContext.getBean(SAXReader.class);
		System.out.println(saxReader);
	}


}
