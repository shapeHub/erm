package com.luoyi.cn.service;

import java.util.List;

import com.luoyi.cn.dao.model.Category;

public interface ICategoryService {
	public List<Category> getCateLists();
	
	Category findfatherById(Long id);
}
