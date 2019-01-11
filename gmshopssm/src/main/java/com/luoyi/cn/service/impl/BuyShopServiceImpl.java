package com.luoyi.cn.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luoyi.cn.dao.OrderDetailMapper;
import com.luoyi.cn.dao.OrderMapper;
import com.luoyi.cn.dao.model.Order;
import com.luoyi.cn.dao.model.OrderDetail;
import com.luoyi.cn.dao.uitl.ShopCar;
import com.luoyi.cn.service.IBuyShopService;




@Service("buyShopService")
public class BuyShopServiceImpl implements IBuyShopService {

	@Autowired
	OrderMapper orderMapper;
	@Autowired
	OrderDetailMapper orderDetailMapper;
	
	
	public int placingOfOrders(Order order, Map<Integer,ShopCar> getSessionCars) {
		
		
		
		
		orderMapper.insertSelective(order);
		//获得插入数据的id
		int orderId= orderMapper.getBackInsertId();
		//定义购物车数据集合
		//Map<Integer,OrderDetail> getCars = new HashMap<Integer, OrderDetail>();
		
		//把零时Session购物车传到OrderDetail表
		
		Set<Integer> key = getSessionCars.keySet();
		for (Integer i : getSessionCars.keySet()) {
			OrderDetail od = new OrderDetail();
			od.setBuyNum(getSessionCars.get(i).getNumber());
			od.setPrice(getSessionCars.get(i).getPrice());
			od.setOrderId((long) orderId);
			od.setProductId(getSessionCars.get(i).getProductId());
			orderDetailMapper.insertSelective(od);
		}
		
	
		
		
		/*for (ShopCar shopCar : getSessionCars) {
			
			OrderDetail od = new OrderDetail();
			od.setBuyNum(shopCar.getNumber());
			od.setPrice(shopCar.getPrice());
			od.setOrderId((long) orderId);
			od.setProductId(shopCar.getProductId());
			orderDetailMapper.insertSelective(od);
		}*/
		return 1;
	}
	
	
	
		
	
	
}
