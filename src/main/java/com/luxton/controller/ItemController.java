package com.luxton.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.luxton.pojo.common.ItemWithPicList;
import com.luxton.pojo.common.PropertyWithValue;
import com.luxton.service.ItemService;
import com.luxton.utils.ExceptionUtil;
import com.luxton.utils.LuxtonResult;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/insert")
	@ResponseBody
	public LuxtonResult insertItem(@RequestBody ItemWithPicList item) {
		
		LuxtonResult result = null;
		try {
			item.setPicDetailed(JSON.toJSONString(item.getPicList()));
			result = itemService.insertItem(item);
		} catch (Exception e) {
			System.out.println(ExceptionUtil.getStackTrace(e));
		}
		
		
		return result;
	}
	
	
	@RequestMapping("/get/list")
	@ResponseBody
	public LuxtonResult getItemList(Boolean status) {
		
		LuxtonResult result = itemService.getItemList(status);
		
		return result;
	}
	
	
	@RequestMapping("/get/{itemId}")
	@ResponseBody
	public LuxtonResult getItem(@PathVariable Integer itemId) {
		
		LuxtonResult result = itemService.getItem(itemId);
		
		return result;
	}
	
	@RequestMapping("/update/status/{status}")
	@ResponseBody
	public LuxtonResult updateItemStatus(@RequestBody List<Integer> list ,@PathVariable Boolean status) {
		
		LuxtonResult result = itemService.updateItemStatus(list, status);
		
		return result;
	}
	
	
	
	
	
	
	
	@RequestMapping("/insert/property/{itemId}")
	@ResponseBody
	public LuxtonResult insertItemProperty(@RequestBody List<PropertyWithValue> list, @PathVariable Integer itemId) {
		
		LuxtonResult result = itemService.insertItemProperty(list, itemId);
		
		
		return result;
	}
	
	
	@RequestMapping("/deleteItemInfo/{itemId}")
	@ResponseBody
	public LuxtonResult deleteItemInfo(@PathVariable Integer itemId) {
		
		LuxtonResult result = itemService.deleteItemInfo(itemId);
		
		return result;
	}
	
}
