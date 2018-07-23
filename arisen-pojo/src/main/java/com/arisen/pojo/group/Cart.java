package com.arisen.pojo.group;

import java.io.Serializable;
import java.util.List;

import com.arisen.pojo.TbGoods;
import com.arisen.pojo.TbOrderItem;
import com.arisen.pojo.TbServeInfo;
/**
 * 购物车对象
 * @author Administrator
 *
 */
public class Cart implements Serializable{

	private String userId;//用户ID
	private String userName;//用户名称
	private long goodsId;//购物车商品列表
	private String status;
	private String createTime;
	private Integer num;
	private float price;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
	
	
	
}
