package com.wcy.test;

import com.wcy.mapper.BrandMapper;
import com.wcy.mapper.UserMapper;
import com.wcy.pojo.Brand;
import com.wcy.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class MyBatisTest {

    @Test
    public void testSelectAll() throws IOException{
        //1.加载核心配置文件，获取sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取sqlsession对象用来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.执行sql
//        List<User> users = sqlSession.selectList("test.selectAll");
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);
        sqlSession.close();
    }

    @Test
    public void testSelectById() throws IOException{
        //1.加载核心配置文件，获取sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取sqlsession对象用来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = brandMapper.selectById(1);
        System.out.println(brand);
        sqlSession.close();
    }

    @Test
    public void testSelectByCondition() throws IOException{
        int status = 1;
        String brandName = "华为";
        String companyName = "华为";
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";
        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setBrand_name(brandName);
//        brand.setCompany_name(companyName);
        //1.加载核心配置文件，获取sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取sqlsession对象用来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectByCondition(brand);
        System.out.println(brands);
        sqlSession.close();
    }

    @Test
    public void testInsert() throws IOException{
        int status = 1;
        String brandName = "优乐美";
        String companyName = "优乐美有限公司";
        int ordered = 100;
        String description = "想把你捧在手心";
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrand_name(brandName);
        brand.setCompany_name(companyName);
        brand.setDescription(description);
        brand.setOrdered(ordered);
        //1.加载核心配置文件，获取sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取sqlsession对象用来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.add(brand);
        System.out.println(brand.getId());
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException{
        int status = 0;
        String brandName = "优乐美";
        String companyName = "优乐美有限公司";
        int ordered = 90;
        String description = "想把你捧在手心";
        Brand brand = new Brand();
        brand.setStatus(status);
//        brand.setBrand_name(brandName);
//        brand.setCompany_name(companyName);
//        brand.setDescription(description);
        brand.setOrdered(ordered);
        brand.setId(5);
        //1.加载核心配置文件，获取sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取sqlsession对象用来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.update(brand);
        sqlSession.close();
    }

    @Test
    public void testDeleteById() throws IOException{
        int[] ids={1,2,3};
        //1.加载核心配置文件，获取sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取sqlsession对象用来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.delete(ids);
        sqlSession.close();
    }
}
