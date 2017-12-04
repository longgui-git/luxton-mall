package com.luxton.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luxton.mapper.LuxAdvertMapper;
import com.luxton.pojo.LuxAdvert;
import com.luxton.pojo.LuxAdvertExample;
import com.luxton.service.AdvertService;
import com.luxton.utils.LuxtonResult;
@RequestMapping
public class AdvertServiceImpl implements AdvertService {

	@Autowired
	private LuxAdvertMapper advertMapper;
	
	@Override
	public LuxtonResult insertAdvert(LuxAdvert advert) {
		
		if(advert.getAdvertId() == null) {
			advertMapper.insertSelective(advert);
		}else {
			advertMapper.updateByPrimaryKeySelective(advert);
		}
		
		return LuxtonResult.ok();
	}

	@Override
	public LuxtonResult getAdvertListByType(String advertType) {

		LuxAdvertExample example = new LuxAdvertExample();
		example.createCriteria().andAdvertTypeEqualTo(advertType);
		
		List<LuxAdvert> list = advertMapper.selectByExample(example);
		
		return LuxtonResult.ok(list);
	}

}
