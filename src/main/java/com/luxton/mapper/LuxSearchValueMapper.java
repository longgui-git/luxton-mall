package com.luxton.mapper;

import com.luxton.pojo.LuxSearchValue;
import com.luxton.pojo.LuxSearchValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LuxSearchValueMapper {
    int countByExample(LuxSearchValueExample example);

    int deleteByExample(LuxSearchValueExample example);

    int deleteByPrimaryKey(Integer searchId);

    int insert(LuxSearchValue record);

    int insertSelective(LuxSearchValue record);

    List<LuxSearchValue> selectByExample(LuxSearchValueExample example);

    LuxSearchValue selectByPrimaryKey(Integer searchId);

    int updateByExampleSelective(@Param("record") LuxSearchValue record, @Param("example") LuxSearchValueExample example);

    int updateByExample(@Param("record") LuxSearchValue record, @Param("example") LuxSearchValueExample example);

    int updateByPrimaryKeySelective(LuxSearchValue record);

    int updateByPrimaryKey(LuxSearchValue record);
}