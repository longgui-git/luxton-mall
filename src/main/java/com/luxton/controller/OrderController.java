package com.luxton.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luxton.service.OrderService;
import com.luxton.utils.LuxtonResult;

@Controller
@RequestMapping("/back/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/get/list")
	@ResponseBody
	public LuxtonResult getOrderList(Boolean status,Integer page,Integer stage) {
		
		LuxtonResult result = orderService.getOrderList(status, page, stage);
		return result;
	}
	
	
	@RequestMapping("/get/list")
	@ResponseBody
	public LuxtonResult gteOrderByOrderId(String orderId) {
		
		LuxtonResult result = orderService.gteOrderByOrderId(orderId);
		return result;
	}
	
	
	
	@RequestMapping("/get/list/{orderId}/{status}")
	@ResponseBody
	public LuxtonResult updateOrderStatus(@PathVariable String orderId ,@PathVariable Boolean status) {
		
		LuxtonResult result = orderService.updateOrderStatus(orderId, status);
		return result;
	}
	
	
}
