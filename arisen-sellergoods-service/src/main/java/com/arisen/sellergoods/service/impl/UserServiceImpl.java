package com.arisen.sellergoods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arisen.mapper.TbUserMapper;
import com.arisen.pojo.TbUser;
import com.arisen.sellergoods.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private TbUserMapper userMapper;

	@Override
	public List<TbUser> getAllUserInfo() {
		return userMapper.getAllUserInfo();
	}

	@Override
	public TbUser getCurrentUserInfo(String username) {
		return userMapper.getCurrentUserInfo(username);
	}

	@Override
	public List<TbUser> getGroupUserInfo(String group_id) {
		return userMapper.getGroupUserInfo(group_id);
	}
}
