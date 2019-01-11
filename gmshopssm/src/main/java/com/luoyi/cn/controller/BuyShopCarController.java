package com.luoyi.cn.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.luoyi.cn.dao.model.Order;
import com.luoyi.cn.dao.model.Product;
import com.luoyi.cn.dao.uitl.ShopCar;
import com.luoyi.cn.service.IBuyShopService;
import com.luoyi.cn.service.IProductService;

@Controller
@RequestMapping("buyshop")
public class BuyShopCarController {
	
	@Autowired
	IProductService productService;
	@Autowired
	IBuyShopService buyShopService;
	
	//添加到临时购物车，session中
	@RequestMapping("addToCar")
	public ModelAndView addToCar(String  id,HttpSession session){
		Map<Integer,ShopCar> cars = new HashMap<Integer, ShopCar>();
		int size = 0;
		
		if(session.getAttribute("cars")!=null){
			Map<Integer,ShopCar> getCars =(Map<Integer, ShopCar>) session.getAttribute("cars");
			cars = getCars;
			int s = 0;
			Set<Integer> key = getCars.keySet();
			for (Integer integer : key) {
				s++;
				if(s==key.size()){
					size = integer+1;
				}
			}
		}else{
			size = 0;
		}

		Integer ids = Integer.parseInt(id);
		Product p = productService.getProductAndImgById(ids);
		
		
		ShopCar car = new ShopCar();
		car.setShopId(size);
		car.setProductId(p.getId());
		car.setShopName(p.getName());
		car.setPrice(p.getPrice());
		car.setNumber(1);
		car.setDiscount(5);
		car.setFreight(p.getFreight());
		
		cars.put(size, car);
		
		
		float afterDiscount = 0;
		float beforeDiscount = 0;
		for (Integer i: cars.keySet()){
			beforeDiscount = beforeDiscount +cars.get(i).getPrice()*cars.get(i).getNumber();
			afterDiscount = afterDiscount+(cars.get(i).getNumber()*cars.get(i).getDiscount()*cars.get(i).getPrice()/10);
		}
		session.setAttribute("afterDiscount", afterDiscount);
		session.setAttribute("beforeDiscount", beforeDiscount);
		
		session.setAttribute("cars", cars);
		
		ModelAndView view = new ModelAndView("addcar_sucess");
	
		return view;
	}
	
	
	//支付下单
	@RequestMapping("pay")
	public ModelAndView buyGoods(Order  order,HttpSession session){
		
		//如果登录了并且购物篮有商品才能下单成功
		if(session.getAttribute("cars")==null){
			ModelAndView view = new ModelAndView("buy_failure");
			return view;
		}
		if( session.getAttribute("conditionUserId")!=null){
			long conditionUserId = (Long) session.getAttribute("conditionUserId");
			order.setUserId(conditionUserId);
			Map<Integer,ShopCar> getSessionCars =   (Map<Integer, ShopCar>) session.getAttribute("cars");
			buyShopService.placingOfOrders(order, getSessionCars);
			ModelAndView view = new ModelAndView("buy_success");
			return view;
		}else{
			ModelAndView view = new ModelAndView("login_failure");
			return view;
		}
			
		

	}
	
	
	//删除不需要的商品
	@RequestMapping("deleteOneShop")
	@ResponseBody
	public Map deleteOneShop(String id,HttpSession session){
		//把id转换为int型
		Integer ids = Integer.parseInt(id);
		//如果session中购物车有数据，才能执行删除
		if(session.getAttribute("cars")!=null ){
			Map<Integer,ShopCar> cars = (Map<Integer, ShopCar>)session.getAttribute("cars");
			//删除选中的列
			cars.remove(ids);
			//重新放session
			session.removeAttribute("cars");
			session.setAttribute("cars", cars);
			
			float before = 0;	//原价
			float after = 0;	//优惠后的价格
			//重新计算原价和优惠价
			for (Integer i: cars.keySet()){
				before = before +cars.get(i).getPrice()*cars.get(i).getNumber();
				after = after +(cars.get(i).getNumber()*cars.get(i).getDiscount()*cars.get(i).getPrice()/10);
			}
			//更新原价和优惠价的session
			session.setAttribute("afterDiscount", after);
			session.setAttribute("beforeDiscount", before-after);

			Map map1 = new HashMap();
			map1.put("before", before);
			map1.put("after", after);
			return map1;	
		
		}
		return null;


		

	}
	
	//改变某个商品的购买数量
	@RequestMapping("changeNumber")
	@ResponseBody
	public Map changeNumber(String id,String number,HttpSession session){
		Map<Integer,ShopCar> cars = (Map<Integer, ShopCar>) session.getAttribute("cars");
		int ids = Integer.parseInt(id);
		int numbers = Integer.parseInt(number);
		
		ShopCar car = cars.get(ids);
		car.setNumber(numbers);
		
		float beforeDiscount = 0;
		float afterDiscount = 0;
		
		for (Integer i: cars.keySet()){
			beforeDiscount = beforeDiscount +cars.get(i).getPrice()*cars.get(i).getNumber();
			afterDiscount = afterDiscount +(cars.get(i).getNumber()*cars.get(i).getDiscount()*cars.get(i).getPrice()/10);
		}
		//更新原价和优惠价的session
		session.setAttribute("afterDiscount", afterDiscount);
		session.setAttribute("beforeDiscount", beforeDiscount);
		//重新放session
		session.removeAttribute("cars");
		session.setAttribute("cars", cars);
		Map map = new HashMap();
		map.put("beforeDiscount", beforeDiscount);
		map.put("afterDiscount", afterDiscount);
		
		return map;	
	}
}
