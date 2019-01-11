package com.luoyi.cn.dao.uitl;

public class ShopCar {
	
	//id
	public int shopId;
	//商品id
	public Long productId;
	//商品名字
	public String shopName;
	//价格
	public float price;
	//打折
	public float discount;
	//数量
	public int number;
	//运费
	public float freight;
	
	
	
	public float getFreight() {
		return freight;
	}
	public void setFreight(float freight) {
		this.freight = freight;
	}
	public float beforeDiscount;

	public float afterDiscount;
	
	
	
	
	

	public float getBeforeDiscount() {
		return beforeDiscount;
	}
	public void setBeforeDiscount(float beforeDiscount) {
		this.beforeDiscount = beforeDiscount;
	}
	public float getAfterDiscount() {
		return afterDiscount;
	}
	public void setAfterDiscount(float afterDiscount) {
		this.afterDiscount = afterDiscount;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	
	
}
