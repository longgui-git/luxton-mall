package com.luxton.service;

import java.util.List;

import com.luxton.pojo.LuxItem;
import com.luxton.pojo.common.PropertyWithValue;
import com.luxton.utils.LuxtonResult;

public interface ItemService {

	public LuxtonResult insertItem(LuxItem item);
	
	public LuxtonResult getItem(Integer itemId);
	
	public LuxtonResult getItemList(Boolean status);
	
	
	public LuxtonResult updateItemStatus(List<Integer> list ,Boolean status);
	
	/**
	 * 这个是商品批量下架
	 */
	public LuxtonResult deleteItem(List<Integer> list);
	
	
	public LuxtonResult insertItemProperty(List<PropertyWithValue> list ,Integer itemId);
	
	
	/**
	 * 商品删除
	 */
	public LuxtonResult deleteItemInfo(Integer itemId);
	
	
}
