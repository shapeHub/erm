package service.impl;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luoyi.cn.dao.model.Category;
import com.luoyi.cn.dao.model.User;
import com.luoyi.cn.service.ICategoryService;
import com.luoyi.cn.service.IUserService;

public class TestUserServiceImpl {
	@Test
	public void TestGetUserById(){
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-mybatis.xml"});
		IUserService  userService = (IUserService) context.getBean("userService");
		User user = userService.getUserById( 6L);
		System.out.println(user.getLoginName()+"出生于"+user.getBornDay()+"_____id="+user.getId());
		
	}
	
	@Test
	public void TestGetUserById2(){
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-mybatis.xml"});
		IUserService  userService = (IUserService) context.getBean("userService");
		User user = userService.getUserById( 3L);
		System.out.println(user.getLoginName()+"出生于"+user.getBornDay()+"_____id="+user.getId());
		
	}
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-mybatis.xml"});
		IUserService  userService = (IUserService) context.getBean("userService");
		User u = new User();
		u.setLoginName("laowang");
		u.setMyName("luyi");
		u.setPass("234");
		u.setSex("男");
		u.setEmail("123@234");
		int s = userService.save(u);
		System.out.println(s);
	}
	
	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-mybatis.xml"});
		ICategoryService categoryService = (ICategoryService) context.getBean("categoryService");
		List<Category> cateLists = categoryService.getCateLists();
		for (Category category : cateLists) {
			System.out.println(category.getName());
		}
	}
	
}
