package com.luxton.service.impl.pc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luxton.mapper.LuxItemMapper;
import com.luxton.mapper.LuxItemPropertyMapper;
import com.luxton.mapper.LuxItemSkuMapper;
import com.luxton.mapper.LuxPropertyMapper;
import com.luxton.mapper.LuxSupplierMapper;
import com.luxton.pojo.LuxItem;
import com.luxton.pojo.LuxItemExample;
import com.luxton.pojo.LuxItemSku;
import com.luxton.pojo.LuxProperty;
import com.luxton.pojo.LuxPropertyExample;
import com.luxton.pojo.LuxPropertyValue;
import com.luxton.pojo.LuxSupplier;
import com.luxton.pojo.common.DataWithPageResults;
import com.luxton.pojo.common.ItemWithPicList;
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
		ItemWithPicList itemPic = new ItemWithPicList();
		BeanUtils.copyProperties(item, itemPic);
		
		if(item.getPicDetailed() != null) {
			itemPic.setPicList(JSON.parseArray(item.getPicDetailed(), String.class));
		}
		
		map.put("item", itemPic);
		
		LuxSupplier supplier = supplierMapper.selectByPrimaryKey(item.getSupplierId());
		map.put("supplier", supplier);
		
		LuxPropertyExample example = new LuxPropertyExample();
		example.createCriteria().andCatIdEqualTo(item.getCatId()).andIsSaleEqualTo(true);
		
		List<LuxProperty> propertyList = propertyMapper.selectByExample(example);
		List<PropertyWithValue> list = new ArrayList<>();
		for(LuxProperty property : propertyList) {
			PropertyWithValue pv = new PropertyWithValue();
			pv.setProperty(property);
			
			List<LuxPropertyValue> valueList = ipropertyMapper.getItemPropertyValue(property.getPropertyId(),itemId);
			pv.setValues(valueList);
			
			list.add(pv);
			
		}
		
		map.put("itemProperty", list);
		
		return LuxtonResult.ok(map);
	}

	
	
	
	
	
	@Override
	public LuxtonResult getItemListByCatId(Integer catId, Integer page, Integer stage,String orderType ,String order) {

		//价格,时间
		
		
		PageHelper.startPage(page, stage);
		
		LuxItemExample example = new LuxItemExample();
		if(!StringUtils.isEmpty(orderType)&&!StringUtils.isEmpty(order)){
//			System.out.println("---");
			example.setOrderByClause(orderType+" "+order);
		}
		
		
		if(catId != null) {
			example.createCriteria().andCatIdEqualTo(catId).andStatusEqualTo(true);
		}
		
		List<LuxItem> list = itemMapper.selectByExample(example);
		
		DataWithPageResults data = new DataWithPageResults();
		
		data.setRows(list);
		
		PageInfo<LuxItem> info = new PageInfo<>(list);
		data.setTotal(info.getTotal());
		
		return LuxtonResult.ok(data);
	}




	@Override
	public LuxtonResult getItemListBySearchId(Integer propertyValueId, Integer page, Integer stage,String orderType ,String order) {

		PageHelper.startPage(page, stage);
		
//		System.out.println("--"+propertyValueId);
		List<LuxItem> list = itemMapper.getItemBySearchId(propertyValueId,orderType,order);
		
		DataWithPageResults data = new DataWithPageResults();
		
		data.setRows(list);
		
		PageInfo<LuxItem> info = new PageInfo<>();
		data.setTotal(info.getTotal());
		
		return LuxtonResult.ok(data);
	}






	@Override
	public LuxtonResult getItemListBySupplierId(Integer supplierId, Integer page, Integer stage,String orderType ,String order) {

		PageHelper.startPage(page, stage);
		
		LuxItemExample example = new LuxItemExample();
		if(!StringUtils.isEmpty(orderType)&&!StringUtils.isEmpty(order)){
			example.setOrderByClause(orderType+" "+order);
		}
		
		if(supplierId != null) {
			example.createCriteria().andSupplierIdEqualTo(supplierId);
		}
		
		List<LuxItem> list = itemMapper.selectByExample(example);
		
		DataWithPageResults data = new DataWithPageResults();
		
		data.setRows(list);
		
		PageInfo<LuxItem> info = new PageInfo<>();
		data.setTotal(info.getTotal());
		
		return LuxtonResult.ok(data);
	}



	
	



	@Override
	public LuxtonResult getItemSku(Integer itemId ,String properties) {

		LuxItemSku sku = skuMapper.getSkuInfo(itemId, properties);
		
		return LuxtonResult.ok(sku);
	}
	
	
	

}
