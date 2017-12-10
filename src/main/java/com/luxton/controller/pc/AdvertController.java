package com.luxton.controller.pc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luxton.service.AdvertService;
import com.luxton.utils.LuxtonResult;

@Controller
@RequestMapping("/pc/advert")
public class AdvertController {

	@Autowired
	private AdvertService advertService;
	
	@RequestMapping("/get/list/{typeId}")
	@ResponseBody
	public LuxtonResult getAdvertListByType(Integer typeId){
		
		LuxtonResult result = advertService.getAdvertListByType(typeId);
		return result;
	}
}
