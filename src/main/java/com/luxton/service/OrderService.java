package com.luxton.service;

import javax.servlet.http.HttpServletResponse;

import com.luxton.utils.LuxtonResult;

public interface OrderService {

	public LuxtonResult getOrderList(Integer status,Integer page,Integer stage);
	
	public LuxtonResult getOrderByOrderId(String orderId);
	
	public LuxtonResult updateOrderStatus(String orderId,Integer status);
	
	
	public void exportOrder(String orderId,HttpServletResponse res);
	
}
