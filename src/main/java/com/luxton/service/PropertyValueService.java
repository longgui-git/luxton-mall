package com.luxton.service;

import com.luxton.pojo.LuxPropertyValue;
import com.luxton.utils.LuxtonResult;

public interface PropertyValueService {

	public LuxtonResult insertPropertyValue(LuxPropertyValue value);
	
	public LuxtonResult deleteValue(Integer valueId);
}
