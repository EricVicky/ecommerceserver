package com.arisen.pojo;

import java.io.Serializable;
import java.util.Date;

public class TbServeInfo implements Serializable{
	
	private int id;
	private String startServeTime;
	private String endServeTime;
	private String dailyServeTime;
	private int userId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStartServeTime() {
		return startServeTime;
	}
	public void setStartServeTime(String startServeTime) {
		this.startServeTime = startServeTime;
	}
	public String getEndServeTime() {
		return endServeTime;
	}
	public void setEndServeTime(String endServeTime) {
		this.endServeTime = endServeTime;
	}
	public String getDailyServeTime() {
		return dailyServeTime;
	}
	public void setDailyServeTime(String dailyServeTime) {
		this.dailyServeTime = dailyServeTime;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
	

}
