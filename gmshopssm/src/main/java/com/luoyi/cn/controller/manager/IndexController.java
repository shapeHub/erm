package com.luoyi.cn.controller.manager;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luoyi.cn.dao.model.User;
import com.luoyi.cn.service.IUserService;

@Controller
@RequestMapping("/manager/index")
public class IndexController {
	
	
	@Autowired
	IUserService userService;
	@RequestMapping("/getuser")
	public String getUserById(String id,HttpSession session){
		System.out.println("id="+id);
		User user = userService.getUserById(Long.parseLong(id));
		session.setAttribute("user", user);
		
		return "/index";
		
		
	}
	
	
	
	@RequestMapping("")
	public String main(){
		System.out.println("/WEB-INF/manage/main.jsp");
		return "/WEB-INF/views/manager/main";
	}
	
	@RequestMapping("/top")
	public String top(){
		return "/WEB-INF/views/manager/top";
	}
	
	@RequestMapping("/wellcome")
	public String wellcome(){
		return "/WEB-INF/views/manager/wellcome";
	}
	
	@RequestMapping("/left")
	public String left(){
		return "/WEB-INF/views/manager/left";
	}
	
	
}
