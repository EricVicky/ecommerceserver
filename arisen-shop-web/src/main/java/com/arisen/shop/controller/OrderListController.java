package com.arisen.shop.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.arisen.order.service.OrderService;
import com.arisen.pojo.TbOrder;
import com.arisen.pojo.TbOrderItem;
import com.arisen.pojo.TbSeller;
import com.arisen.pojo.group.Cart;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/orderList")
@Api(value="订单接口", tags={"获取添加订单以及修改订单状态"})
public class OrderListController {
	
	@Autowired
	private OrderService orderService;
	
	private long orderId;
	
	@ApiOperation(value = "列出某个用户下所有订单",notes="用于历史订单搜索")
	@RequestMapping(value = "/listOrder",method = RequestMethod.GET)
	@ResponseBody
	public List<TbOrder> listOrder(HttpServletRequest request,@RequestParam Integer user_id){
		return orderService.listOrder(user_id);
	}
	
	@ApiOperation(value = "添加订单",notes="提交订单后才添加订单暂时不可修改(order_id,payment,status,create_time,user_id,seller_id,start_serve_time,end_serve_time,daily_serve_time)")
	@RequestMapping(value = "/addOrder",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void addOrder(HttpServletRequest request,@RequestBody TbOrder order){
		this.orderId = this.generateOrderId();
		orderService.addOrder(order,this.orderId);
	}
	
	@ApiOperation(value = "修改订单",notes="暂时不可用")
	@RequestMapping(value = "/updateOrder",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void updateOrder(HttpServletRequest request,@RequestBody TbOrder order){
		orderService.updateOrder(order);
	}
	
	@ApiOperation(value = "添加订单商品列表",notes="添加订单后,需要添加该订单中的商品列表信息(goods_id,order_id,title,price,num,total_fee,pic_path,seller_id)")
	@RequestMapping(value = "/addOrderItem",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void addOrderItem(HttpServletRequest request,@RequestBody TbOrderItem orderItem){			
		orderService.addOrderItem(orderItem);
	}
	
	@ApiOperation(value = "列出某个订单商品列表",notes="列出某个订单商品列表信息")
	@RequestMapping(value = "/listOrderItem",method = RequestMethod.GET)
	@ResponseBody
	public List<TbOrderItem> listOrderItem(HttpServletRequest request,@RequestParam long order_id){
		return orderService.listOrderItem(order_id);
	}
	
	@ApiOperation(value = "更改订单状态",notes="生成订单/商家收到订单/买家确认订单等都需要更改状态")
	@RequestMapping(value = "/updateOrderStatus",method = RequestMethod.PATCH,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void updateOrderStatus(HttpServletRequest request,@RequestParam long order_id,@RequestParam String status){
		orderService.updateOrderStatus(order_id,status);
	}
	
	public long generateOrderId() {
		SimpleDateFormat myFmt = new SimpleDateFormat("yyMMddHHmmss");
		Date date = new Date();
		return Long.parseLong(myFmt.format(date));
	}

}
