package com.luoyi.cn.dao.model;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

public class Product {
    private Long id;

    private String name;

    private Float price;

    private Float freight;
    /**
	 * 失效时间
	 */
   
    private Date expireTime;
    /**
	 * 销售量
	 */
    private Integer sellNum;
    /**
	 * 库存量
	 */
    private Integer stockNum;

    private String sellAddress;

    private Integer viewNum;

    private Long categoryId;
    
    //图片
    private String image;
    /**
   	 * 商品图片集合
   	 */ 
    private Set<Image> images = new HashSet<Image>();
	/**
	 * 商品分类
	 */
	private Category category;

	//剩余时间
	private String deadline;
	
	
	
	
	
	public String getDeadline() {
		
		Date date = new Date();
		Long min = null;
		String deadline = null;
		min = date.getTime() - getExpireTime().getTime();
		if(min < 0){
			deadline = "该商品已过期";
		}else{
			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(min);
			int day = c.get(Calendar.DATE);
			int hour = c.get(Calendar.HOUR);
			int minute = c.get(Calendar.MINUTE);
			int second = c.get(Calendar.SECOND);
			deadline =  day + "天 " + hour + " 小时  " + minute + " 分 " + second + "秒";
		}
		
		return deadline;
	}




	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}




	public Product() {
		super();
	}
	
	
	

	public Product(String name, Float price, Float freight, Integer stockNum, String sellAddress) {
		super();
		this.name = name;
		this.price = price;
		this.freight = freight;
		this.stockNum = stockNum;
		this.sellAddress = sellAddress;
	}




	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Image> getImages() {
		return images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getFreight() {
        return freight;
    }

    public void setFreight(Float freight) {
        this.freight = freight;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Integer getSellNum() {
        return sellNum;
    }

    public void setSellNum(Integer sellNum) {
        this.sellNum = sellNum;
    }

    public Integer getStockNum() {
        return stockNum;
    }

    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
    }

    public String getSellAddress() {
        return sellAddress;
    }

    public void setSellAddress(String sellAddress) {
        this.sellAddress = sellAddress == null ? null : sellAddress.trim();
    }

    public Integer getViewNum() {
        return viewNum;
    }

    public void setViewNum(Integer viewNum) {
        this.viewNum = viewNum;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}