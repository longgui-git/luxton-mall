package com.luxton.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luxton.pojo.LuxItemSku;
import com.luxton.service.ItemSkuService;
import com.luxton.utils.LuxtonResult;

@Controller
@RequestMapping("/item/sku")
public class ItemSkuController {

	@Autowired
	private ItemSkuService skuService;
	
	@RequestMapping("/insert")
	@ResponseBody
	public LuxtonResult insertItemSku(@RequestBody List<LuxItemSku> list) {
		
		LuxtonResult result = skuService.insertItemSku(list);
		return result;
	}
	
	
	@RequestMapping("/get/list/{itemId}")
	@ResponseBody
	public LuxtonResult getItemSkuList(@PathVariable Integer itemId) {
		
		LuxtonResult result = skuService.getItemSkuList(itemId);
		return result;
	}
	
	
	@RequestMapping("/update")
	@ResponseBody
	public LuxtonResult updateSkuValue(@RequestBody LuxItemSku sku) {
		
		LuxtonResult result = skuService.updateSkuValue(sku);
		return result;
	}
	
}
