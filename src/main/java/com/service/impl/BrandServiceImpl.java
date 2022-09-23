package com.service.impl;

import com.mapper.BrandMapper;
import com.pojo.Brand;
import com.pojo.PageBean;
import com.service.BrandService;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author Long-666
 * @create 2022-09-09 13:43
 */
public class BrandServiceImpl implements BrandService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();


    /**
     * 查询所有的数据
     * @return
     */
    @Override
    public List<Brand> selectAll(){
        //调用BrandMapper.selectAll的方法
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();
        sqlSession.close();
        return brands;
    }



    /**
     * 添加数据
     */
    @Override
    public void add(Brand brand){
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
         mapper.add(brand);
         //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Override
    public void deleteByIds(int[] ids) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();
    }


    /**
     * 根据id获取数据
     */
    public Brand selectById(int id){
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.selectById(id);
        sqlSession.close();
        return brand;
    }


    /**
     * 修改数据
     */
    public void updateById(Brand brand){
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.updateById(brand);
        sqlSession.commit();
        sqlSession.close();
    }


    /**
     * 根据Id 删除数据
     */
    @Override
    public void deleteById(int id){
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public PageBean<Brand> selectByPage(int currentPage, int pageSize) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //开始索引
        int begin = (currentPage-1)*pageSize;
        //每页数目
        int size = pageSize;
        List<Brand> rows = mapper.selectByPage(begin, size);
        int totalCount = mapper.selectTotalCount();
        PageBean<Brand> brandPageBean = new PageBean<>();
        brandPageBean.setRows(rows);
        brandPageBean.setTotalCount(totalCount);
        sqlSession.close();
        return brandPageBean;
    }

    @Override
    public PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //开始索引
        int begin = (currentPage-1)*pageSize;
        //每页数目
        int size = pageSize;
        String brandName = brand.getBrandName();
        if (brandName != null && brandName.length() > 0){
            brand.setBrandName("%"+brandName+"%");
        }
        String companyName = brand.getCompanyName();
        if (companyName != null && companyName.length() > 0){
            brand.setCompanyName("%"+companyName+"%");
        }
        List<Brand> rows = mapper.selectByPageAndCondition(begin, size,brand);
        int totalCount = mapper.selectTotalCountByCondition(brand);
        PageBean<Brand> brandPageBean = new PageBean<>();
        brandPageBean.setRows(rows);
        brandPageBean.setTotalCount(totalCount);
        sqlSession.close();
        return brandPageBean;
    }
}
