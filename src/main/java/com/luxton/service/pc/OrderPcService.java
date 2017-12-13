package com.luxton.service.pc;

import com.luxton.pojo.common.OrderWithItemList;
import com.luxton.utils.LuxtonResult;

public interface OrderPcService {

	public LuxtonResult insertOrder(OrderWithItemList order);
	
}
