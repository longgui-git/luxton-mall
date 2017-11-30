package com.luxton.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luxton.pojo.LuxProperty;
import com.luxton.service.PropertyService;
import com.luxton.utils.LuxtonResult;

@Controller
@RequestMapping("/property")
public class PropertyController {

	@Autowired
	private PropertyService propertyService;
	
	@RequestMapping("/insert")
	@ResponseBody
	public LuxtonResult insertProperty(@RequestBody LuxProperty property) {
		
		LuxtonResult result = propertyService.insertProperty(property);
		
		return result;
	}
	
	
	@RequestMapping("/get/info/{catId}")
	@ResponseBody
	public LuxtonResult getPropertyByCatId(@PathVariable Integer catId) {
		
		LuxtonResult result = propertyService.getPropertyByCatId(catId);
		
		return result;
	}
	
	
	@RequestMapping("/delete/{propertyId}")
	@ResponseBody
	public LuxtonResult deleteProperty(@PathVariable Integer propertyId) {
		
		LuxtonResult result = propertyService.deleteProperty(propertyId);
		
		return result;
	}
	
	
	
	
	
}
