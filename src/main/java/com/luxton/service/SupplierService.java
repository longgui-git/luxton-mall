package com.luxton.service;

import com.luxton.pojo.LuxSupplier;
import com.luxton.utils.LuxtonResult;

public interface SupplierService {

	public LuxtonResult insertSupplier(LuxSupplier supplier);
	
	public LuxtonResult getSupplierList();
	
	public LuxtonResult deleteSupplier(Integer supplierId);
	
	
	public LuxtonResult getIndexSupplier();
}
