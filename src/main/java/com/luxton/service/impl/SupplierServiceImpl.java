package com.luxton.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luxton.mapper.LuxSupplierMapper;
import com.luxton.pojo.LuxSupplier;
import com.luxton.pojo.LuxSupplierExample;
import com.luxton.service.SupplierService;
import com.luxton.utils.LuxtonResult;
@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private LuxSupplierMapper supplierMapper;
	
	@Override
	public LuxtonResult insertSupplier(LuxSupplier supplier) {

		if(supplier.getSupplierId()==null){
			supplier.setCreateTime(new Date());
			supplier.setUpdateTime(new Date());
			supplierMapper.insertSelective(supplier);
		}else{
			supplier.setUpdateTime(new Date());
			supplierMapper.updateByPrimaryKeySelective(supplier);
		}
		
		return LuxtonResult.ok();
	}

	@Override
	public LuxtonResult getSupplierList() {

		LuxSupplierExample example = new LuxSupplierExample();
		example.setOrderByClause("sort_num ASC");
		List<LuxSupplier> list = supplierMapper.selectByExample(example);
		
		
		return LuxtonResult.ok(list);
	}

	@Override
	public LuxtonResult deleteSupplier(Integer supplierId) {

		//得需要删除对应商品
		
		return null;
	}

	@Override
	public LuxtonResult getIndexSupplier() {

		List<LuxSupplier> list = supplierMapper.getIndexSupplier();
		
		return LuxtonResult.ok(list);
	}

	
}
