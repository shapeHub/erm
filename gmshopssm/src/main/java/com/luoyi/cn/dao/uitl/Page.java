package com.luoyi.cn.dao.uitl;

import java.util.List;

public class Page<T> {
	/*当前页码，从客户端得到，手工赋值*/
	private int currentPage;
	/*总页数，计算得到*/
	private int totalPage;
	/*总记录数，从数据库得到*/
	private int count;
	/*每页的记录条数，从客户端得到，手工赋值*/
	private int pageSize;
	/*每页的详细记录数，从数据库查询得到*/
	private List<T> lists ;
	
	
	
	public Page() {
		super();
		
	}
	
	public Page(int currentPage, int count, int pageSize, List<T> lists) {
		super();
		this.currentPage = currentPage;
		this.count = count;
		this.pageSize = pageSize;
		this.lists = lists;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		//计算页数
		if(count%pageSize==0){
			totalPage = count/pageSize;
		}else{
			totalPage = count/pageSize+1;
		}
		return totalPage;
	}
	
//	public void setTotalPage(int totalPage) {
//		this.totalPage = totalPage;
//	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getLists() {
		return lists;
	}
	public void setLists(List<T> lists) {
		this.lists = lists;
	}
	
	
	
}