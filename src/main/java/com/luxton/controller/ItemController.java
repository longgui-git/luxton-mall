package com.luxton.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luxton.pojo.LuxItem;
import com.luxton.pojo.common.PropertyWithValue;
import com.luxton.service.ItemService;
import com.luxton.utils.LuxtonResult;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/insert")
	@ResponseBody
	public LuxtonResult insertItem(LuxItem item) {
		
		LuxtonResult result = itemService.insertItem(item);
		
		return result;
	}
	
	
	@RequestMapping("/get/{itemId}")
	@ResponseBody
	public LuxtonResult getItem(@PathVariable Integer itemId) {
		
		LuxtonResult result = itemService.getItem(itemId);
		
		return result;
	}
	
	
	@RequestMapping("/insert/property/{itemId}")
	@ResponseBody
	public LuxtonResult insertItemProperty(List<PropertyWithValue> list, @PathVariable Integer itemId) {
		
		LuxtonResult result = itemService.insertItemProperty(list, itemId);
		
		return result;
	}
	
	
	
	
}
