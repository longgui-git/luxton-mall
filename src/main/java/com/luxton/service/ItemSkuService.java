package com.luxton.service;

import java.util.List;

import com.luxton.pojo.LuxItemSku;
import com.luxton.utils.LuxtonResult;

public interface ItemSkuService {

	public LuxtonResult insertItemSku(List<LuxItemSku> list);
	
	public LuxtonResult getItemSkuList(Integer itemId);
	
	
	
}
