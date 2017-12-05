package com.luxton.mapper;

import com.luxton.pojo.LuxAdvertType;
import com.luxton.pojo.LuxAdvertTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LuxAdvertTypeMapper {
    int countByExample(LuxAdvertTypeExample example);

    int deleteByExample(LuxAdvertTypeExample example);

    int deleteByPrimaryKey(Integer typeId);

    int insert(LuxAdvertType record);

    int insertSelective(LuxAdvertType record);

    List<LuxAdvertType> selectByExample(LuxAdvertTypeExample example);

    LuxAdvertType selectByPrimaryKey(Integer typeId);

    int updateByExampleSelective(@Param("record") LuxAdvertType record, @Param("example") LuxAdvertTypeExample example);

    int updateByExample(@Param("record") LuxAdvertType record, @Param("example") LuxAdvertTypeExample example);

    int updateByPrimaryKeySelective(LuxAdvertType record);

    int updateByPrimaryKey(LuxAdvertType record);
}