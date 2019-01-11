package com.luoyi.cn.service;

import com.luoyi.cn.dao.model.Product;
import com.luoyi.cn.dao.uitl.Page;

public interface IProductService  {
	/**
	 * 通过页数和列数获取全部商品的信息
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public Page<Product> getOnePage(int currentPage, int pageSize);
	/**
	 * 通过页数currentPage和列数pageSize和二级目录id获取二级目录商品信息
	 * @param id
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public Page<Product> getProduct_second(int id,int currentPage, int pageSize);
	/**
	 * 通过页数currentPage和列数pageSize和三级目录id获取三级目录商品信息
	 * @param id
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public Page<Product> getProduct_three(int id,int currentPage, int pageSize);
	/**
	 * 通过传入product参数保存商品信息到数据库
	 * @param product
	 * @return 成功1或者失败-1
	 */
	public int save(Product product);
	/**
	 * 通过商品的id获取商品信息，以及所有图片，以及增加浏览量
	 * @param id
	 * @return
	 */
	public Product getProductAndImgById(int id);
	
	public Page<Product> selectByName(String name,int currentPage, int pageSize);
	
}
