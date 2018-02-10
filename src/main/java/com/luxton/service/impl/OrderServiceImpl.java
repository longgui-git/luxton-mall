package com.luxton.service.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.joda.time.DateTime;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luxton.mapper.LuxOrderItemMapper;
import com.luxton.mapper.LuxOrderMapper;
import com.luxton.pojo.LuxOrderItem;
import com.luxton.pojo.common.DataWithPageResults;
import com.luxton.pojo.common.OrderWithItemList;
import com.luxton.pojo.common.OrderWithUserInfo;
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

//		LuxOrder order = orderMapper.selectByPrimaryKey(orderId);
		OrderWithUserInfo order = orderMapper.selectOrderWithUserInfo(orderId);
		
		if(order == null){
			return LuxtonResult.ok();
		}
		OrderWithItemList orderItem = new OrderWithItemList();
		orderItem.setCreateTime(order.getCreateTime());
		orderItem.setEndTime(order.getEndTime());
		orderItem.setOrderId(orderId);
		orderItem.setPayment(order.getPayment());
		orderItem.setName(order.getName());
		orderItem.setPhone(order.getPhone());
		orderItem.setRemark(order.getRemark());
		
		
		List<LuxOrderItem> items = oitemMapper.getByOrderId(order.getOrderId());
		orderItem.setItems(items);
		
		List<OrderWithItemList> listResult = new ArrayList<>();
		listResult.add(orderItem);
		
		return LuxtonResult.ok(listResult);
	}

	@Override
	public LuxtonResult updateOrderStatus(String orderId, Integer status) {

		orderMapper.updateOrderStatus(orderId, status);
		
		return LuxtonResult.ok();
	}

	@Override
	public void exportOrder(String orderId,HttpServletResponse res) {

		
		XWPFDocument document= new XWPFDocument();  
		  
        OutputStream out = null;
  
//        LuxOrder order = orderMapper.selectByPrimaryKey(orderId);
        OrderWithUserInfo order = orderMapper.exportOrderWithUserInfo(orderId);
//		if(order == null){
//			return ;
//		}
		
		List<LuxOrderItem> items = oitemMapper.getByOrderId(order.getOrderId());
  
  
        //基本信息表格  
        XWPFTable infoTable = document.createTable();  
        //去表格边框  
        infoTable.getCTTbl().getTblPr().unsetTblBorders();  

  
        //列宽自动分割  
        CTTblWidth infoTableWidth = infoTable.getCTTbl().addNewTblPr().addNewTblW();  
        infoTableWidth.setType(STTblWidth.DXA);  
        infoTableWidth.setW(BigInteger.valueOf(9072));  
  
  
        //表格第一行  
        XWPFTableRow infoTableRowOne = infoTable.getRow(0);  
        infoTableRowOne.getCell(0).setText("Order Number");  
        infoTableRowOne.addNewTableCell().setText(""+order.getOrderId());  
  
        //表格第二行  
        XWPFTableRow infoTableRowTwo = infoTable.createRow();  
        infoTableRowTwo.getCell(0).setText("Order Date");  
        infoTableRowTwo.getCell(1).setText(""+order.getOrderDate());  
  
        //表格第三行  
        XWPFTableRow infoTableRowThree = infoTable.createRow();  
        infoTableRowThree.getCell(0).setText("Total Amount");  
        infoTableRowThree.getCell(1).setText("$ "+order.getPayment()); 
        
      
  
        //两个表格之间加个换行  
        XWPFParagraph paragraph = document.createParagraph();  
        XWPFRun paragraphRun = paragraph.createRun();  
        paragraphRun.setText("\r");  
  
  
  
        //工作经历表格  
        XWPFTable ComTable = document.createTable();  
  
        //列宽自动分割  
        CTTblWidth comTableWidth = ComTable.getCTTbl().addNewTblPr().addNewTblW();  
        comTableWidth.setType(STTblWidth.DXA);  
        comTableWidth.setW(BigInteger.valueOf(9072));  
  
        //表格第一行  
        XWPFTableRow comTableRowOne = ComTable.getRow(0);  
        comTableRowOne.getCell(0).setText("GoodsInfo");  
        comTableRowOne.addNewTableCell().setText("itemType");  
        comTableRowOne.addNewTableCell().setText("Num"); 
        comTableRowOne.addNewTableCell().setText("Price"); 
        comTableRowOne.addNewTableCell().setText("Price Total"); 
  
        Integer goodsNum = 0;
        for(LuxOrderItem item : items){
        	goodsNum += item.getNum();
        	 //表格第二行  
            XWPFTableRow comTableRowTwo = ComTable.createRow();  
            comTableRowTwo.getCell(0).setText(""+item.getItemTitle()); 
            String[] type = item.getItemType().split("<br/>");
            comTableRowTwo.getCell(1).setText(type[0]+"\r"+type[1]);  
            comTableRowTwo.getCell(2).setText(""+item.getNum());  
            comTableRowTwo.getCell(3).setText(""+item.getPrice());  
            comTableRowTwo.getCell(4).setText(""+item.getPriceTotal());  
        }
       
        //表格第四行  
        XWPFTableRow infoTableRowFour = infoTable.createRow();  
        infoTableRowFour.getCell(0).setText("goodsNum");  
        infoTableRowFour.getCell(1).setText(""+goodsNum); 
        
  
      //表格第五行  
        XWPFTableRow infoTableRowFive = infoTable.createRow();  
        infoTableRowFive.getCell(0).setText("UserName");  
        infoTableRowFive.getCell(1).setText(""+order.getName());  
        
      //表格第六行  
        XWPFTableRow infoTableRowSix = infoTable.createRow();  
        infoTableRowSix.getCell(0).setText("TelePhone");  
        infoTableRowSix.getCell(1).setText(""+order.getPhone());  
  
      //表格第七行  
        XWPFTableRow infoTableRowSeven = infoTable.createRow();  
        infoTableRowSeven.getCell(0).setText("remark");  
        infoTableRowSeven.getCell(1).setText(""+order.getRemark());  
  
  
        
        try {
			res.reset();
			res.setContentType("application/octet-stream;charset=utf-8");
			res.setHeader("Content-Disposition", "attachment;filename="+order.getOrderId()+".docx");
			out = res.getOutputStream();
			
			//data是工作表名
//			util.exportExcel(list, "data", out);
			document.write(out);
			out.flush();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(out!=null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
        
//        System.out.println("create_table document written success.");  
		
//		return null;
	}
	
	
	

}
