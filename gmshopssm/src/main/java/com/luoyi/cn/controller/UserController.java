package com.luoyi.cn.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.luoyi.cn.dao.model.User;
import com.luoyi.cn.service.IUserService;

@Controller
@RequestMapping("/userController")
public class UserController {

	@Autowired
	IUserService userService;
	@RequestMapping("/getuser")
	public String getUserById(String id,HttpSession session){
		
		User user = userService.getUserById(Long.parseLong(id));
		session.setAttribute("user", user);
		return "/index";
	}
	

	@RequestMapping(value="/login")
	public String login(String loginName,String pass,HttpSession session){
		
		User conUser = new User();
		conUser.setLoginName(loginName);
		conUser.setPass(pass);
		conUser = userService.login(conUser);
		
		if(null != conUser){
			session.setAttribute("conditionUser", conUser);
			session.setAttribute("conditionUserId", conUser.getId());
			return "/login_success";
		}else{
			return "/login_failure";
		}
		
	}
	
	@RequestMapping(value="/register")
	public String register(User user,@RequestParam("image") CommonsMultipartFile file, HttpSession session){
		
		//获得传入图片的保存路径
		String serverPath = session.getServletContext().getRealPath("userImage");
		//获得图片的名字
		String fileName = file.getOriginalFilename();
		//重命名图片
		String uuId = UUID.randomUUID().toString();
		//2、得到文件的后缀名 .jpg
		String extendName=null;
		if(fileName.indexOf(".")!=-1){
			extendName = fileName.substring(fileName.lastIndexOf("."));
		}else{
			extendName =".jpg";
		 }
		String onlyName = uuId + extendName;
		//把图片名字保存到对象
		user.setUserImg(onlyName);
		//在服务器创建空白文件，准备传数据
		try {
			file.transferTo(new File(serverPath, onlyName));
			//加存到本地
			//file.transferTo(new File("E:/Ecplise/gmshopssm/src/main/webapp/userImage", onlyName));
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		//把传入的日期封装
		String year = user.getNyear();
		String month = user.getNmonth();
		Integer months = Integer.parseInt(month)+1;
		String day = user.getNday();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date birthDay = sdf.parse(year+"-"+months+"-"+day);
			user.setBornDay(birthDay);
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		//调用service方法
		int flag = userService.save(user);
		if(flag>0){
			return "/register_success";
		}else{
			return "/register";
		}
		
		
	}
	
	@RequestMapping(value="/exit")
	public ModelAndView exit(HttpSession session){
		
		session.invalidate();
		ModelAndView view = new ModelAndView("user/user_exit");
		return view;
		
		
	}
	
	@RequestMapping(value="/userdingdan")
	public ModelAndView getUserDingDaninfo(HttpSession session){
		Integer userId = (Integer) session.getAttribute("conditionUserId");
		
		ModelAndView view = new ModelAndView("user/dingdan");
		return view;
		
	}
	
	
}
