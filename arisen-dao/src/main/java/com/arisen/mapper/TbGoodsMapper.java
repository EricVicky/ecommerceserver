package com.arisen.mapper;

import com.arisen.pojo.TbGoods;
import com.arisen.pojo.TbGoodsExample;
import com.arisen.pojo.TbMarketGoods;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TbGoodsMapper {
    int countByExample(TbGoodsExample example);

    int deleteByExample(TbGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbGoods record);

    int insertSelective(TbGoods record);

    List<TbGoods> selectByExample(TbGoodsExample example);

    TbGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbGoods record, @Param("example") TbGoodsExample example);

    int updateByExample(@Param("record") TbGoods record, @Param("example") TbGoodsExample example);

    int updateByPrimaryKeySelective(TbGoods record);

    int updateByPrimaryKey(TbGoods record);
    
/////////////////////////////////////////////////////////////////////////////////////////////
//////////customer function////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
    
    @Select("select tbg.id id,tbg.seller_id sellerId,tbg.goods_name goodsName,tbg.default_item_id defaultItemId,"
    		+ "tbg.audit_status auditStatus,tbg.is_marketable isMarketable,tbg.brand_id brandId,tbg.caption caption,"
    		+ "tbg.category_id categoryId,tbg.category2_id category2Id,tbg.category2_id category2Id,"
    		+ "tbg.small_pic smallPic,tbg.price price,tbg.market_price marketPrice,tbg.type_template_id typeTemplateId,tbg.is_enable_spec isEnableSpec,"
    		+ "tbg.is_delete isDelete from tb_goods tbg where seller_id=#{seller_id}")
    List<TbGoods> listAllGoods(@Param("seller_id") String seller_id);
    
    @Select("select tbg.id id,tbg.seller_id sellerId,tbg.goods_name goodsName,tbg.default_item_id defaultItemId,"
    		+ "tbg.audit_status auditStatus,tbg.is_marketable isMarketable,tbg.brand_id brandId,tbg.caption caption,"
    		+ "tbg.category_id categoryId,tbg.category2_id category2Id,tbg.category2_id category2Id,"
    		+ "tbg.small_pic smallPic,tbg.price price,tbg.market_price marketPrice,tbg.type_template_id typeTemplateId,tbg.is_enable_spec isEnableSpec,"
    		+ "tbg.is_delete isDelete from tb_goods tbg where tbg.id=#{goods_id}")
    TbGoods getGoodsById(@Param("goods_id") long goods_id);
    
    @Update("<script>update tb_goods set market_price=#{marketGoods.AvgPrice} where goods_name=#{marketGoods.Name}</script>")
    void updateMarketPrice(@Param("marketGoods") TbMarketGoods marketGoods);
    
    
    
}