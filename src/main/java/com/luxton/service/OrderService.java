package com.luxton.service;

import com.luxton.utils.LuxtonResult;

public interface OrderService {

	public LuxtonResult getOrderList(Integer status,Integer page,Integer stage);
	
	public LuxtonResult gteOrderByOrderId(String orderId);
	
	public LuxtonResult updateOrderStatus(String orderId,Boolean status);
	
}
