package com.luoyi.cn.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luoyi.cn.dao.model.Product;
import com.luoyi.cn.service.IProductService;

@Controller
@RequestMapping("/productController")
public class ProductController {
	@Autowired
	IProductService productService;
	
	@RequestMapping("/addProduct")
	@ResponseBody
	public String addProduct(Product product,HttpServletRequest req){
		
		int result = productService.save(product);
		if(result>0){
			return "添加成功";
		}else{
			return "添加失败";
		}
		
		
	}
	
	
}
