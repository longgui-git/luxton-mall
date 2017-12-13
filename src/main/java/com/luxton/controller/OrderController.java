package com.luxton.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luxton.service.OrderService;
import com.luxton.utils.LuxtonResult;

@Controller
@RequestMapping("/back/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/get/list/{page}")
	@ResponseBody
	public LuxtonResult getOrderList(Integer status ,@PathVariable Integer page 
			,@RequestParam(defaultValue="10") Integer stage) {
		
		LuxtonResult result = orderService.getOrderList(status, page, stage);
		return result;
	}
	
	
	@RequestMapping("/get/{orderId}")
	@ResponseBody
	public LuxtonResult gteOrderByOrderId(@PathVariable String orderId) {
		
		LuxtonResult result = orderService.getOrderByOrderId(orderId);
		return result;
	}
	
	
	
	@RequestMapping("/update/{orderId}/{status}")
	@ResponseBody
	public LuxtonResult updateOrderStatus(@PathVariable String orderId ,@PathVariable Boolean status) {
		
		LuxtonResult result = orderService.updateOrderStatus(orderId, status);
		return result;
	}
	
	
}
