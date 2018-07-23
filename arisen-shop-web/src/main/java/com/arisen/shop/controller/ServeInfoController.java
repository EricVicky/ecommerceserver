package com.arisen.shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.arisen.cart.service.CartService;
import com.arisen.pojo.TbServeInfo;
import com.arisen.pojo.group.Cart;
import com.arisen.sellergoods.service.ServeInfoService;

@RestController
@RequestMapping("/serveInfo")
public class ServeInfoController {
	
//	@Autowired
//	private ServeInfoService serveInfoService;
//	
//	@RequestMapping(value = "/addServeInfo",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public void addCartInfo(HttpServletRequest request,@RequestBody TbServeInfo serveInfo){
//		serveInfoService.addServeInfo(serveInfo);
//	}
//	
//	@RequestMapping(value = "/getAllServeInfo",method = RequestMethod.GET)
//	@ResponseBody
//	public List<TbServeInfo> getAllServeInfo(HttpServletRequest request){
//		return serveInfoService.getAllServeInfo();
//	}
//	
//	@RequestMapping(value = "/getServeInfoById",method = RequestMethod.GET)
//	@ResponseBody
//	public TbServeInfo getServeInfoById(HttpServletRequest request,@RequestParam Integer user_id){
//		return serveInfoService.getServeInfoById(user_id);
//	}

}
