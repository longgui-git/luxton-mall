package com.luxton.pojo.common;

import java.util.List;

import com.luxton.pojo.LuxOrder;
import com.luxton.pojo.LuxOrderItem;

public class OrderWithItemList extends LuxOrder {

	private List<LuxOrderItem> items;

	public List<LuxOrderItem> getItems() {
		return items;
	}

	public void setItems(List<LuxOrderItem> items) {
		this.items = items;
	}

	
	
	
	
	
}
