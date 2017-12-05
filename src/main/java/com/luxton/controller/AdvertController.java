package com.luxton.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luxton.mapper.LuxAdvertMapper;
import com.luxton.pojo.LuxAdvert;
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
	
	@RequestMapping("/get/list/{advertType}")
	@ResponseBody
	public LuxtonResult getAdvertListByType(@PathVariable String advertType){
		
		LuxtonResult result = advertService.getAdvertListByType(advertType);
		return result;
	}
	
}
