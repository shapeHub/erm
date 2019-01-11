package com.luoyi.cn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luoyi.cn.dao.CategoryMapper;
import com.luoyi.cn.dao.model.Category;
import com.luoyi.cn.service.ICategoryService;

@Service("categoryService")
public class CategoryServiceImpl implements ICategoryService {
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	//查找所有总类商品
	public List<Category> getCateLists() {
		return categoryMapper.getCateLists();
	}
	/*
	 * 
	 * 查找id为？的总类，及其子类商品
	 * */
	public Category findfatherById(Long id) {
		return categoryMapper.findfatherById(id);
	}
	
	
}
