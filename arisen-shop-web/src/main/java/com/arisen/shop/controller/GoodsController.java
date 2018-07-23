package com.arisen.shop.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.arisen.pojo.TbGoods;
import com.arisen.pojo.group.Goods;
import com.arisen.sellergoods.service.GoodsService;

import entity.PageResult;
import entity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/goods")
@Api(value="商品接口", tags={"获取商品"})
public class GoodsController {

	@Autowired
	private GoodsService goodsService;
	
//	/**
//	 * 返回全部列表
//	 * @return
//	 */
//	@RequestMapping("/findAll")
//	public List<TbGoods> findAll(){			
//		return goodsService.findAll();
//	}
//	
//	
//	/**
//	 * 返回全部列表
//	 * @return
//	 */
//	@RequestMapping("/findPage")
//	public PageResult  findPage(int page,int rows){			
//		return goodsService.findPage(page, rows);
//	}
//	
//	/**
//	 * 增加
//	 * @param goods
//	 * @return
//	 */
//	@RequestMapping("/add")
//	public Result add(@RequestBody Goods goods){
//		try {
//			// 获得商家信息:
//			String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
//			
//			goods.getGoods().setSellerId(sellerId);
//			
//			goodsService.add(goods);
//			return new Result(true, "增加成功");
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new Result(false, "增加失败");
//		}
//	}
//	
//	/**
//	 * 修改
//	 * @param goods
//	 * @return
//	 */
//	@RequestMapping("/update")
//	public Result update(@RequestBody Goods goods){
//		// 获得商家信息:
//		String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
//		
//		Goods goods2 = goodsService.findOne(goods.getGoods().getId());
//		if(!sellerId.equals(goods2.getGoods().getSellerId()) || !sellerId.equals(goods.getGoods().getSellerId())){
//			return new Result(false, "非法操作");
//		}
//		
//		try {
//			goodsService.update(goods);
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
//	public Goods findOne(Long id){
//		return goodsService.findOne(id);		
//	}
//	
//	/**
//	 * 批量删除
//	 * @param ids
//	 * @return
//	 */
//	@RequestMapping("/delete")
//	public Result delete(Long [] ids){
//		try {
//			goodsService.delete(ids);
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
//	public PageResult search(@RequestBody TbGoods goods, int page, int rows  ){
//		
//		String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
//		goods.setSellerId(sellerId);
//		
//		return goodsService.findPage(goods, page, rows);		
//	}
	
/////////////////////////////////////////////////////////////////////////////////////////////
//////////customer function////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////

	@ApiOperation(value = "获取通过审核的指定商家的所有商品",notes="查询数据库中指定商家的商品")
	@ApiImplicitParam(name = "seller_id", value = "商家ID", paramType = "query", required = true, dataType = "String")
	@RequestMapping(value = "/listAllGoods",method = RequestMethod.GET)
	@ResponseBody
	public List<TbGoods> listAllGoods(HttpServletRequest request,@RequestParam String seller_id){
		return goodsService.listAllGoods(seller_id);
	}

	
}
