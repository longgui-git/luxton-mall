package com.luxton.mapper;

import com.luxton.pojo.LuxItemProperty;
import com.luxton.pojo.LuxItemPropertyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LuxItemPropertyMapper {
    int countByExample(LuxItemPropertyExample example);

    int deleteByExample(LuxItemPropertyExample example);

    int deleteByPrimaryKey(Long itemPropertyId);

    int insert(LuxItemProperty record);

    int insertSelective(LuxItemProperty record);

    List<LuxItemProperty> selectByExampleWithBLOBs(LuxItemPropertyExample example);

    List<LuxItemProperty> selectByExample(LuxItemPropertyExample example);

    LuxItemProperty selectByPrimaryKey(Long itemPropertyId);

    int updateByExampleSelective(@Param("record") LuxItemProperty record, @Param("example") LuxItemPropertyExample example);

    int updateByExampleWithBLOBs(@Param("record") LuxItemProperty record, @Param("example") LuxItemPropertyExample example);

    int updateByExample(@Param("record") LuxItemProperty record, @Param("example") LuxItemPropertyExample example);

    int updateByPrimaryKeySelective(LuxItemProperty record);

    int updateByPrimaryKeyWithBLOBs(LuxItemProperty record);

    int updateByPrimaryKey(LuxItemProperty record);
}