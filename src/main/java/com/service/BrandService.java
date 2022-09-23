package com.service;

import com.pojo.Brand;
import com.pojo.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Long-666
 * @create 2022-09-16 14:49
 */
public interface BrandService {
    /**
     * 查询所有
     * @return
     */
    List<Brand> selectAll();

    /**
     * 添加数据
     * @param brand
     */
    void add(Brand brand);

    /**
     * 批量删除数据
     */
    void deleteByIds(int[] ids);


    /**
     * 删除一条数据
     */
    void deleteById(int id );

    /**
     * 分页查询
     * @param currentPage 当前页码
     * @param pageSize 每页展示条目数
     * @return
     */
    PageBean<Brand> selectByPage(int currentPage,int pageSize);

    PageBean<Brand> selectByPageAndCondition(int currentPage,int pageSize,Brand brand);
}
