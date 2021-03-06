package com.luxton.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luxton.mapper.LuxItemPropertyMapper;
import com.luxton.mapper.LuxPropertyMapper;
import com.luxton.mapper.LuxPropertyValueMapper;
import com.luxton.pojo.LuxProperty;
import com.luxton.pojo.LuxPropertyExample;
import com.luxton.pojo.LuxPropertyValue;
import com.luxton.pojo.LuxPropertyValueExample;
import com.luxton.pojo.common.PropertyWithValue;
import com.luxton.service.PropertyService;
import com.luxton.utils.LuxtonResult;
@Service
public class PropertyServiceImpl implements PropertyService {

	@Autowired
	private LuxPropertyMapper propertyMapper;
	
	@Autowired
	private LuxPropertyValueMapper valueMapper;
	
	@Autowired
	private LuxItemPropertyMapper ipropertyMapper;
	
	@Override
	public LuxtonResult insertProperty(LuxProperty property) {

		if(property.getIsSize() || property.getIsColor()){
			property.setIsSale(true);
		}
		
		if(property.getPropertyId() == null){
			property.setCreateTime(new Date());
			propertyMapper.insertSelective(property);
		}else{
			propertyMapper.updateByPrimaryKeySelective(property);
		}
		
		return LuxtonResult.ok(property.getPropertyId());
	}

	@Override
	public LuxtonResult getPropertyByCatId(Integer catId) {

		LuxPropertyExample example = new LuxPropertyExample();
		example.createCriteria().andCatIdEqualTo(catId);
		
		List<LuxProperty> list = propertyMapper.selectByExample(example);
		List<PropertyWithValue> listResult = new ArrayList<>();
		for(LuxProperty property : list){
			
			PropertyWithValue pv = new PropertyWithValue();
			pv.setProperty(property);
			
			LuxPropertyValueExample exampleV = new LuxPropertyValueExample();
			exampleV.createCriteria().andPropertyIdEqualTo(property.getPropertyId());
			List<LuxPropertyValue> listV = valueMapper.selectByExample(exampleV);
			
			pv.setValues(listV);
			
			listResult.add(pv);
		}
		
		return LuxtonResult.ok(listResult);
	}

	@Override
	public LuxtonResult deleteProperty(Integer propertyId) {

		LuxPropertyValueExample example = new LuxPropertyValueExample();
		example.createCriteria().andPropertyIdEqualTo(propertyId);
		
		valueMapper.deleteByExample(example);
		
		propertyMapper.deleteByPrimaryKey(propertyId);
		
		return LuxtonResult.ok();
	}

	
	
	
	
	
	
	
	
	@Override
	public LuxtonResult getPropertySearchValue(Integer catId) {
		
		LuxPropertyExample example = new LuxPropertyExample();
		example.createCriteria().andCatIdEqualTo(catId).andIsSearchEqualTo(true);
		
		List<LuxProperty> propertyList = propertyMapper.selectByExample(example);
		List<PropertyWithValue> list = new ArrayList<>();
		for(LuxProperty property : propertyList) {
			PropertyWithValue pv = new PropertyWithValue();
			pv.setProperty(property);
			
			LuxPropertyValueExample exampleV = new LuxPropertyValueExample();
			exampleV.createCriteria().andPropertyIdEqualTo(property.getPropertyId());
			List<LuxPropertyValue> valueList = valueMapper.selectByExample(exampleV);
			
			pv.setValues(valueList);
			
			list.add(pv);
			
		}
		
		
		return LuxtonResult.ok(list);
	}
	
	
	
	

}
