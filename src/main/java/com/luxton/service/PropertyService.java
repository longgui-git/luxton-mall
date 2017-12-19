package com.luxton.service;

import com.luxton.pojo.LuxProperty;
import com.luxton.utils.LuxtonResult;

public interface PropertyService {

	public LuxtonResult insertProperty(LuxProperty property);
	
	public LuxtonResult getPropertyByCatId(Integer catId);
	
	public LuxtonResult deleteProperty(Integer propertyId);
	
	
	
	
	public LuxtonResult getPropertySearchValue(Integer catId);
	
}
