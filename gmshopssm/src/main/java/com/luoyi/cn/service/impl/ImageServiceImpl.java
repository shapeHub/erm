package com.luoyi.cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luoyi.cn.dao.ImageMapper;
import com.luoyi.cn.dao.model.Image;
import com.luoyi.cn.service.IImageService;

@Service("imageService")
public class ImageServiceImpl implements IImageService {

	
	@Autowired
	ImageMapper imageMapper;
	
	public Image getImageById(Long id) {
		
		return imageMapper.selectByPrimaryKey(id);
	}
	
	
}
