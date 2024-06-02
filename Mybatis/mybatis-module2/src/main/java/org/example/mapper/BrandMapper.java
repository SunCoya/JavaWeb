package org.example.mapper;
import org.apache.ibatis.annotations.*;
import org.example.pojo.Brand;

import java.util.List;
import java.util.Map;
public interface    BrandMapper {
    List<Brand> selectAll1();
    List<Brand> selectAll2();
    Brand selectById(int id);

    /*
        3.使用注解的形式来实现，不需要写mapper.xml中的配置文件
        注解中的内容与mapper.xml文件中的内容一致
        引用mapper.文件中的ResultMap可以使用@ResultMap标签
    */
    @Select("select * from tb_brand where id=#{id};")
    @ResultMap("brandResultMap")
    Brand selectById2(int id);

    /*
       多条件查询接口1：传递多个参数
       不写注解会报错，这里的注解名对应的是mapper.xml中#{}内的内容
       如果传递多个参数，mybatis会创建map集合封装
       不使用注解的话，mapper.xml文件中#{}内就只能用arg0~n和param1~n
    */
    List<Brand> selectByCondition(
            @Param("status")int status,
            @Param("companyName")String companyName,
            @Param("brandName")String brandName);

    /*
        多条件查询接口2：传递实体类对象
        映射文件里面找哪个值就去给他的对象的那个方法里面找对应的get方法
    */
    List<Brand> selectByCondition(Brand brand);
    /*
        多条件查询接口3：传递Map
        键对应类的属性（mapper.xml中#{}内的内容），值对应数据
    */
    List<Brand> selectByCondition(Map map);

    List<Brand> selectByCondition2(
            @Param("status")int status,
            @Param("companyName")String companyName,
            @Param("brandName")String brandName);
    List<Brand> selectByCondition3(
            @Param("status")Integer status,
            @Param("companyName")String companyName,
            @Param("brandName")String brandName);

    void add(Brand brand);
    void add2(Brand brand);

    /*增删改方法都可返回修改行数*/
    int updateById(Brand brand);

    int updateById2(Brand brand);

    int deleteById(int id);

    int deleteByIds(int[] ids);


}
