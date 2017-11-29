package com.luxton.service;

import java.util.List;

import com.luxton.pojo.common.PropertyWithValue;
import com.luxton.utils.LuxtonResult;

public interface ItemPropertyService {

	public LuxtonResult insertItemProperty(List<PropertyWithValue> itemProperty);

	public LuxtonResult getItemProperty(Integer itemId);
	
}
