package com.arisen.pojo;

import java.util.Date;

public class TbMarketGoods {
	
	public Integer Id;
	//public Integer No;
	//public Integer VendorId;
	public String VendorName;
	public Float MaxPrice;
	public Float MinPrice;
	public Float AvgPrice;
//	//public Float SMouthAvgPrice;
//	public Float linkRelativeRatioPrice;
//	public Float YearBasisPirce;
//	public String CollectionTime;
//	public String CollectionTerminal;
//	public String CollectionIp;
//	public String Note;
//	public String MarketDescribe;
//	public Integer Isverified;
//	public Integer FRegionId;
//	public String FCounty;
//	public Integer CategoryId;
	public String CategoryName;
//	public Integer ProductId ;
	public String Name;
//	public String Spec;
//	public String Unit;
//	public Integer TradeQty;
//	public Integer STradeQty;
//	public Integer YearBasisTradeQty;
//	public Integer linkRelativeRatioSTradeQty;
//	public Integer TradeQtyFLocal;
//	public Integer TradeQtyFForeign;
//	public Integer TradeQtyTLocal;
//	public Integer TradeQtyTForeign;
//	public String FInsertTime;
//	public Integer FInsertPartyID;
//	public String FInsertPartyNote;
//	public String FUpdateTime;
//	public Integer FUpdatePartyID;
//	public String FUpdatePartyNote;
	public Date updateTime;
	
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getVendorName() {
		return VendorName;
	}
	public void setVendorName(String vendorName) {
		VendorName = vendorName;
	}
	public Float getMaxPrice() {
		return MaxPrice;
	}
	public void setMaxPrice(Float maxPrice) {
		MaxPrice = maxPrice;
	}
	public Float getMinPrice() {
		return MinPrice;
	}
	public void setMinPrice(Float minPrice) {
		MinPrice = minPrice;
	}
	public Float getAvgPrice() {
		return AvgPrice;
	}
	public void setAvgPrice(Float avgPrice) {
		AvgPrice = avgPrice;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}

	
}
