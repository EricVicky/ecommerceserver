package com.arisen.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.arisen.pojo.TbGoods;
import com.arisen.pojo.TbMarketGoods;

public interface TbMarketPriceMapper {
	
	@Insert("<script>insert into tb_market_goods (id,max_price,min_price,avg_price,vendor_name,category_name,name,update_time) "
			+ "VALUES (#{marketGoods.Id},#{marketGoods.MaxPrice},#{marketGoods.MinPrice},#{marketGoods.AvgPrice},"
			+ "#{marketGoods.VendorName},#{marketGoods.CategoryName},#{marketGoods.Name},#{marketGoods.updateTime})</script>")
    void add(@Param("marketGoods") TbMarketGoods marketGoods);
	
	@Delete("<script>Delete from tb_market_goods where 1=1</script>")
	void delete();
}
