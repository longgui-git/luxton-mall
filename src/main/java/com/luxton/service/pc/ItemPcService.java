package com.luxton.service.pc;

import com.luxton.utils.LuxtonResult;

public interface ItemPcService {

	public LuxtonResult getItem(Integer itemId);
	
	public LuxtonResult getItemList(Integer catId,Integer page ,Integer stage);
	
	
	
	public LuxtonResult getItemSku(Integer itemId ,String properties);
	
}
