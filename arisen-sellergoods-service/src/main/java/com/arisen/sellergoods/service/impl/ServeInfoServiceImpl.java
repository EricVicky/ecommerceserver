package com.arisen.sellergoods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arisen.mapper.TbServeInfoMapper;
import com.arisen.mapper.TbUserMapper;
import com.arisen.pojo.TbServeInfo;
import com.arisen.sellergoods.service.ServeInfoService;

@Service
public class ServeInfoServiceImpl implements ServeInfoService{

	@Autowired
	private TbServeInfoMapper serveInfoMapper;
	
	@Override
	public void addServeInfo(TbServeInfo serveInfo) {
		List<TbServeInfo> allServeInfo = serveInfoMapper.getAllServeInfo();
		for(int i=0;i<allServeInfo.size();i++) {
			if(serveInfo.getUserId() == allServeInfo.get(i).getUserId()) {
				serveInfoMapper.updateServeInfo(serveInfo);
				return;
			}
		}
		serveInfoMapper.addServeInfo(serveInfo);
		
	}

	@Override
	public List<TbServeInfo> getAllServeInfo() {
		return serveInfoMapper.getAllServeInfo();
	}

	@Override
	public TbServeInfo getServeInfoById(Integer user_id) {
		return serveInfoMapper.getServeInfoById(user_id);
	}

}
