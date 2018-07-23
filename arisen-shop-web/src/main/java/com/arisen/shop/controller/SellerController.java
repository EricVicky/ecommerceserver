package com.arisen.shop.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.arisen.pojo.TbGoods;
import com.arisen.pojo.TbSeller;
import com.arisen.sellergoods.service.SellerService;

import entity.PageResult;
import entity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/seller")
@Api(value="商家接口", tags={"获取商家的信息"})
public class SellerController {

	@Autowired
	private SellerService sellerService;
	
//	/**
//	 * 返回全部列表
//	 * @return
//	 */
//	@RequestMapping("/findAll")
//	public List<TbSeller> findAll(){			
//		return sellerService.findAll();
//	}
//	
//	
//	/**
//	 * 返回全部列表
//	 * @return
//	 */
//	@RequestMapping("/findPage")
//	public PageResult findPage(int page,int rows){			
//		return sellerService.findPage(page, rows);
//	}
//	
//	/**
//	 * 增加
//	 * @param seller
//	 * @return
//	 */
//	@RequestMapping("/add")
//	public Result add(@RequestBody TbSeller seller){
//		try {
//			
//			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//			seller.setPassword(passwordEncoder.encode(seller.getPassword()));
//			
//			sellerService.add(seller);
//			return new Result(true, "增加成功");
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new Result(false, "增加失败");
//		}
//	}
//	
//	/**
//	 * 修改
//	 * @param seller
//	 * @return
//	 */
//	@RequestMapping("/update")
//	public Result update(@RequestBody TbSeller seller){
//		try {
//			sellerService.update(seller);
//			return new Result(true, "修改成功");
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new Result(false, "修改失败");
//		}
//	}	
//	
//	/**
//	 * 获取实体
//	 * @param id
//	 * @return
//	 */
//	@RequestMapping("/findOne")
//	public TbSeller findOne(String id){
//		return sellerService.findOne(id);		
//	}
//	
//	/**
//	 * 批量删除
//	 * @param ids
//	 * @return
//	 */
//	@RequestMapping("/delete")
//	public Result delete(String [] ids){
//		try {
//			sellerService.delete(ids);
//			return new Result(true, "删除成功"); 
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new Result(false, "删除失败");
//		}
//	}
//	
//		/**
//	 * 查询+分页
//	 * @param brand
//	 * @param page
//	 * @param rows
//	 * @return
//	 */
//	@RequestMapping("/search")
//	public PageResult search(@RequestBody TbSeller seller, int page, int rows  ){
//		return sellerService.findPage(seller, page, rows);		
//	}
	
/////////////////////////////////////////////////////////////////////////////////////////////
//////////customer function////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
	
	@ApiOperation(value = "获取所有商家信息",notes="用于列出首页中的所有商家信息")
	@RequestMapping(value = "/getAllSellerInfo",method = RequestMethod.GET)
	@ResponseBody
	public List<TbSeller> getAllSellerInfo(HttpServletRequest request){
		return sellerService.getAllSellerInfo();
	}
	
	@ApiOperation(value = "获取中标所有商家信息",notes="用于列出首页中中标的商家信息/今日下单中制定商家")
	@RequestMapping(value = "/getPermittedSellerInfo",method = RequestMethod.GET)
	@ResponseBody
	public List<TbSeller> getPermittedSellerInfo(HttpServletRequest request,@RequestParam String permitted){
		return sellerService.getPermittedSellerInfo(permitted);
	}
	
}
