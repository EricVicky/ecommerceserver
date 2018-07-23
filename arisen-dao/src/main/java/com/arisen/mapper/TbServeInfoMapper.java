package com.arisen.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.arisen.pojo.TbServeInfo;
import com.arisen.pojo.TbUser;

public interface TbServeInfoMapper {

	@Insert("insert into tb_serve_info (start_serve_time,end_serve_time,daily_serve_time,user_id) VALUES "
			+ "(#{serveInfo.startServeTime},#{serveInfo.endServeTime},#{serveInfo.dailyServeTime},#{serveInfo.userId})")
    void addServeInfo(@Param("serveInfo") TbServeInfo serveInfo);
	
	@Update("update tb_serve_info set start_serve_time=#{serveInfo.startServeTime},end_serve_time=#{serveInfo.endServeTime},"
			+ "daily_serve_time=#{serveInfo.dailyServeTime} where user_id=#{serveInfo.userId}")
    void updateServeInfo(@Param("serveInfo") TbServeInfo serveInfo);
	
	@Select("select tbsi.id id,tbsi.start_serve_time startServeTime,tbsi.end_serve_time endServeTime,tbsi.daily_serve_time dailyServeTime,"
			+ "tbsi.user_id userId from tb_serve_info tbsi")
	List<TbServeInfo> getAllServeInfo();
	
	@Select("select tbsi.id id,tbsi.start_serve_time startServeTime,tbsi.end_serve_time endServeTime,tbsi.daily_serve_time dailyServeTime,"
			+ "tbsi.user_id userId from tb_serve_info tbsi where tbsi.user_id=#{user_id}")
	TbServeInfo getServeInfoById(Integer user_id);
	
	
}
