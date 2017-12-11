package com.luxton.service.pc;

import com.luxton.utils.LuxtonResult;

public interface ItemPcService {

	public LuxtonResult getItem(Integer itemId);
	
	
	public LuxtonResult getItemSku(Integer itemId ,String properties);
	
}
