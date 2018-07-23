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
import com.arisen.order.service.OrderService;
import com.arisen.pojo.TbServeInfo;
import com.arisen.pojo.group.Cart;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cartList")
@Api(value="购物车接口", tags={"获取添加修改删除购物车商品"})
public class CartListController {
	
	@Autowired
	private CartService cartService;
	
	@ApiOperation(value = "向购物车中添加商品",notes="每次添加一种商品(user_id,user_name,create_time,status,goods_id,num,price)")
	@RequestMapping(value = "/addToCart",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void addToCart(HttpServletRequest request,@RequestBody Cart cart){			
		cartService.addToCart(cart);
	}
	
	@ApiOperation(value = "获取购物车中的所有商品",notes="某个用户下所有商品id,根据id再去查询商品详细信息")
	@RequestMapping(value = "/getCartList",method = RequestMethod.GET)
	@ResponseBody
	public List<Cart> getCartList(HttpServletRequest request,@RequestParam Integer user_id){
		return cartService.getCartList(user_id);
	}
	
	@ApiOperation(value = "更新购物车中商品状态",notes="如有需要更新")
	@RequestMapping(value = "/updateCartStatus",method = RequestMethod.PATCH,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void updateCartStatus(HttpServletRequest request,@RequestParam Integer user_id,@RequestParam String status){
		cartService.updateCartStatus(user_id,status);
	}
	
	@ApiOperation(value = "删除购物车中商品信息",notes="提交订单后需要删除某用户下商品信息")
	@RequestMapping(value = "/deleteCartInfo",method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteCartInfo(HttpServletRequest request,@RequestParam Integer user_id){
		cartService.deleteCartInfo(user_id);
	}
	
	
	
	

}
