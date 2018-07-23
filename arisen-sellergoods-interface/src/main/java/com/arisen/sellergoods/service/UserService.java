package com.arisen.sellergoods.service;

import java.util.List;

import com.arisen.pojo.TbUser;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface UserService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TbUser> getAllUserInfo();
	
	/**
	 * 返回当前用户列表
	 * @return
	 */
	public TbUser getCurrentUserInfo(String username);
	
	/**
	 * 返回某一组织用户列表
	 * @return
	 */
	public List<TbUser> getGroupUserInfo(String group_id);
}
