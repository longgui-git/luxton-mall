package com.luxton.mapper;

import com.luxton.pojo.LuxProperty;
import com.luxton.pojo.LuxPropertyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LuxPropertyMapper {
    int countByExample(LuxPropertyExample example);

    int deleteByExample(LuxPropertyExample example);

    int deleteByPrimaryKey(Integer propertyId);

    int insert(LuxProperty record);

    int insertSelective(LuxProperty record);

    List<LuxProperty> selectByExample(LuxPropertyExample example);

    LuxProperty selectByPrimaryKey(Integer propertyId);

    int updateByExampleSelective(@Param("record") LuxProperty record, @Param("example") LuxPropertyExample example);

    int updateByExample(@Param("record") LuxProperty record, @Param("example") LuxPropertyExample example);

    int updateByPrimaryKeySelective(LuxProperty record);

    int updateByPrimaryKey(LuxProperty record);
}