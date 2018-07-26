package com.arisen.sellergoods.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arisen.mapper.TbMarketPriceMapper;
import com.arisen.mapper.TbUserMapper;
import com.arisen.pojo.TbMarketGoods;
import com.arisen.sellergoods.service.MarketPriceService;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class MarketPriceServiceImpl implements MarketPriceService{

	@Autowired
	private TbMarketPriceMapper marketPriceMapper;
	
	@Override
	public void add(TbMarketGoods marketGoods) {
		marketPriceMapper.add(marketGoods);
		
	}

	@Override
	public void delete() {
		marketPriceMapper.delete();
		
	}

}
