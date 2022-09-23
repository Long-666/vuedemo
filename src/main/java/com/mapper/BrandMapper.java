package com.mapper;

import com.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Long-666
 * @create 2022-09-09 13:23
 */
public interface BrandMapper {

    /**
     * 查询所有的数据
     * @return
     */
    @Select("select * from tb_brand order by ordered")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();


    /**
     * 添加数据
     */
    @Insert("insert into tb_brand values (null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    @ResultMap("brandResultMap")
    void add(Brand brand);


    /**
     * 根据编号查询数据
     */
    @Select("select * from tb_brand where id = #{id}")
    @ResultMap("brandResultMap")
    Brand selectById(int id);


    /**
     * 根据修改数据
     */
    @Update("update tb_brand set brand_name = #{brandName},company_name = #{companyName},ordered = #{ordered},description = #{description},status = #{status} where id = #{id}")
    void updateById(Brand brand);

    /**
     * 根据id删除数据
     */
    @Delete("delete from tb_brand where id = #{id}")
    void deleteById(int id);


    /**
     * 批量删除数据
     */
    void deleteByIds(@Param("ids") int[] ids);


    /**
     * 分页查询
     */
    @Select("select * from tb_brand limit #{begin},#{size}")
    @ResultMap("brandResultMap")
    List<Brand> selectByPage(@Param("begin") int begin,@Param("size") int size);

    /**
     * 查询总记录数
     */
    @Select("select count(*) from tb_brand")
    int selectTotalCount();


    /**
     * 条件分页查询
     */
    List<Brand> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("brand") Brand brand);

    /**
     * 条件查询总记录数
     */
    int selectTotalCountByCondition(Brand brand);
}
