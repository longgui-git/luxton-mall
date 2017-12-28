package com.luxton.mapper;

import com.luxton.pojo.LuxOrder;
import com.luxton.pojo.LuxOrderExample;
import com.luxton.pojo.common.OrderWithItemList;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LuxOrderMapper {
    int countByExample(LuxOrderExample example);

    int deleteByExample(LuxOrderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(LuxOrder record);

    int insertSelective(LuxOrder record);

    List<LuxOrder> selectByExample(LuxOrderExample example);

    LuxOrder selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") LuxOrder record, @Param("example") LuxOrderExample example);

    int updateByExample(@Param("record") LuxOrder record, @Param("example") LuxOrderExample example);

    int updateByPrimaryKeySelective(LuxOrder record);

    int updateByPrimaryKey(LuxOrder record);
    
    
    List<OrderWithItemList> getOrderList();
    
    List<OrderWithItemList> getOrderListByStatus(Integer status);
    
    Boolean updateOrderStatus(@Param("orderId") String orderId, @Param("status") Integer status);
    
    
    
    
}