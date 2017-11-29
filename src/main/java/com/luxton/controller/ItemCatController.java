package com.luxton.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luxton.pojo.LuxItemCat;
import com.luxton.service.ItemCatService;
import com.luxton.utils.LuxtonResult;

@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

	@Autowired
	private ItemCatService catService;
	
	@RequestMapping("/insert")
	@ResponseBody
	public LuxtonResult insertItemCat(@RequestBody LuxItemCat cat){
		
		LuxtonResult result = catService.insertItem(cat);
		
		return result;
	}
	
	@RequestMapping("/get/list")
	@ResponseBody
	public LuxtonResult getItemCatList(){
		
		LuxtonResult result = catService.getItemCatList();
		
		return result;
	}
	
	@RequestMapping("/get/{catId}")
	@ResponseBody
	public LuxtonResult getItemCat(@PathVariable Integer catId){
		
		LuxtonResult result = catService.getItemCat(catId);
		
		return result;
	}
}
