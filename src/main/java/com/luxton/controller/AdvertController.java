package com.luxton.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luxton.pojo.LuxAdvert;
import com.luxton.pojo.LuxAdvertType;
import com.luxton.service.AdvertService;
import com.luxton.utils.LuxtonResult;

@Controller
@RequestMapping("/advert")
public class AdvertController {

	@Autowired
	private AdvertService advertService;
	
	@RequestMapping("/insert")
	@ResponseBody
	public LuxtonResult insertAdvert(@RequestBody LuxAdvert advert){
		
		LuxtonResult result = advertService.insertAdvert(advert);
		return result;
	}
	
	@RequestMapping("/get/list")
	@ResponseBody
	public LuxtonResult getAdvertListByType(Integer typeId){
		
		LuxtonResult result = advertService.getAdvertListByType(typeId);
		return result;
	}
	
	@RequestMapping("/delete/{advertId}")
	@ResponseBody
	public LuxtonResult deleteAdvert(@PathVariable Integer advertId){
		
		LuxtonResult result = advertService.deleteAdvert(advertId);
		return result;
	}
	
	
	
	
	
	
	@RequestMapping("/type/insert")
	@ResponseBody
	public LuxtonResult insertAdvertType(@RequestBody LuxAdvertType type){
		
		LuxtonResult result = advertService.insertAdvertType(type);
		return result;
	}
	
	@RequestMapping("/type/get/list")
	@ResponseBody
	public LuxtonResult getAdvertTypeList(){
		
		LuxtonResult result = advertService.getAdvertTypeList();
		return result;
	}
	
	@RequestMapping("/type/delete/{typeId}")
	@ResponseBody
	public LuxtonResult deleteAdvertType(@PathVariable Integer typeId){
		
		LuxtonResult result = advertService.deleteAdvertType(typeId);
		return result;
	}
	
}
