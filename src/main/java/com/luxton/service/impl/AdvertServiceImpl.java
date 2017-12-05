package com.luxton.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luxton.mapper.LuxAdvertMapper;
import com.luxton.mapper.LuxAdvertTypeMapper;
import com.luxton.pojo.LuxAdvert;
import com.luxton.pojo.LuxAdvertType;
import com.luxton.pojo.common.AdvertWithItem;
import com.luxton.service.AdvertService;
import com.luxton.utils.LuxtonResult;
@Service
public class AdvertServiceImpl implements AdvertService {

	@Autowired
	private LuxAdvertMapper advertMapper;
	
	@Autowired
	private LuxAdvertTypeMapper typeMapper;
	
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
	public LuxtonResult getAdvertListByType(Integer typeId) {

		
		List<AdvertWithItem> list = advertMapper.getAdvertList(typeId);
		
		return LuxtonResult.ok(list);
	}

	@Override
	public LuxtonResult insertAdvertType(LuxAdvertType type) {

		typeMapper.insertSelective(type);
		
		return LuxtonResult.ok();
	}

	@Override
	public LuxtonResult getAdvertTypeList() {

		List<LuxAdvertType> list = typeMapper.selectByExample(null);
		
		return LuxtonResult.ok(list);
	}

	
	
	
}
