package com.luoyi.cn.dao;

import java.util.List;

import com.luoyi.cn.dao.model.Category;

public interface CategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
    
    List<Category> getCateLists();
    
    Category findfatherById(Long id);
    
  
}