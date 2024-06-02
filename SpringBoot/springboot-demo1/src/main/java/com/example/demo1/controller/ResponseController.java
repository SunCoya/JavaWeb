package com.example.demo1.controller;

import com.example.demo1.pojo.Address;
import com.example.demo1.pojo.Emp;
import com.example.demo1.pojo.Result;
import com.example.demo1.service.EmpService;
import com.example.demo1.service.impl.EmpServiceA;
import com.example.demo1.utils.XmlParserUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@RestController
public class ResponseController {
    private final EmpService empService = new EmpServiceA();

    //响应方法返回的数据，对象自动转json，需要在方法上写上对应的返回类型，前面的案例全是字符串
    @RequestMapping("/getAddrList")
    public List<Address> getArrList(){
        List<Address> list= new ArrayList<>();
        Collections.addAll(list,new Address("广东","深圳"),new Address("湖南","长沙"));
        return list;
    }

    //使用Result统一管理响应数据
    @RequestMapping("/getResult")
    public Result getResult(){
        return Result.error("哎哟你干嘛");
    }

    /*
    案例
    1.引入dom4j依赖
    2.创建Emp实体类
    3.引入xml文件
    4.引入工具类（这个使用到了反射）
    5.前端页面放在static下，这个不必要
    */

    //请求路径和html页面中的路径一样,写好访问路径即可
    @RequestMapping("/listEmp")
    public Result getEmp(){
        //获取的打包后的classes目录下的文件
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
        empList.forEach(emp -> {
            if ("1".equals(emp.getGender()))emp.setGender("男");
            else emp.setGender("女");}
        );
        return Result.success(empList);
    }

    @RequestMapping("/listEmp1")
    public Result getEmp1(){
        return Result.success(empService.listEmp());
    }
}
