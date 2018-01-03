package com.luxton.service.pc;

import com.luxton.pojo.common.OrderWithItemList;
import com.luxton.utils.LuxtonResult;

public interface OrderPcService {

	public LuxtonResult insertOrder(OrderWithItemList order);
	
	public LuxtonResult getOrderList(Long userId,Integer status ,Integer page,Integer stage);
	
	
}
