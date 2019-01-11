 package com.luoyi.cn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luoyi.cn.dao.ImageMapper;
import com.luoyi.cn.dao.ProductMapper;
import com.luoyi.cn.dao.model.Image;
import com.luoyi.cn.dao.model.Product;
import com.luoyi.cn.dao.uitl.Page;
import com.luoyi.cn.service.IProductService;

@Service("productService")
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	ImageMapper imageMapper;
	
	
	public Page<Product> getOnePage(int currentPage, int pageSize) {
		int count = productMapper.getTotalCount();
		
		int Total = count%pageSize==0?count/pageSize:(count/pageSize)+1;
		
		if(currentPage<2){
			currentPage=1;
		}
		if(currentPage>=Total){
			currentPage=Total;
		}
		List<Product> lists = productMapper.getProductList((currentPage-1)*pageSize, pageSize);
		
		for (Product product : lists) {
			List<Image> images  = imageMapper.selectByProId(product.getId());
			String image = null;
			if(images!=null){
				image = images.get(0).getUrl();
			}else{
				image="title_login_2.png";
			}
			product.setImage(image);
		}
		return new Page<Product>(currentPage, count, pageSize, lists);
	}


	//查询二级目录
	public Page<Product> getProduct_second(int id,int currentPage, int pageSize) {
		
		int count = productMapper.get_secondTotalCount(id);
		
		
		int Total = count%pageSize==0?count/pageSize:(count/pageSize)+1;
		
		if(currentPage<=0){
			currentPage=1;
		}
		if(currentPage>=Total){
			currentPage=Total;
		}
		
		List<Product> lists =  productMapper.getProduct_second(id,(currentPage-1)*pageSize, pageSize);
		for (Product product : lists) {
			List<Image> images  = imageMapper.selectByProId(product.getId());
			String image = null;
			if(!images.isEmpty()){
				image = images.get(0).getUrl();
			}else{
				image="title_login_2.png";
			}
			product.setImage(image);
		}
		return new Page<Product>(currentPage, count, pageSize, lists);
	}

	//存product
	public int save(Product product) {
		
		return productMapper.insertSelective(product);
		
	}


	//查询三级目录
	public Page<Product> getProduct_three(int id, int currentPage, int pageSize) {
		int count = productMapper.get_ThreeTotalCount(id);
		int Total = count%pageSize==0?count/pageSize:(count/pageSize)+1;
		if(currentPage<2){
			currentPage=1;
		}
		if(currentPage>=Total){
			currentPage=Total;
		}
		List<Product> lists =  productMapper.selectByCategoryId(id, (currentPage-1)*pageSize, pageSize);
		for (Product product : lists) {
			List<Image> images  = imageMapper.selectByProId(product.getId());
			String image = null;
			if(!images.isEmpty()){
				image = images.get(0).getUrl();
			}else{
				image="title_login_2.png";
			}
			product.setImage(image);
		}
		return new Page<Product>(currentPage, count, pageSize, lists);
	}


	public Product getProductAndImgById(int id) {
		
		productMapper.updateProViewById(id);
		List<Image> images  = imageMapper.selectByProId((long)id);
		Product p = productMapper.getProductAndImgById(id);
		p.setImage(images.get(0).getUrl());
		
		return p;
	}


	public Page<Product> selectByName(String name,int currentPage, int pageSize) {
		name = "%"+name+"%";
		int count = productMapper.get_ByNameCount(name);
		if(count==0){
			return new Page<Product>(1, 0, pageSize, null);
		}else{
			int Total = count%pageSize==0?count/pageSize:(count/pageSize)+1;
			if(currentPage<1){
				currentPage=1;
			}
			if(currentPage>Total){
				currentPage=Total;
			}
			List<Product> lists =  productMapper.selectByName(name,(currentPage-1)*pageSize, pageSize);
			for (Product product : lists) {
				List<Image> images  = imageMapper.selectByProId(product.getId());
				String image = null;
				if(!images.isEmpty()){
					image = images.get(0).getUrl();
				}else{
					image="title_login_2.png";
				}
				product.setImage(image);
			}
			return new Page<Product>(currentPage, count, pageSize, lists);
		}
		
		
	}

	//通过id查询图片，显示单个商品信息信息

	
}
