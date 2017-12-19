package com.luxton.controller.pc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luxton.service.PropertyService;
import com.luxton.utils.LuxtonResult;

@Controller
@RequestMapping("/property")
public class PropertyControllerPC {

	@Autowired
	private PropertyService propertyService;
	
	
	@RequestMapping("/getSearchValue/{catId}")
	@ResponseBody
	public LuxtonResult getPropertySearchValue(@PathVariable Integer catId){
		
		LuxtonResult result = propertyService.getPropertySearchValue(catId);
		
		return result;
	}
	
	
	
}
