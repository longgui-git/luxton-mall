package com.luxton.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luxton.mapper.LuxItemCatMapper;
import com.luxton.pojo.LuxItemCat;
import com.luxton.service.ItemCatService;
import com.luxton.utils.LuxtonResult;
@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private LuxItemCatMapper catMapper;
	
	@Override
	public LuxtonResult insertItem(LuxItemCat cat) {

		if(cat.getCatId() == null){
			cat.setCreateTime(new Date());
			catMapper.insertSelective(cat);
		}else{
			catMapper.updateByPrimaryKeySelective(cat);
		}
		
		return LuxtonResult.ok(cat.getCatId());
	}

	@Override
	public LuxtonResult getItemCatList() {

		return LuxtonResult.ok(catMapper.selectByExample(null));
	}

	@Override
	public LuxtonResult getItemCat(Integer catId) {

		LuxItemCat cat = catMapper.selectByPrimaryKey(catId);
		
		return LuxtonResult.ok(cat);
	}

}
