package com.luoyi.cn.service;

import com.luoyi.cn.dao.model.User;

public interface IUserService {
	
	public User getUserById(Long id);
	public User login(User user);
	public int save(User record);
}
