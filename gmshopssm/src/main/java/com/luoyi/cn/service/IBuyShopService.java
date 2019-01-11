package com.luoyi.cn.service;

import java.util.Map;

import com.luoyi.cn.dao.model.Order;
import com.luoyi.cn.dao.uitl.ShopCar;

public interface IBuyShopService {
	
	
	public int placingOfOrders(Order order,Map<Integer,ShopCar> getCars);
	
}
