package com.luxton.controller.pc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	
	
	
	
}
