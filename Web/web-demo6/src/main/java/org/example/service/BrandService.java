package org.example.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.mapper.BrandMapper;
import org.example.pojo.Brand;
import org.example.pojo.PageBean;
import org.example.util.SqlSessionFactoryUtil;

import java.util.List;

public class BrandService {
    SqlSessionFactory factory = SqlSessionFactoryUtil.getssf();
    public void add(Brand brand) {
        SqlSession sqlsession=factory.openSession(true);
        sqlsession.getMapper(BrandMapper.class).add(brand);
        sqlsession.close();
    }
    public void deleteById(int id) {
        SqlSession sqlsession=factory.openSession(true);
        sqlsession.getMapper(BrandMapper.class).deleteById(id);
        sqlsession.close();
    }
    public void update(Brand brand) {
        SqlSession sqlsession=factory.openSession(true);
        sqlsession.getMapper(BrandMapper.class).update(brand);
        sqlsession.close();
    }
    public void deleteByIds(int[] ids) {
        SqlSession sqlsession=factory.openSession(true);
        sqlsession.getMapper(BrandMapper.class).deleteByIds(ids);
        sqlsession.close();
    }
    public PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand) {
        SqlSession sqlsession=factory.openSession(true);
        BrandMapper mapper=sqlsession.getMapper(BrandMapper.class);
        String brandName=brand.getBrandName();
        if(brandName!=null && !brandName.isEmpty()) brand.setBrandName("%"+brandName+"%");
        String companyName=brand.getCompanyName();
        if(companyName!=null && !companyName.isEmpty()) brand.setCompanyName("%"+companyName+"%");

        PageBean<Brand> pageBean=new PageBean<>(mapper.selectCountByCondition(brand),
                        mapper.selectByPageAndCondition((currentPage-1)*pageSize,pageSize,brand));
        sqlsession.close();
        return pageBean;
    }
}
