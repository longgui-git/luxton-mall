package com.luxton.service;

import com.luxton.pojo.LuxAdvert;
import com.luxton.pojo.LuxAdvertType;
import com.luxton.utils.LuxtonResult;

public interface AdvertService {

	public LuxtonResult insertAdvert(LuxAdvert advert);
	
	public LuxtonResult getAdvertListByType(Integer typeId);
	
	
	public LuxtonResult insertAdvertType(LuxAdvertType type);
	
	public LuxtonResult getAdvertTypeList();
	
}
