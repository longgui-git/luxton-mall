package com.luxton.mapper;

import com.luxton.pojo.LuxItemProperty;
import com.luxton.pojo.LuxItemPropertyExample;
import com.luxton.pojo.LuxPropertyValue;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LuxItemPropertyMapper {
    int countByExample(LuxItemPropertyExample example);

    int deleteByExample(LuxItemPropertyExample example);

    int deleteByPrimaryKey(Integer ipropertyId);

    int insert(LuxItemProperty record);

    int insertSelective(LuxItemProperty record);

    List<LuxItemProperty> selectByExample(LuxItemPropertyExample example);

    LuxItemProperty selectByPrimaryKey(Integer ipropertyId);

    int updateByExampleSelective(@Param("record") LuxItemProperty record, @Param("example") LuxItemPropertyExample example);

    int updateByExample(@Param("record") LuxItemProperty record, @Param("example") LuxItemPropertyExample example);

    int updateByPrimaryKeySelective(LuxItemProperty record);

    int updateByPrimaryKey(LuxItemProperty record);
    
    
    List<LuxPropertyValue> getItemPropertyValue(@Param("propertyId") Integer propertyId,@Param("itemId") Integer itemId);
    
}