package com.luoyi.cn.dao;

import java.util.List;

import com.luoyi.cn.dao.model.Product;

public interface ProductMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
    
    int getTotalCount();
    int get_secondTotalCount(Integer id);
    int get_ThreeTotalCount(Integer id);
    
    List<Product> getProductList(Integer currentPage, Integer pageSize);
    
    List<Product>  getProduct_second(Integer id,Integer currentPage, Integer pageSize); 
    
    List<Product> selectByCategoryId(Integer id,Integer currentPage, Integer pageSize);
    
    Product getProductAndImgById(Integer id);
    
    //让浏览量view_num+1
    void updateProViewById(Integer id);
    
    
    
    //模糊查询
    int get_ByNameCount(String name);
    List<Product> selectByName(String name,Integer currentPage, Integer pageSize);
    
    
    
    
}