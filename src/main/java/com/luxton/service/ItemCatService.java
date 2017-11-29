package com.luxton.service;

import com.luxton.pojo.LuxItemCat;
import com.luxton.utils.LuxtonResult;

public interface ItemCatService {

	public LuxtonResult insertItem(LuxItemCat cat);
	
	public LuxtonResult getItemCatList();

	public LuxtonResult getItemCat(Integer catId);
	
	
	
	
}
