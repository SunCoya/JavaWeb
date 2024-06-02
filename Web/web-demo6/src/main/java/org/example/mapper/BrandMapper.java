package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.Brand;

import java.util.List;

public interface BrandMapper {
    //添加数据
    @Insert("insert into tb_brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void add(Brand brand);
    //删除数据
    @Delete("delete from tb_brand where id=#{id}")
    void deleteById(int id);
    //更新数据
    @Update("update tb_brand set brand_name=#{brandName}," +
            "company_name=#{companyName}," +
            "ordered=#{ordered}," +
            "description=#{description}," +
            "status=#{status} " +
            "where id=#{id}")
    void update(Brand brand);
    //删除选中数据
    void deleteByIds(int[] ids);
    //条件分页查询
    int selectCountByCondition(Brand brand);
    List<Brand> selectByPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("brand") Brand brand);

}
