package com.luxton.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luxton.mapper.LuxPropertyValueMapper;
import com.luxton.pojo.LuxPropertyValue;
import com.luxton.service.PropertyValueService;
import com.luxton.utils.LuxtonResult;
@Service
public class PropertyValueServiceImpl implements PropertyValueService {

	@Autowired
	private LuxPropertyValueMapper valueMapper;
	
	@Override
	public LuxtonResult insertPropertyValue(LuxPropertyValue value) {

		valueMapper.insertSelective(value);
		
		return LuxtonResult.ok();
	}

	@Override
	public LuxtonResult deleteValue(Integer valueId) {

		valueMapper.deleteByPrimaryKey(valueId);
		
		return LuxtonResult.ok();
	}

}
