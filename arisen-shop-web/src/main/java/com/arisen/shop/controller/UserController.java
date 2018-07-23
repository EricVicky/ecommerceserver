package com.arisen.shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.arisen.pojo.TbSeller;
import com.arisen.pojo.TbUser;
import com.arisen.sellergoods.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/user")
@Api(value="用户接口", tags={"获取用户的信息"})
public class UserController {

	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "获取所有用户",notes="获取所有用户")
	@RequestMapping(value = "/getAllUserInfo",method = RequestMethod.GET)
	@ResponseBody
	public List<TbUser> getAllUserInfo(HttpServletRequest request){
		return userService.getAllUserInfo();
	}
	
	@ApiOperation(value = "获取当前用户",notes="获取当前用户")
	@RequestMapping(value = "/getCurrentUserInfo",method = RequestMethod.GET)
	@ResponseBody
	public TbUser getCurrentUserInfo(HttpServletRequest request,@RequestParam String username){
		return userService.getCurrentUserInfo(username);
	}
	
	@ApiOperation(value = "获取用户所属组织",notes="获取用户所属组织")
	@RequestMapping(value = "/getGroupUserInfo",method = RequestMethod.GET)
	@ResponseBody
	public List<TbUser> getGroupUserInfo(HttpServletRequest request,@RequestParam String group_id){
		return userService.getGroupUserInfo(group_id);
	}
}
