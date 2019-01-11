package service.impl;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luoyi.cn.dao.model.Product;
import com.luoyi.cn.dao.uitl.Page;
import com.luoyi.cn.service.IProductService;

public class TestGetProAndImage {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-mybatis.xml"});
		IProductService  userService = (IProductService) context.getBean("productService");
		Page<Product> pages = userService.selectByName("电", 1, 4);
		List<Product> pros = pages.getLists();
		for (Product product : pros) {
			String name = product.getName();
			System.out.println(name);
		}
	}

	

	/* private String name;

    private Float price;
	
	 * 运费
	
    private Float freight;
    *//**
	 * 失效时间
	 *//*
    private Date expireTime;
    *//**
	 * 销售量
	 *//*
    private Integer sellNum;
    *//**
	 * 库存量
	 *//*
    private Integer stockNum;

    private String sellAddress;

    private Integer viewNum;

    private Long categoryId;
    
    //图片
    private String image;
	*/
	
	
	/*public static  void main(String[]args){
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-mybatis.xml"});
		IProductService  userService = (IProductService) context.getBean("productService");
		
		Product product = new Product();
		product.setName("lgm");
		product.setPrice(10.5f);
		product.setFreight(2f);
		product.setStockNum(100);
		product.setExpireTime(new Date());
		
		product.setImage("lgm.jpg");
		product.setViewNum(10);
		System.out.println(product.getName());
		int s = userService.save(product);
		
		System.out.println(s);
	}*/
	
	@Test
	public void testViewAdd1(){
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-mybatis.xml"});
		IProductService  userService = (IProductService) context.getBean("productService");
		Page<Product> pages = userService.selectByName("电", 1, 4);
		List<Product> pros = pages.getLists();
		for (Product product : pros) {
			String name = product.getName();
			System.out.println(name);
		}
	}
	
}