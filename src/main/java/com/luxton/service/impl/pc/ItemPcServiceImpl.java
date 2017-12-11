package com.luxton.service.impl.pc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luxton.mapper.LuxItemMapper;
import com.luxton.mapper.LuxItemPropertyMapper;
import com.luxton.mapper.LuxItemSkuMapper;
import com.luxton.mapper.LuxPropertyMapper;
import com.luxton.mapper.LuxSupplierMapper;
import com.luxton.pojo.LuxItem;
import com.luxton.pojo.LuxItemSku;
import com.luxton.pojo.LuxProperty;
import com.luxton.pojo.LuxPropertyExample;
import com.luxton.pojo.LuxPropertyValue;
import com.luxton.pojo.LuxSupplier;
import com.luxton.pojo.common.PropertyWithValue;
import com.luxton.service.pc.ItemPcService;
import com.luxton.utils.LuxtonResult;
@Service
public class ItemPcServiceImpl implements ItemPcService {

	@Autowired
	private LuxItemMapper itemMapper;
	
	@Autowired
	private LuxSupplierMapper supplierMapper;
	
	@Autowired
	private LuxPropertyMapper propertyMapper;
	
	@Autowired
	private LuxItemPropertyMapper ipropertyMapper;
	
	@Autowired
	private LuxItemSkuMapper skuMapper;
	
	@Override
	public LuxtonResult getItem(Integer itemId) {

		Map<String, Object> map = new HashMap<>();
		
		LuxItem item = itemMapper.selectByPrimaryKey(itemId);
		map.put("item", item);
		
		LuxSupplier supplier = supplierMapper.selectByPrimaryKey(item.getSupplierId());
		map.put("supplier", supplier);
		
		LuxPropertyExample example = new LuxPropertyExample();
		example.createCriteria().andCatIdEqualTo(item.getCatId()).andIsSaleEqualTo(true);
		
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
	public LuxtonResult getItemSku(Integer itemId ,String properties) {

		LuxItemSku sku = skuMapper.getSkuInfo(itemId, properties);
		
		return LuxtonResult.ok(sku);
	}
	
	
	

}
