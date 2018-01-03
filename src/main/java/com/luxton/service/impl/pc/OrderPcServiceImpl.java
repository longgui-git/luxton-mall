package com.luxton.service.impl.pc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luxton.mapper.LuxOrderItemMapper;
import com.luxton.mapper.LuxOrderMapper;
import com.luxton.pojo.LuxOrderItem;
import com.luxton.pojo.common.DataWithPageResults;
import com.luxton.pojo.common.OrderWithItemList;
import com.luxton.service.pc.OrderPcService;
import com.luxton.utils.IDUtils;
import com.luxton.utils.LuxtonResult;
@Service
public class OrderPcServiceImpl implements OrderPcService {

	@Autowired
	private LuxOrderMapper orderMapper;
	
	@Autowired
	private LuxOrderItemMapper orderItemMapper;
	
	@Override
	public LuxtonResult insertOrder(OrderWithItemList order) {

		//生成订单id
		String orderId = getOrderId();
		order.setOrderId(orderId);
		
		orderMapper.insertSelective(order);
		
		for(LuxOrderItem orderItem : order.getItems()){
			
			order.setOrderId(orderId);
			orderItemMapper.insertSelective(orderItem);
		}
		
		
		return LuxtonResult.ok();
	}
	
	
	public String getOrderId(){
		
		/*
		 * 订单号生成规则
		 * 
		 * 支付方式 1位  
		 * 
		 * 时间 8位  月日时分
		 * 
		 * 随机数取4位
		 * 
		 */
		
	    String orderId = "1"+IDUtils.getNonceStr();
	    
	    return orderId;
	}


	
	@Override
	public LuxtonResult getOrderList(Long userId,Integer status,Integer page,Integer stage) {
		
		PageHelper.startPage(page,stage);
		
		List<OrderWithItemList> list = null;
		if(status == null){
			list = orderMapper.getOrderList();
		}else{
			list = orderMapper.getOrderListByStatus(status);
		}
		
		
				
		List<OrderWithItemList> listResult = new ArrayList<>();
		
		for(OrderWithItemList order : list){
			
			List<LuxOrderItem> items = orderItemMapper.getByOrderId(order.getOrderId());
			order.setItems(items);
			
			listResult.add(order);
		}
		
		DataWithPageResults data = new DataWithPageResults();
		data.setRows(listResult);
		
		PageInfo<OrderWithItemList> info = new PageInfo<>(list);
		data.setTotal(info.getTotal());
		
		return LuxtonResult.ok(data);
	}

	
	
	
	
	
	
	
	
}
