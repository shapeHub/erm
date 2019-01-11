package com.luoyi.cn.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.luoyi.cn.dao.model.Category;
import com.luoyi.cn.dao.model.Image;
import com.luoyi.cn.dao.model.Product;
import com.luoyi.cn.dao.uitl.Page;
import com.luoyi.cn.service.ICategoryService;
import com.luoyi.cn.service.IImageService;
import com.luoyi.cn.service.IProductService;



@Controller
@RequestMapping("/index")
public class IntiController {
	@Autowired
	ICategoryService categoryService;
	@Autowired
	IProductService productService;
	@Autowired
	IImageService imageService;
	
	@RequestMapping("")
	public ModelAndView inti(){
		ModelAndView view = new ModelAndView("index");
		//查找所有主要商品类型
		List<Category> lists = categoryService.getCateLists();
		//定义一个集合存放父类集合
		List<Category> products = new ArrayList<Category>();
		for (Category category : lists) { //通过父类id把子类添加到对象
			Category ps = categoryService.findfatherById(category.getId());
			//添加
			products.add(ps);
		}
		view.addObject("products",products); 
		Page<Product> showpage = productService.getOnePage(1, 9);
		List<Product> lp = showpage.getLists();
		for (Product product : lp) {
			product.getImage();
		}
		view.addObject("showpage",showpage);
		
		return view;
		
	}
	
	//显示全部目录
	@RequestMapping("/catlist")
	public ModelAndView catlist( String currentPage, String pageSize){
		
		
		Integer currentPages = Integer.parseInt(currentPage);
		Integer pageSizes = Integer.parseInt(pageSize);
		ModelAndView view = new ModelAndView("catlist");
		Page<Product> pages = productService.getOnePage(currentPages, pageSizes);
		
		view.addObject("pages",pages);
		view.addObject("controllerName","catlist?");
		return view;
		
	}
	
	@RequestMapping("/header")
	public ModelAndView selectCatlist(HttpSession session ){
		ModelAndView view  = null;
		if(session.getAttribute("conditionUser")!=null){
			view = new ModelAndView("user/header");
			
		}else{
			view = new ModelAndView("header");
		}
		List<Category> allType = categoryService.getCateLists();
		view.addObject("allType",allType);
		return view;
		
		
		
	}
	
	@RequestMapping("/secondcatlist")
	public ModelAndView selectcatlist(String id, String currentPage, String pageSize){
		Integer ids = Integer.parseInt(id);
		Integer currentPages = Integer.parseInt(currentPage);
		Integer pageSizes = Integer.parseInt(pageSize);
		ModelAndView view = new ModelAndView("catlist");
		Page<Product> pages = productService.getProduct_second(ids, currentPages, pageSizes);
		view.addObject("pages",pages);
		view.addObject("controllerName","secondcatlist?id="+id+"&");
		return view;
		
	}
	

	@RequestMapping("/threeecatlist")
	public ModelAndView threeecatlist(String id, String currentPage, String pageSize){
		Integer ids = Integer.parseInt(id);
		Integer currentPages = Integer.parseInt(currentPage);
		Integer pageSizes = Integer.parseInt(pageSize);
		ModelAndView view = new ModelAndView("catlist");
		
		Page<Product> pages = productService.getProduct_three(ids, currentPages, pageSizes);
		view.addObject("pages",pages);
		view.addObject("controllerName","threeecatlist?id="+id+"&");
		return view;
		
	}
	
	/**
	 * 模糊查询
	 * @param name
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/showByName")
	public ModelAndView showByName(String name, String currentPage, String pageSize){
		
		Integer currentPages = Integer.parseInt(currentPage);
		Integer pageSizes = Integer.parseInt(pageSize);
		ModelAndView view = new ModelAndView("catlist");
		
		Page<Product> pages = productService.selectByName(name,currentPages, pageSizes);
		view.addObject("pages",pages);
		view.addObject("controllerName","showByName?name="+name+"&");
		return view;
		
	}
	
	@RequestMapping("/showinfo")
	public ModelAndView showinfo(String id){
		Integer ids = Integer.parseInt(id);		
		ModelAndView view = new ModelAndView("info");
		Product product= productService.getProductAndImgById(ids);
		view.addObject("productinfo",product);
		return view;
		
	}
	
	@RequestMapping("/showbuy")
	public ModelAndView showbuy(HttpSession session){
		if(session.getAttribute("cars")==null){
			session.removeAttribute("beforceDiscount");
			session.removeAttribute("afterDiscount");
		}
		ModelAndView view = new ModelAndView("buy");
	
		return view;
		
	}
}
