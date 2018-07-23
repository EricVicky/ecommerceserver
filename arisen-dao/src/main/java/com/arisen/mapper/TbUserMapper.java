package com.arisen.mapper;

import com.arisen.pojo.TbUser;
import com.arisen.pojo.TbUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TbUserMapper {
    int countByExample(TbUserExample example);

    int deleteByExample(TbUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbUser record);

    int insertSelective(TbUser record);

    List<TbUser> selectByExample(TbUserExample example);

    TbUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbUser record, @Param("example") TbUserExample example);

    int updateByExample(@Param("record") TbUser record, @Param("example") TbUserExample example);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);
    
/////////////////////////////////////////////////////////////////////////////////////////////
//////////customer function////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
    
    @Select("select tbu.id id,tbu.username username ,tbu.password password ,tbu.phone phone ,tbu.email email ,"
    		+ "tbu.created created ,tbu.updated updated ,tbu.source_type sourceType ,tbu.nick_name nickName ,"
    		+ "tbu.name name ,tbu.status status ,tbu.head_pic headPic ,tbu.qq qq ,tbu.account_balance accountBalance ,"
    		+ "tbu.is_mobile_check isMobileCheck ,tbu.is_email_check isEmailCheck ,tbu.sex sex ,tbu.user_level userLevel ,"
    		+ "tbu.points points,tbu.experience_value experienceValue,tbu.birthday birthday,tbu.last_login_time lastLoginTime,"
    		+ "tbu.group_id groupId from tb_user tbu")
    List<TbUser> getAllUserInfo();
    
    @Select("select tbu.id id,tbu.username username ,tbu.password password ,tbu.phone phone ,tbu.email email ,"
    		+ "tbu.created created ,tbu.updated updated ,tbu.source_type sourceType ,tbu.nick_name nickName ,"
    		+ "tbu.name name ,tbu.status status ,tbu.head_pic headPic ,tbu.qq qq ,tbu.account_balance accountBalance ,"
    		+ "tbu.is_mobile_check isMobileCheck ,tbu.is_email_check isEmailCheck ,tbu.sex sex ,tbu.user_level userLevel ,"
    		+ "tbu.points points,tbu.experience_value experienceValue,tbu.birthday birthday,tbu.last_login_time lastLoginTime,"
    		+ "tbu.group_id groupId from tb_user tbu where tbu.username=#{username}")
    TbUser getCurrentUserInfo(String username);
    
    @Select("select tbu.id id,tbu.username username ,tbu.password password ,tbu.phone phone ,tbu.email email ,"
    		+ "tbu.created created ,tbu.updated updated ,tbu.source_type sourceType ,tbu.nick_name nickName ,"
    		+ "tbu.name name ,tbu.status status ,tbu.head_pic headPic ,tbu.qq qq ,tbu.account_balance accountBalance ,"
    		+ "tbu.is_mobile_check isMobileCheck ,tbu.is_email_check isEmailCheck ,tbu.sex sex ,tbu.user_level userLevel ,"
    		+ "tbu.points points,tbu.experience_value experienceValue,tbu.birthday birthday,tbu.last_login_time lastLoginTime,"
    		+ "tbu.group_id groupId from tb_user tbu where tbu.group_id=#{group_id}")
    List<TbUser> getGroupUserInfo(String group_id);
    
}