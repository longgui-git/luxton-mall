package com.luxton.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luxton.mapper.LuxItemSkuMapper;
import com.luxton.pojo.LuxItemSku;
import com.luxton.pojo.LuxItemSkuExample;
import com.luxton.service.ItemSkuService;
import com.luxton.utils.LuxtonResult;
@Service
public class ItemSkuServiceImpl implements ItemSkuService {

	@Autowired
	private LuxItemSkuMapper skuMapper;
	
	@Override
	public LuxtonResult insertItemSku(List<LuxItemSku> list) {

		for(LuxItemSku sku : list) {
			if(sku.getSkuId() == null) {
				skuMapper.insertSelective(sku);
			}else {
				skuMapper.updateByPrimaryKeySelective(sku);
			}
		}
		
		return LuxtonResult.ok();
	}

	@Override
	public LuxtonResult getItemSkuList(Integer itemId) {

		LuxItemSkuExample example = new LuxItemSkuExample();
		example.createCriteria().andItemIdEqualTo(itemId);
		
		List<LuxItemSku> list = skuMapper.selectByExample(example);
		
		return LuxtonResult.ok(list);
	}

	@Override
	public LuxtonResult updateSkuValue(List<LuxItemSku> list) {

		for(LuxItemSku sku : list){
			skuMapper.updateByPrimaryKeySelective(sku);
		}
		
		return LuxtonResult.ok();
	}

}
