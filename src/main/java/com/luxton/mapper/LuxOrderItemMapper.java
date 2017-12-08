package com.luxton.mapper;

import com.luxton.pojo.LuxOrderItem;
import com.luxton.pojo.LuxOrderItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LuxOrderItemMapper {
    int countByExample(LuxOrderItemExample example);

    int deleteByExample(LuxOrderItemExample example);

    int deleteByPrimaryKey(Integer orderItemId);

    int insert(LuxOrderItem record);

    int insertSelective(LuxOrderItem record);

    List<LuxOrderItem> selectByExample(LuxOrderItemExample example);

    LuxOrderItem selectByPrimaryKey(Integer orderItemId);

    int updateByExampleSelective(@Param("record") LuxOrderItem record, @Param("example") LuxOrderItemExample example);

    int updateByExample(@Param("record") LuxOrderItem record, @Param("example") LuxOrderItemExample example);

    int updateByPrimaryKeySelective(LuxOrderItem record);

    int updateByPrimaryKey(LuxOrderItem record);
    
    
    
    List<LuxOrderItem> getByOrderId(String orderId);
}