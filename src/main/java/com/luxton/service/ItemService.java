package com.luxton.service;

import java.util.List;

import com.luxton.pojo.LuxItem;
import com.luxton.pojo.common.PropertyWithValue;
import com.luxton.utils.LuxtonResult;

public interface ItemService {

	public LuxtonResult insertItem(LuxItem item);
	
	public LuxtonResult getItem(Integer itemId);
	
	
	public LuxtonResult insertItemProperty(List<PropertyWithValue> list ,Integer itemId);
	
}
