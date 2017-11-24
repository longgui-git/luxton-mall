package com.luxton.controller.pc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luxton.service.SupplierService;
import com.luxton.utils.LuxtonResult;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	private SupplierService supplierService;
	
	
	
	@RequestMapping("/get/list")
	@ResponseBody
	public LuxtonResult getSupplierList(){
		
		LuxtonResult result = supplierService.getSupplierList();
		
		return result;
	}
	
	@RequestMapping("/index/list")
	@ResponseBody
	public LuxtonResult getSupplierIndexList(){
		
		LuxtonResult result = supplierService.getIndexSupplier();
		
		return result;
	}
	
}
