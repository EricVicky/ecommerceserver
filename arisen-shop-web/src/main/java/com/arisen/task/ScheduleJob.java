package com.arisen.task;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.arisen.pojo.TbMarketGoods;
import com.arisen.pojo.TbMarketResponse;
import com.arisen.sellergoods.service.GoodsService;
import com.arisen.sellergoods.service.MarketPriceService;

@Configuration
@EnableScheduling
public class ScheduleJob {
	
	@Autowired
	private MarketPriceService marketPriceService;
	@Autowired
	private GoodsService goodsService;
	
	private static String MARKET_SITE_URL = "http://jgyj.zhao139.com/ProductPriceCollection/BulkEditSelect";
	
	@Scheduled(cron="0 01 22 0/1 * *")
	public void deleteMarketPriceData() {
		marketPriceService.delete();
	}
	
	@Scheduled(cron="0 02 22 0/1 * *")
	public void getMarketPrice(){
		RestTemplate client = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
		params.add("StartDate", "2018/7/25");
		params.add("EndDate", "2018/7/25");
		params.add("VendorId", "8");
		params.add("ProductId", "-1");
		params.add("take", "15");
		params.add("skip", "0");
		params.add("page", "1");
		params.add("pageSize", "100");
		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
		ResponseEntity<TbMarketResponse> response = client.exchange(MARKET_SITE_URL, HttpMethod.POST, requestEntity, TbMarketResponse.class);
		updateGoodsMarketPrice(response.getBody());
	}
	
	public void updateGoodsMarketPrice(TbMarketResponse data) {
		List<TbMarketGoods> marketGoods = data.getData();
		Date date = new Date();
		for(int i=0;i<marketGoods.size();i++) {
			//update market_goods table
			marketGoods.get(i).setUpdateTime(date);
			marketPriceService.add(marketGoods.get(i));
			//update market_price in goods table
			goodsService.updateMarketPrice(marketGoods.get(i));
			
		}
		
	}

}
