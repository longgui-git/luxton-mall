package com.luxton.controller.pc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luxton.service.ItemCatService;
import com.luxton.utils.LuxtonResult;

@Controller
@RequestMapping("/pc/item/cat")
public class ItemCatControllerPC {

	@Autowired
	private ItemCatService catService;
	
	@RequestMapping("/get/list")
	@ResponseBody
	public LuxtonResult getItemCatList() {
		
		LuxtonResult result = catService.getItemCatList();
		return result;
	}
	
}
