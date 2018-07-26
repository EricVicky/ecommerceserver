package com.arisen.pojo;

import java.util.List;

public class TbMarketResponse {
	
	public String ExtraData;
	public List<TbMarketGoods> Data;
	public String Errors;
	public Integer Total;
	public String getExtraData() {
		return ExtraData;
	}
	public void setExtraData(String extraData) {
		ExtraData = extraData;
	}
	public List<TbMarketGoods> getData() {
		return Data;
	}
	public void setData(List<TbMarketGoods> data) {
		Data = data;
	}
	public String getErrors() {
		return Errors;
	}
	public void setErrors(String errors) {
		Errors = errors;
	}
	public Integer getTotal() {
		return Total;
	}
	public void setTotal(Integer total) {
		Total = total;
	}
    
    
	

}
