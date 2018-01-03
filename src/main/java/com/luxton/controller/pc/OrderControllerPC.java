package com.luxton.controller.pc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luxton.pojo.common.OrderWithItemList;
import com.luxton.service.pc.OrderPcService;
import com.luxton.utils.LuxtonResult;

@Controller
@RequestMapping("/pc/order")
public class OrderControllerPC {

	@Autowired
	private OrderPcService orderService;
	
	@RequestMapping("/insert")
	@ResponseBody
	private LuxtonResult insertOrder(@RequestBody OrderWithItemList order){
		
		LuxtonResult result = orderService.insertOrder(order);
		return result;
	}
	
	
	@RequestMapping("/getOrderList")
	@ResponseBody
	private LuxtonResult getOrderList(Integer status,@RequestParam(defaultValue="1") Integer page,
			@RequestParam(defaultValue="10") Integer stage){
		
		Long userId = 1L;
		LuxtonResult result = orderService.getOrderList(userId,status,page,stage);
		return result;
	}
	
	
}
