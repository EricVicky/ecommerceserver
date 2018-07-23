package com.arisen.mapper;

import com.arisen.pojo.TbOrder;
import com.arisen.pojo.TbOrderExample;
import com.arisen.pojo.TbOrderItem;
import com.arisen.pojo.group.Cart;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TbOrderMapper {
    int countByExample(TbOrderExample example);

    int deleteByExample(TbOrderExample example);

    int deleteByPrimaryKey(Long orderId);

    int insert(TbOrder record);

    int insertSelective(TbOrder record);

    List<TbOrder> selectByExample(TbOrderExample example);

    TbOrder selectByPrimaryKey(Long orderId);

    int updateByExampleSelective(@Param("record") TbOrder record, @Param("example") TbOrderExample example);

    int updateByExample(@Param("record") TbOrder record, @Param("example") TbOrderExample example);

    int updateByPrimaryKeySelective(TbOrder record);

    int updateByPrimaryKey(TbOrder record);
    
/////////////////////////////////////////////////////////////////////////////////////////////
//////////customer function////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
    
    @Insert("<script>insert into tb_order (order_id,payment,status,create_time,user_id,seller_id,start_serve_time,end_serve_time,daily_serve_time) VALUES"
    		+ " (#{orderId},#{order.payment},#{order.status},#{order.createTime},#{order.userId},#{order.sellerId},"
    		+ "#{order.startServeTime},#{order.endServeTime},#{order.dailyServeTime});</script>")
	void addOrder(@Param("order") TbOrder order,@Param("orderId") long orderId);
    
    @Update("<script>update tb_order tbo set tbo.order_id=#{order.orderId},tbo.payment=#{order.payment},tbo.status=#{order.status},tbo.update_time=#{order.updateTime},"
    		+ "tbo.start_serve_time=#{order.startServeTime},tbo.end_serve_time=#{order.endServeTime},tbo.daily_serve_time=#{order.dailyServeTime} where tbo.user_id=#{order.userId} and tbo.order_id=#{orderId};</script>")
	void updateOrder(@Param("order") TbOrder order);
    
    @Insert("<script>insert into tb_order_item (goods_id,order_id,title,price,num,total_fee,pic_path,seller_id) VALUES"
    		+ " (#{orderItem.goodsId},#{orderItem.orderId},#{orderItem.title},#{orderItem.price},#{orderItem.num},"
    		+ "#{orderItem.totalFee},#{orderItem.picPath},#{orderItem.sellerId});</script>")
	void addOrderItem(@Param("orderItem") TbOrderItem orderItem);
    
    @Select("<script>select tbo.order_id orderId,tbo.payment payment,tbo.status status,tbo.create_time createTime,"
    		+ "tbo.update_time updateTime,tbo.user_id userId,tbo.seller_id sellerId,tbo.start_serve_time startServeTime,"
    		+ "tbo.end_serve_time endServeTime,tbo.daily_serve_time dailyServeTime from tb_order tbo where tbo.user_id=#{user_id}</script>")
    List<TbOrder> listOrder(@Param("user_id") Integer user_id);
    
    @Select("<script>select tboi.goods_id goodsId,tboi.order_id orderId,tboi.title title,tboi.price price,"
    		+ "tboi.num num,tboi.total_fee totalFee,tboi.pic_path picPath,tboi.seller_id sellerId from tb_order_item tboi where order_id=#{order_id}</script>")
    List<TbOrderItem> listOrderItem(@Param("order_id") long order_id);
    
    @Update("<script>update tb_order set status=#{status},update_time=#{date} where order_id=#{order_id}</script>")
    void updateOrderStatus(@Param("order_id") long order_id,@Param("status") String status,@Param("date") Date date);
    
}