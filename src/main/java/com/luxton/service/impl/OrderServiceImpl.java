package com.luxton.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luxton.mapper.LuxOrderItemMapper;
import com.luxton.mapper.LuxOrderMapper;
import com.luxton.pojo.LuxOrder;
import com.luxton.pojo.LuxOrderItem;
import com.luxton.pojo.common.DataWithPageResults;
import com.luxton.pojo.common.OrderWithItemList;
import com.luxton.service.OrderService;
import com.luxton.utils.LuxtonResult;
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private LuxOrderMapper orderMapper;
	
	@Autowired
	private LuxOrderItemMapper oitemMapper;
	
	@Override
	public LuxtonResult getOrderList(Integer status,Integer page,Integer stage) {

		PageHelper.startPage(page,stage);
		
		List<OrderWithItemList> list = null;
		if(status == null){
			list = orderMapper.getOrderList();
		}else{
			list = orderMapper.getOrderListByStatus(status);
		}
		
		
				
		List<OrderWithItemList> listResult = new ArrayList<>();
		
		for(OrderWithItemList order : list){
			
			List<LuxOrderItem> items = oitemMapper.getByOrderId(order.getOrderId());
			order.setItems(items);
			
			listResult.add(order);
		}
		
		DataWithPageResults data = new DataWithPageResults();
		data.setRows(listResult);
		
		PageInfo<OrderWithItemList> info = new PageInfo<>(list);
		data.setTotal(info.getTotal());
		
		return LuxtonResult.ok(data);
	}

	@Override
	public LuxtonResult getOrderByOrderId(String orderId) {

		LuxOrder order = orderMapper.selectByPrimaryKey(orderId);
		if(order == null){
			return LuxtonResult.ok();
		}
		OrderWithItemList orderItem = new OrderWithItemList();
		orderItem.setCreateTime(order.getCreateTime());
		orderItem.setEndTime(order.getEndTime());
		orderItem.setOrderId(orderId);
		orderItem.setPayment(order.getPayment());
		
		List<LuxOrderItem> items = oitemMapper.getByOrderId(order.getOrderId());
		orderItem.setItems(items);
		
		List<OrderWithItemList> listResult = new ArrayList<>();
		listResult.add(orderItem);
		
		return LuxtonResult.ok(listResult);
	}

	@Override
	public LuxtonResult updateOrderStatus(String orderId, Boolean status) {

		orderMapper.updateOrderStatus(orderId, status);
		
		return LuxtonResult.ok();
	}
	
	
	

}
