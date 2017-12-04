package com.luxton.service;

import com.luxton.pojo.LuxAdvert;
import com.luxton.utils.LuxtonResult;

public interface AdvertService {

	public LuxtonResult insertAdvert(LuxAdvert advert);
	
	public LuxtonResult getAdvertListByType(String advertType);
	
}
