package com.wcy.mapper;

import com.wcy.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {
    List<Brand> selectAll();
    Brand selectById(int id);
//    List<Brand> selectByCondition(@Param("status") int status, @Param("brandName")String brandName, @Param("companyName")String companyName);
    List<Brand> selectByCondition(Brand brand);
    void add(Brand brand);
    void update(Brand brand);
    void delete(@Param("ids") int[] ids);
    void deleteById(int id);
}
