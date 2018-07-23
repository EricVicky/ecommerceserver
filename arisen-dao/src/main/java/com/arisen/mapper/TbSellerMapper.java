package com.arisen.mapper;

import com.arisen.pojo.TbGoods;
import com.arisen.pojo.TbSeller;
import com.arisen.pojo.TbSellerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TbSellerMapper {
    int countByExample(TbSellerExample example);

    int deleteByExample(TbSellerExample example);

    int deleteByPrimaryKey(String sellerId);

    int insert(TbSeller record);

    int insertSelective(TbSeller record);

    List<TbSeller> selectByExample(TbSellerExample example);

    TbSeller selectByPrimaryKey(String sellerId);

    int updateByExampleSelective(@Param("record") TbSeller record, @Param("example") TbSellerExample example);

    int updateByExample(@Param("record") TbSeller record, @Param("example") TbSellerExample example);

    int updateByPrimaryKeySelective(TbSeller record);

    int updateByPrimaryKey(TbSeller record);
    
/////////////////////////////////////////////////////////////////////////////////////////////
//////////customer function////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
    
    @Select("select tbs.seller_id sellerId,tbs.name name,tbs.nick_name nickName,tbs.password password,tbs.email email,"
    		+ "tbs.mobile mobile,tbs.telephone telephone,tbs.status status,tbs.address_detail addressDetail,tbs.linkman_name linkmanName,"
    		+ "tbs.linkman_qq linkmanQq,tbs.linkman_mobile linkmanMobile,tbs.linkman_email linkmanEmail,tbs.license_number licenseNumber,"
    		+ "tbs.tax_number taxNumber,tbs.org_number orgNumber,tbs.address address,tbs.logo_pic logoPic,tbs.brief brief,tbs.create_time createTime,"
    		+ "tbs.legal_person legalPerson,tbs.legal_person_card_id legalPersonCardId,tbs.bank_user bankUser,tbs.bank_name bankName,tbs.permitted permitted from tb_seller tbs")
    List<TbSeller> getAllSellerInfo();
    
    @Select("select tbs.seller_id sellerId,tbs.name name,tbs.nick_name nickName,tbs.password password,tbs.email email,"
    		+ "tbs.mobile mobile,tbs.telephone telephone,tbs.status status,tbs.address_detail addressDetail,tbs.linkman_name linkmanName,"
    		+ "tbs.linkman_qq linkmanQq,tbs.linkman_mobile linkmanMobile,tbs.linkman_email linkmanEmail,tbs.license_number licenseNumber,"
    		+ "tbs.tax_number taxNumber,tbs.org_number orgNumber,tbs.address address,tbs.logo_pic logoPic,tbs.brief brief,tbs.create_time createTime,"
    		+ "tbs.legal_person legalPerson,tbs.legal_person_card_id legalPersonCardId,tbs.bank_user bankUser,tbs.bank_name bankName,tbs.permitted permitted from tb_seller tbs"
    		+ " where tbs.permitted=#{permitted}")
    List<TbSeller> getPermittedSellerInfo(String permitted);
    
}