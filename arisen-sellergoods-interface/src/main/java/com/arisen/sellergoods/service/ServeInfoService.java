package com.arisen.sellergoods.service;

import java.util.List;

import com.arisen.pojo.TbServeInfo;
import com.arisen.pojo.group.Cart;

public interface ServeInfoService {

	public void addServeInfo(TbServeInfo serveInfo);
	
	public List<TbServeInfo> getAllServeInfo();
	
	public TbServeInfo getServeInfoById(Integer user_id);
	
}
