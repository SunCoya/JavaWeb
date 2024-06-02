package org.example.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.mapper.BrandMapper;
import org.example.pojo.Brand;
import org.example.util.SqlSessionFactoryUtil;

import java.util.List;

public class BrandService {
    SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtil.getssf();
    public List<Brand> selectAll(){
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        BrandMapper mapper =sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands=mapper.selectAll();
        sqlSession.close();
        return brands;
    }
    public void add(Brand brand){
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        BrandMapper mapper =sqlSession.getMapper(BrandMapper.class);
        mapper.add(brand);
        sqlSession.close();
    }
    public Brand selectById(int id){//更新数据时回显数据
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        BrandMapper mapper =sqlSession.getMapper(BrandMapper.class);
        Brand brand=mapper.selectById(id);
        sqlSession.close();
        return brand;
    }
    public void update(Brand brand){
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        BrandMapper mapper =sqlSession.getMapper(BrandMapper.class);
        mapper.update(brand);
        sqlSession.close();
    }
    public void deleteById(int id){
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        BrandMapper mapper =sqlSession.getMapper(BrandMapper.class);
        mapper.deleteById(id);
        sqlSession.close();
    }
}
