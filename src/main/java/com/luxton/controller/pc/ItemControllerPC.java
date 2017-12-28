package com.luxton.controller.pc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luxton.service.pc.ItemPcService;
import com.luxton.utils.LuxtonResult;

@Controller
@RequestMapping("/pc/item")
public class ItemControllerPC {

	@Autowired
	private ItemPcService itemService;
	
	@RequestMapping("/get/{itemId}")
	@ResponseBody
	public LuxtonResult getItem(@PathVariable Integer itemId) {
		
		LuxtonResult result = itemService.getItem(itemId);
		
		return result;
	}
	
	
	/** 
	 * @Title: getItemList 
	 * @Description: TODO
	 * @param @param page
	 * @param @param stage
	 * @param @param catId
	 * @param @return    
	 * @return LuxtonResult  
	 * 根据类目查商品列表 
	 */ 
	@RequestMapping("/searchByCatId/{page}")
	@ResponseBody
	public LuxtonResult getItemList(@PathVariable Integer page,@RequestParam(defaultValue="10") Integer stage,
			Integer catId  ,@RequestParam(defaultValue="create_time") String orderType ,
			@RequestParam(defaultValue="DESC") String order) {
		
		LuxtonResult result = itemService.getItemListByCatId(catId, page, stage, orderType ,order);
		
		return result;
	}
	
	@RequestMapping("/searchBySupplierId/{page}")
	@ResponseBody
	public LuxtonResult getItemListBySupplierId(@PathVariable Integer page,@RequestParam(defaultValue="10") Integer stage,
			Integer supplierId ,@RequestParam(defaultValue="create_time") String orderType ,
			@RequestParam(defaultValue="DESC") String order) {
		
		LuxtonResult result = itemService.getItemListBySupplierId(supplierId, page, stage, orderType ,order);
		
		return result;
	}
	
	@RequestMapping("/searchBySearchId/{page}")
	@ResponseBody
	public LuxtonResult getItemListBySearchId(@PathVariable Integer page,@RequestParam(defaultValue="10") Integer stage,
			Integer propertyValueId ,@RequestParam(defaultValue="create_time") String orderType ,
			@RequestParam(defaultValue="DESC") String order) {
		
		LuxtonResult result = itemService.getItemListBySearchId(propertyValueId, page, stage, orderType ,order);
		
		return result;
	}
	
	
	@RequestMapping("/get/sku/{itemId}")
	@ResponseBody
	public LuxtonResult getItemSku(@PathVariable Integer itemId,String properties) {
		
		LuxtonResult result = itemService.getItemSku(itemId, properties);
		
		return result;
	}
	
}
