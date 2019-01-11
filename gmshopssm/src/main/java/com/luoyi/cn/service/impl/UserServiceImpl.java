package com.luoyi.cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luoyi.cn.dao.UserMapper;
import com.luoyi.cn.dao.model.User;
import com.luoyi.cn.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService  {
	@Autowired
	private UserMapper userMapper;
	
	public User getUserById(Long id) {
		return userMapper.selectByPrimaryKey(id);
	}

	public User login(User user) {
		return userMapper.login(user);
	}

	public int save(User record) {
		
		return userMapper.insertSelective(record);
	}
	
}
