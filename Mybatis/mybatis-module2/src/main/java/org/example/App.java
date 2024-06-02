package org.example;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.BrandMapper;
import org.example.pojo.Brand;
import org.junit.Test;
import java.io.IOException;
import java.util.HashMap;

public class App
{

    @Test
    public void selectAll() throws IOException {
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        System.out.println("未做映射的输出：");
        brandMapper.selectAll1().forEach(System.out::println);
        System.out.println("做映射后的输出：");
        brandMapper.selectAll2().forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void selectById() throws IOException {
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        System.out.println(brandMapper.selectById(1));
        sqlSession.close();
    }

    @Test
    public void selectById2() throws IOException {
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        System.out.println(brandMapper.selectById2(1));
        sqlSession.close();
    }

    @Test
    public void selectByCondition() throws IOException {
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        System.out.println("1.通过传递多个参数查询数据");
        System.out.println(brandMapper.selectByCondition(0,"%三%","%三%"));
        System.out.println("2.通过传递对象查询数据");
        System.out.println(brandMapper.selectByCondition(new Brand("%三%","%三%",0)));
        System.out.println("3.通过传递Map查询数据");
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("status",0);
        hashMap.put("companyName","%三%");
        hashMap.put("brandName","%三%");
        System.out.println(brandMapper.selectByCondition(hashMap));
        System.out.println("4.缺少数据将会导致查询失误，为空的条件也将会被列入查询条件中");
        System.out.println(brandMapper.selectByCondition(0,"%三%",null));
        sqlSession.close();
    }

    @Test
    public void selectByCondition2() throws IOException {
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        System.out.println("多条件查询：不为null或空串就查询");
        System.out.println(brandMapper.selectByCondition2(0,"%三%",null));
        System.out.println("多条件查询：最多只查询一个条件");
        System.out.println(brandMapper.selectByCondition3(null,"%三%","%四%"));
        sqlSession.close();
    }

    @Test
    public void add() throws IOException {
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        System.out.println("6.2在使用openSession时传递参数true设置为默认提交事务");
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.add(new Brand("京东","京东",10,"京东~",1));
        sqlSession.close();
    }

    @Test
    public void add2() throws IOException {
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = new Brand("京东","京东",10,"京东~",1);
        brandMapper.add2(brand);
        System.out.print("7.添加数据的id为：");
        System.out.print(brand.getId());
        sqlSession.close();
    }

    @Test
    public void updateById() throws IOException {
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = new Brand(4,"淘宝","淘宝",10,"阿里巴巴~",1);
        System.out.print("8.修改数据，方法可返回修改条数：");
        System.out.println(brandMapper.updateById(brand));
        sqlSession.close();
    }

    @Test
    public void updateById2() throws IOException {
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = new Brand(5,"",null,20,"阿里巴巴~",1);
        brandMapper.updateById2(brand);
        sqlSession.close();
    }

    @Test
    public void deleteById() throws IOException {
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.deleteById(5);
        sqlSession.close();
    }

    @Test
    public void deleteByIds() throws IOException {
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        int[] arr = {1,2,3,4};
        brandMapper.deleteByIds(arr);
        sqlSession.close();
    }

}
