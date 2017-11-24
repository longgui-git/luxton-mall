package com.luxton.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luxton.pojo.LuxSupplier;
import com.luxton.service.SupplierService;
import com.luxton.utils.LuxtonResult;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	private SupplierService supplierService;
	
	@RequestMapping("/insert")
	@ResponseBody
	public LuxtonResult insertSupplier(@RequestBody LuxSupplier supplier){
		
		LuxtonResult result = supplierService.insertSupplier(supplier);
		
		return result;
	}
	
	
	@RequestMapping("/get/list")
	@ResponseBody
	public LuxtonResult getSupplierList(){
		
		LuxtonResult result = supplierService.getSupplierList();
		
		return result;
	}
	
	@RequestMapping("/delete/{supplierId}")
	@ResponseBody
	public LuxtonResult deleteSupplier(@PathVariable Integer supplierId){
		
		LuxtonResult result = supplierService.deleteSupplier(supplierId);
		
		return result;
	}
	
	
	
}
