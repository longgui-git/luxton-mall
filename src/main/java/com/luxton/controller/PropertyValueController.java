package com.luxton.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luxton.pojo.LuxPropertyValue;
import com.luxton.service.PropertyValueService;
import com.luxton.utils.LuxtonResult;

@Controller
@RequestMapping("/property/value")
public class PropertyValueController {

	@Autowired
	private PropertyValueService valueService;
	
	@RequestMapping("/insert")
	@ResponseBody
	public LuxtonResult insertPropertyValue(@RequestBody LuxPropertyValue value) {
		
		LuxtonResult result = valueService.insertPropertyValue(value);
		return result;
	}
	
	@RequestMapping("/delete/{valueId}")
	@ResponseBody
	public LuxtonResult deleteValue(@PathVariable Integer valueId) {
		
		LuxtonResult result = valueService.deleteValue(valueId);
		return result;
	}
	
}
