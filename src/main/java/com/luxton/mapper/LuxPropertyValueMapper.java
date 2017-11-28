package com.luxton.mapper;

import com.luxton.pojo.LuxPropertyValue;
import com.luxton.pojo.LuxPropertyValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LuxPropertyValueMapper {
    int countByExample(LuxPropertyValueExample example);

    int deleteByExample(LuxPropertyValueExample example);

    int deleteByPrimaryKey(Integer propertyValueId);

    int insert(LuxPropertyValue record);

    int insertSelective(LuxPropertyValue record);

    List<LuxPropertyValue> selectByExample(LuxPropertyValueExample example);

    LuxPropertyValue selectByPrimaryKey(Integer propertyValueId);

    int updateByExampleSelective(@Param("record") LuxPropertyValue record, @Param("example") LuxPropertyValueExample example);

    int updateByExample(@Param("record") LuxPropertyValue record, @Param("example") LuxPropertyValueExample example);

    int updateByPrimaryKeySelective(LuxPropertyValue record);

    int updateByPrimaryKey(LuxPropertyValue record);
}