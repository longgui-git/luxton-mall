package com.luxton.mapper;

import com.luxton.pojo.LuxItem;
import com.luxton.pojo.LuxItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LuxItemMapper {
    int countByExample(LuxItemExample example);

    int deleteByExample(LuxItemExample example);

    int deleteByPrimaryKey(Integer itemId);

    int insert(LuxItem record);

    int insertSelective(LuxItem record);

    List<LuxItem> selectByExample(LuxItemExample example);

    LuxItem selectByPrimaryKey(Integer itemId);

    int updateByExampleSelective(@Param("record") LuxItem record, @Param("example") LuxItemExample example);

    int updateByExample(@Param("record") LuxItem record, @Param("example") LuxItemExample example);

    int updateByPrimaryKeySelective(LuxItem record);

    int updateByPrimaryKey(LuxItem record);
    
    
    Boolean updateItemStatus(@Param("list") List<Integer> list, @Param("status") Boolean status);
    
    List<LuxItem> getItemBySearchId(@Param("propertyValueId") Integer propertyValueId,@Param("orderType") String orderType ,@Param("order") String order);
    
    
}