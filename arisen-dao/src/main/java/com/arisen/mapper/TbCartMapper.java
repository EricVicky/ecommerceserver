package com.arisen.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.arisen.pojo.TbCart;
import com.arisen.pojo.group.Cart;

public interface TbCartMapper {
	
	@Insert("<script>insert into tb_cart (user_id,user_name,create_time,status,goods_id,num,price) VALUES "
			+ "(#{cart.userId},#{cart.userName},#{cart.createTime},#{cart.status},#{cart.goodsId},#{cart.num},#{cart.price});</script>")
	void addToCart(@Param("cart") Cart cart);
    
	@Select("select tbc.id id,tbc.goods_id goodsId,tbc.user_id userId,tbc.status status,tbc.create_time createTime,"
			+ "tbc.user_name userName.tbc.num num,tbc.price price from tb_cart tbc where tbc.user_id=#{user_id}")
	List<Cart> getCartList(@Param("user_id") Integer user_id);
	
	@Update("update tb_cart tbc set tbc.status=#{status} where tbc.user_id=#{user_id}")
	void updateCartStatus(@Param("user_id") Integer user_id,@Param("status") String status);
	
	@Delete("delete from tb_cart where user_id=#{user_id}")
	void deleteCartInfo(@Param("user_id") Integer user_id);
}
