package com.luoyi.cn.dao.model;

import java.util.HashSet;
import java.util.Set;



public class Category {
    private Long id;

    private String name;

    private Long parentId;
    
    /**
	 * 商品集合
	 */
	private Set<Product> products = new HashSet<Product>();

	/**
	 * 子类别
	 */
	private Set<Category> categories = new HashSet<Category>();

	/**
	 * 父亲
	 * @return
	 */
	private Category parent = null;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}
    
    
    
}