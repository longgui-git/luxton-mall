package com.luxton.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luxton.mapper.LuxAdvertMapper;
import com.luxton.mapper.LuxAdvertTypeMapper;
import com.luxton.pojo.LuxAdvert;
import com.luxton.pojo.LuxAdvertExample;
import com.luxton.pojo.LuxAdvertType;
import com.luxton.pojo.common.AdvertWithItem;
import com.luxton.pojo.common.AdvertWithType;
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

		List<AdvertWithItem> list = null;
		if(typeId == null){
			list = advertMapper.getAdvertList();
		}else{
			list = advertMapper.getAdvertListByType(typeId);
		}
		
		return LuxtonResult.ok(list);
	}

	@Override
	public LuxtonResult deleteAdvert(Integer advertId) {

		advertMapper.deleteByPrimaryKey(advertId);
		
		return LuxtonResult.ok();
	}
	
	@Override
	public LuxtonResult getAllAdvert() {

		List<LuxAdvertType> list = typeMapper.selectByExample(null);
		List<AdvertWithType> listResult = new ArrayList<>();
		
		for(LuxAdvertType type : list){
			
			AdvertWithType at = new AdvertWithType();
			at.setTypeId(type.getTypeId());
			at.setTypeTitle(type.getTypeTitle());
			
			List<AdvertWithItem> advertList = advertMapper.getAdvertListByType(type.getTypeId());
			at.setAdvertList(advertList);
			
			listResult.add(at);
		}
		
		
		return LuxtonResult.ok(listResult);
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

	@Override
	public LuxtonResult deleteAdvertType(Integer typeId) {

		//先删除对应的广告，再删除类型
		LuxAdvertExample example = new LuxAdvertExample();
		example.createCriteria().andTypeIdEqualTo(typeId);
		advertMapper.deleteByExample(example);
		
		typeMapper.deleteByPrimaryKey(typeId);
		
		return LuxtonResult.ok();
	}

	
	
	
}
