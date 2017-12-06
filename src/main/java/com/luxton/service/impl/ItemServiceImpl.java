package com.luxton.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luxton.mapper.LuxItemMapper;
import com.luxton.mapper.LuxItemPropertyMapper;
import com.luxton.mapper.LuxPropertyMapper;
import com.luxton.mapper.LuxSupplierMapper;
import com.luxton.pojo.LuxItem;
import com.luxton.pojo.LuxItemProperty;
import com.luxton.pojo.LuxProperty;
import com.luxton.pojo.LuxPropertyExample;
import com.luxton.pojo.LuxPropertyValue;
import com.luxton.pojo.LuxSupplier;
import com.luxton.pojo.common.PropertyWithValue;
import com.luxton.service.ItemService;
import com.luxton.utils.LuxtonResult;
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private LuxItemMapper itemMapper;
	
	@Autowired
	private LuxSupplierMapper supplierMapper;
	
	@Autowired
	private LuxPropertyMapper propertyMapper;
	
	@Autowired
	private LuxItemPropertyMapper ipropertyMapper;
	
	@Override
	public LuxtonResult insertItem(LuxItem item) {

		
		
		if(item.getItemId() == null) {
			itemMapper.insertSelective(item);
		}else {
			itemMapper.updateByPrimaryKeySelective(item);
		}
		
		return LuxtonResult.ok(item.getItemId());
	}

	@Override
	public LuxtonResult getItem(Integer itemId) {

		Map<String, Object> map = new HashMap<>();
		
		LuxItem item = itemMapper.selectByPrimaryKey(itemId);
		map.put("item", item);
		
		LuxSupplier supplier = supplierMapper.selectByPrimaryKey(item.getSupplierId());
		map.put("supplier", supplier);
		
		LuxPropertyExample example = new LuxPropertyExample();
		example.createCriteria().andCatIdEqualTo(item.getCatId());
		
		List<LuxProperty> propertyList = propertyMapper.selectByExample(example);
		List<PropertyWithValue> list = new ArrayList<>();
		for(LuxProperty property : propertyList) {
			PropertyWithValue pv = new PropertyWithValue();
			pv.setProperty(property);
			
			List<LuxPropertyValue> valueList = ipropertyMapper.getItemPropertyValue(property.getPropertyId());
			pv.setValues(valueList);
			
			list.add(pv);
			
		}
		
		map.put("itemProperty", list);
		
		return LuxtonResult.ok(map);
	}

	
	@Override
	public LuxtonResult getItemList() {

		return LuxtonResult.ok(itemMapper.selectByExample(null));
	}

	
	@Override
	public LuxtonResult updateItemStatus(List<Integer> list, Boolean status) {

		Boolean s = itemMapper.updateItemStatus(list, status);
		
		return LuxtonResult.ok(s);
	}

	@Override
	public LuxtonResult deleteItem(List<Integer> list) {
		//删除对应的广告，sku？，item_property,
		
		
		return null;
	}
	
	
	
	
	
	
	
	
	

	@Override
	public LuxtonResult insertItemProperty(List<PropertyWithValue> list ,Integer itemId) {

		for(PropertyWithValue pv : list) {
			for(LuxPropertyValue value : pv.getValues()) {
				
				LuxItemProperty ip = new LuxItemProperty();
				ip.setIsSku(pv.getProperty().getIsSale());
				ip.setIpropertyId(pv.getProperty().getPropertyId());
				ip.setItemId(itemId);
				ip.setPropertyValueId(value.getPropertyValueId());
				
				ipropertyMapper.insertSelective(ip);
				
			}
		}
		
		return LuxtonResult.ok();
	}

	
	
	
	
	
	
	
}
